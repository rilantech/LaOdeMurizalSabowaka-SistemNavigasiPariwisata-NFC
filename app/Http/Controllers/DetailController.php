<?php

namespace App\Http\Controllers;
use App\Models\Tabeldaftarwisata;
use Illuminate\Http\Request;

class DetailController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
      
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
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(Tabeldaftarwisata $datawisata, $idwisata)
    {
        //
        $data = $datawisata->find($idwisata);
        

        return view('form.detailwisata')->with([

            'id' => $idwisata,
            'kodewisata' => $data->kodewisata,
            'kategori' => $data->kategori,
            'namawisata' => $data->namawisata,
            'alamat'=>  $data->alamat,
            'biaya' =>  $data->biaya,
            'longitude' =>  $data->longitude,
            'latitude' =>  $data->latitude,
            'info'=>  $data->info,
            'fotobesar' =>  $data->fotobesar,
            'fotokecil1' =>  $data->fotokecil1,
            'fotokecil2' =>  $data->fotokecil2,
            'fotokecil3' =>  $data->fotokecil3,
            'title' => 'Detail Wisata'
    
          
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
