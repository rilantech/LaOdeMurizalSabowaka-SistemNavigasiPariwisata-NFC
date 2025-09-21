<?php

namespace App\Http\Controllers;

use App\Models\Akunwisatawan;
use App\Models\User;

use Illuminate\Http\Request;
use Auth;
use Illuminate\Support\Facades\Auth as FacadesAuth;
use Illuminate\Support\Facades\Hash;

class AkunpengunjungController extends Controller
{
    public function index(Request $request)
    {
        return $request->user();
    }

    public function register(Request $request)
    {
        $request->validate([
            'nama' => 'required',
            'username'=> 'required|unique:users',
            'password' => 'required'

        ]);

        $result = Akunwisatawan::create([
            'nama' => $request->nama,
            'username' => $request->username,
            'password' => bcrypt($request->password)
        ]);

        return response()->json([
            'result' => $result,
            'status' => true,
            'message' => 'Berhasil Terdaftar'
    ]);;
    }

    public function login(Request $request) {
        $this->validate($request, [
            'username' => 'required',
            'password' => 'required'
          ]);
    
          $username = $request->input('username');
          $password = $request->input('password');
    
    
          $user = Akunwisatawan::where('username', $username)->first();
       
          
          if(!$user){
            return response()->json([
                'status' => false,
                'message' => 'Login Gagal'
        ]);
    
          }

          $isValidPassword = Hash::check($password, $user->password);
          if(!$isValidPassword) {
    
            return response()->json([
                'status' => false,
                'message' => 'Gagal Masuk']);
          }
    
    
           $token = $user->createToken('auth_token')->plainTextToken;
    
           
          return response()->json([
            'status' => true,
            'message' => 'Login Berhasil',
            'data'  => $user,
            'nama'  => $user['nama']
          ]);
              
                      
    }


    public function logout(Request $request){
        $request->user()->forceFill([
            'api_token'=> null,

        ])->save();

        return response()->json(['message'=>'success']);
        
    }

    public function loginadmin(Request $request) {
        $this->validate($request, [
            'username' => 'required',
            'password' => 'required'
          ]);
    
          $username = $request->input('username');
          $password = $request->input('password');
    
    
          $admin = User::where('username', $username)->first();
       
          
          if(!$admin){
            return response()->json([
                'status' => false,
                'message' => 'Login Gagal'
        ]);
    
          }

          $isValidPassword = Hash::check($password, $admin->password);
          if(!$isValidPassword) {
    
            return response()->json([
                'status' => false,
                'message' => 'Gagal Masuk']);
          }
    
    
           $token = $admin->createToken('auth_token')->plainTextToken;
    
           
          return response()->json([
            'status' => true,
            'message' => 'Login Berhasil',
            'dataadmin'  => $admin,
            'namaadmin'  => $admin['name']
          ]);
              
                      
    }
}
