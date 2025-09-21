<?php

namespace App\Http\Controllers;

use App\Http\Requests\EditKategoriWisataRequest;
use App\Models\Kategoriwisata;
use App\Http\Requests\TambahKategoriWisataRequest;
use Illuminate\Http\Request as HttpRequest;

use Illuminate\Http\Request;

class KategoriwisataController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(HttpRequest $request)
    {
        $search = $request->query('search');

        if(!empty($search)){
            $kategoriWisata = Kategoriwisata::where('kategoriwisata.id','like','%'.$search.'%')
           ->orwhere('kategoriwisata.nama','like','%'.$search.'%')
           ->paginate(10)->onEachSide(2)->fragment('srv');
        }else{
            $kategoriWisata = Kategoriwisata::latest()->paginate(10)->onEachSide(2)->fragment('srv');
           
        }
      
        return view('tabel.tabeldaftarkategoriwisata')->with([
            'kategoriwisata' => $kategoriWisata,
            'search' => $search,
            'title' => 'Kategori Wisata'
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
    public function store(TambahKategoriWisataRequest $request)
    {
        $validate = $request->validated();
       
       
        $kategoriwisata = new Kategoriwisata;
    
        $kategoriwisata->nama = $request->nama;
        $kategoriwisata->keterangan = $request->keterangan;

        $kategoriwisata->save();
       
        return redirect('tabeldaftarkategoriwisata')->with('msg','Kategori Wisata Berhasil Di Tambahkan !');
       
    }

    /**
     * Display the specified resource.
     */
    public function show(Kategoriwisata $kategoriwisata, $id)
    {
        //
        $data = $kategoriwisata->find($id);

        return view('form.editkategoriwisata')->with([

            'id' => $id,
            'nama' => $data->nama,
            'keterangan' => $data->keterangan,
            'title' => 'Edit Kategori Wisata'
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
    public function update(EditKategoriWisataRequest $request, Kategoriwisata $kategoriwisata, $id)
    {
        //
        $data= $kategoriwisata->find($id);
        $data->nama = $request->nama;
        $data->keterangan = $request->keterangan;
       
        $data->save();

        return redirect('tabeldaftarkategoriwisata')->with('msg','Data Berhasil Di Update');
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Kategoriwisata $kategoriwisata, $id)
    {
        $data = $kategoriwisata->find($id);
        $data->delete();
        return redirect('tabeldaftarkategoriwisata')->with('msg','Data Berhasil Di Hapus');
        //
    }
}
