<?php

namespace App\Http\Controllers;

use App\Http\Requests\EditAkunWisatawanRequest;
use App\Http\Requests\TambahAkunWisatawanRequest;
use App\Models\Akunwisatawan;

use Illuminate\Http\Request;
use Illuminate\Http\Request as HttpRequest;

class AkunwisatawanController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(HttpRequest $request)
    {
        //
        $search = $request->query('search');

        if(!empty($search)){
            $akunWisatawan = Akunwisatawan::where('akunwisatawan.id','like','%'.$search.'%')
           ->orwhere('akunwisatawan.nama','like','%'.$search.'%')
           ->paginate(10)->onEachSide(2)->fragment('srv');
        }else{
            $akunWisatawan = Akunwisatawan::latest()->paginate(10)->onEachSide(2)->fragment('srv');
           
        }
      
        return view('tabel.tabeldaftarakunwisatawan')->with([
            'akunwisatawan' => $akunWisatawan,
            'search' => $search,
            'title' => 'Akun Wisatawan'
        ]);

    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(TambahAkunWisatawanRequest $request)
    {
        
        $validate = $request->validated();
       
        $akunwisatawan = new Akunwisatawan;
    
        $akunwisatawan->nama = $request->nama;
        $akunwisatawan->username = $request->username;
        $akunwisatawan->password = bcrypt($request->password);
        $akunwisatawan->save();

        return redirect('tabeldaftarakunwisatawan')->with('msg','Akun Wisatawan Berhasil Di Tambahkan !');

    }

    /**
     * Display the specified resource.
     */
    public function show(Akunwisatawan $akunwisatawan, $id)
    {
        //
        $data = $akunwisatawan->find($id);

        return view('form.editakunwisatawan')->with([

            'id' => $id,
            'nama' => $data->nama,
            'username' => $data->username,
            'password' => $data->password,
            'title' => 'Edit Akun Wisatawan'
        ]);
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(EditAkunWisatawanRequest $request, Akunwisatawan $akunwisatawan, $id)
    {
        //
        $data= $akunwisatawan->find($id);
        $data->nama = $request->nama;
        $data->username = $request->username;
        $data->password = bcrypt($request->password);
        $data->save();
    
        return redirect('tabeldaftarakunwisatawan')->with('msg','Data Berhasil Di Update');
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Akunwisatawan $akunwisatawan, $id)
    {
     
            $data = $akunwisatawan->find($id);
            $data->delete();
            return redirect('tabeldaftarakunwisatawan')->with('msg','Data Berhasil Di Hapus');

    }
}
