<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Requests\EditPengunjungWisataRequest;
use Illuminate\Http\Request as HttpRequest;
use App\Models\Akunwisatawan;
use App\Models\Pengunjungwisata;

class DaftarpengunjungwisataController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(HttpRequest $request)
    {
        $search = $request->query('search');

        if(!empty($search)){
            $pengunjungWisata = Pengunjungwisata::where('pengunjungwisatas.id','like','%'.$search.'%')
           ->orwhere('pengunjungwisatas.nama','like','%'.$search.'%')
           ->paginate(10)->onEachSide(2)->fragment('srv');
        }else{
            $pengunjungWisata = Pengunjungwisata::latest()->paginate(10)->onEachSide(2)->fragment('srv');
           
        }
      
        return view('tabel.tabeldaftarpengunjungwisata')->with([
            'pengunjungwisata' => $pengunjungWisata,
            'search' => $search,
            'title' => 'Daftar Pengunjung Wisata'
        ]);

    }
    public function tambahpengunjungwisata(Request $request)
    {
        $request->validate([
            'tanggal' => 'required',
            'nama'=> 'required',
            'wisata' => 'required',
            'alamat' => 'required'

        ]);

        $result = Pengunjungwisata::create([
            'tanggal' => $request->tanggal,
            'nama' => $request->nama,
            'wisata' => $request->wisata,
            'alamat' => $request->alamat
        ]);

        return response()->json([
            'result' => $result,
            'status' => true,
            'message' => 'Berhasil Tersimpan'
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
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(Pengunjungwisata $pengunjungwisata, $id)
    {
        //
        $data = $pengunjungwisata->find($id);

        return view('form.editpengunjungwisata')->with([

            'id' => $id,
            'tanggal' => $data->tanggal,
            'nama' => $data->nama,
            'wisata' => $data->wisata,
            'alamat' => $data->alamat,
            'title' => 'Edit Akun Pengunjung Wisata'
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
    public function update(EditPengunjungWisataRequest $request, Pengunjungwisata $pengunjungwisata, $id)
    {
        //
        $data= $pengunjungwisata->find($id);
        $data->tanggal = $request->tanggal;
        $data->nama = $request->nama;
        $data->wisata = $request->wisata;
        $data->alamat = $request->alamat;
        $data->save();
    
        return redirect('tabeldaftarpengunjungwisata')->with('msg','Data Berhasil Di Update');
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Pengunjungwisata $pengunjungwisata, $id)
    {
        //
            $data = $pengunjungwisata->find($id);
            $data->delete();
            return redirect('tabeldaftarpengunjungwisata')->with('msg','Data Berhasil Di Hapus');
    }
}
