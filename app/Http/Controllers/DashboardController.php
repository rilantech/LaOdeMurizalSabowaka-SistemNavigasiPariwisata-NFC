<?php

namespace App\Http\Controllers;

use App\Models\Tabeldaftarwisata;
use Illuminate\Http\Request;

class DashboardController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $wisataalam = Tabeldaftarwisata::where('kategori', 'Wisata Alam')->count();
        $wisatareligi = Tabeldaftarwisata::where('kategori', 'Wisata Religi')->count();
        $wisatabudaya = Tabeldaftarwisata::where('kategori', 'Wisata Budaya')->count();
        $wisatapertanian = Tabeldaftarwisata::where('kategori', 'Wisata Pertanian')->count();
    

        return view('tabel.halamandashboard')->with([
            'wisataalam' => $wisataalam,
            'wisatareligi' => $wisatareligi,
            'wisatabudaya' => $wisatabudaya,
            'wisatapertanian' => $wisatapertanian,
            'title' => 'Dashboard'
            ] );
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
    public function show(Dataservis $dataservis)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Dataservis $dataservis)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Dataservis $dataservis)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Dataservis $dataservis)
    {
        //
    }
}
