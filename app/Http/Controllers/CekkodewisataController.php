<?php

namespace App\Http\Controllers;

use App\Models\Tabeldaftarwisata;
use Illuminate\Http\Request;
use Auth;
use Illuminate\Support\Facades\Auth as FacadesAuth;
use Illuminate\Support\Facades\Hash;

class CekkodewisataController extends Controller
{
    public function index(Request $request)
    {
        // return $request->;
    }

    public function cekkodewisata(Request $request) {
        $this->validate($request, [
            'id' => 'required',
          ]);

          $kodewisata = $request->input('id');
         $kodewisata = Tabeldaftarwisata::where('id', $kodewisata)->first();

         if(!$kodewisata){
            return response()->json([
                'status' => false,
                'message' => 'Kode Wisata Tidak Terdaftar'
        ]);

            }


            return response()->json([
                'status' => true,
                'message' => 'Kode Wisata Berhasil Terbaca',
                'data'  => $kodewisata,
              ]);


        
    }

}

