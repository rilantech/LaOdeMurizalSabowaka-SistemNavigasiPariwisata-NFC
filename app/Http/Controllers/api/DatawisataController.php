<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Tabeldaftarwisata;
use Illuminate\Http\Request;
use Illuminate\Http\Response as HttpResponse;

class DatawisataController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Request $request)
    {
        //
        try{
            $datawisata = Tabeldaftarwisata::find($request->id);
            return response()->json($datawisata
                // 'kodewisata' => $datawisata->id,
                // 'kategori' => $datawisata->kategori,
                // 'namawisata' => $datawisata->namawisata,
                // 'alamat' => $datawisata->alamat,
                // 'biaya' => $datawisata->biaya,
                // 'longitude' => $datawisata->longitude,
                // 'latitude' => $datawisata->latitude,
                // 'info' => $datawisata->info,
                // 'foto' => asset('kumpulanfoto/'. $datawisata->foto)
            
            ,
 HttpResponse::HTTP_OK);
        } catch (QueryException $e){
            $error = [
                'error' => $e-> getMessage()
            ];
            return response()->json($error, 
            HttpResponse::HTTP_INTERNAL_SERVER_ERROR);
        }
        $search = $request->query('search');

    }


    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show($idwisata)
    {
        //
//         $wisata = Tabeldaftarwisata::find($idwisata);
//         if($wisata){

//         try{ 
//             return response()->json([ 
//                 'dataku'=>  $wisata
//             ],
//  HttpResponse::HTTP_OK);
//         } catch (QueryException $e){
//             $error = [
//                 'error' => $e-> getMessage()
//             ];
//             return response()->json($error, 
//             HttpResponse::HTTP_INTERNAL_SERVER_ERROR);
//         }
//     }
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}
