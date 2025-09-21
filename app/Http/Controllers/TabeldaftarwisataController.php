<?php

namespace App\Http\Controllers;



use App\Models\Tabeldaftarwisata;
use App\Http\Requests\TambahPariwisataRequest;
use App\Http\Requests\EditPariwisataRequest;
use App\Models\Kategoriwisata;
use Illuminate\Http\Client\Request;
use Illuminate\Http\Request as HttpRequest;
use Illuminate\Support\Facades\File as FacadesFile;
use Illuminate\Support\Facades\Request as FacadesRequest;
use Illuminate\Support\Facades\Validator;

class TabeldaftarwisataController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(HttpRequest $request)
    {
        //
        $search = $request->query('search');
        if(!empty($search)){
            $dataWisata = Tabeldaftarwisata::where('tabeldaftarwisatas.id','like','%'.$search.'%')
           ->orwhere('tabeldaftarwisatas.namawisata','like','%'.$search.'%')
           ->paginate(10)->onEachSide(2)->fragment('srv');
        }else{
            $dataWisata = Tabeldaftarwisata::latest()->paginate(10)->onEachSide(2)->fragment('srv');
            
        }
      
        return view('tabel.tabeldaftarwisata')->with([
            'datawisata' => $dataWisata,
            'search' => $search,
            'title' => 'Daftar Wisata'
            
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
    public function store(TambahPariwisataRequest $request)
    {
        $datawisata =new Tabeldaftarwisata();
        $datawisata->id = $request->kodewisata;
        $datawisata->kategori = $request->kategori;
        $datawisata->namawisata = $request->namawisata;
        $datawisata->alamat= $request->alamat;
        $datawisata->biaya = $request->biaya;
        $datawisata->longitude = $request->longitude;
        $datawisata->latitude = $request->latitude;
        $datawisata->info= $request->info;

        $image = $request->file('fotobesar');
        $new_image = rand().'.'.$image->getClientOriginalExtension();
        $datawisata-> fotobesar = $new_image; 
        $image->move(public_path('kumpulanfoto'), $new_image);

        $image2 = $request->file('fotokecil1');
        $new_image2 = rand().'.'.$image2->getClientOriginalExtension();
        $datawisata-> fotokecil1 = $new_image2; 
        $image2->move(public_path('kumpulanfoto'), $new_image2);

        $image3 = $request->file('fotokecil2');
        $new_image3 = rand().'.'.$image3->getClientOriginalExtension();
        $datawisata-> fotokecil2 = $new_image3; 
        $image3->move(public_path('kumpulanfoto'), $new_image3);

        $image4 = $request->file('fotokecil3');
        $new_image4 = rand().'.'.$image4->getClientOriginalExtension();
        $datawisata-> fotokecil3 = $new_image4; 
        $image4->move(public_path('kumpulanfoto'), $new_image4);


      
        $datawisata->save();
      
        return redirect('tabeldaftarwisata')->with('msg','Data Berhasil Di Tambahkan');
     
    }

    /**
     * Display the specified resource.
     */
    public function show(Tabeldaftarwisata $datawisata, $id)
    {
        //
        $data = $datawisata->find($id);
        $kategoriwisata = Kategoriwisata::all();         

        return view('form.editpariwisata')->with([

            'id' => $id,
            'kodewisata' => $data->id,
            'kategori' => $data->kategori,
            'namawisata' => $data->namawisata,
            'alamat' => $data->alamat,
            'biaya' => $data->biaya,
            'longitude' => $data->longitude,
            'latitude' => $data->latitude,
            'info' => $data->info,
            'fotobesar' => $data->fotobesar,
            'fotokecil1' => $data->fotokecil1,
            'fotokecil2' => $data->fotokecil2,
            'fotokecil3' => $data->fotokecil3,
            'title' => 'Edit PariWisata',
            'kategoriwis' => $kategoriwisata
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
    public function update(HttpRequest $request, Tabeldaftarwisata $datawisata, $id)
    {
        //
        

        $old_image_name = $request->hidden_image;
        $image = $request->file('image');

        $old_image_name1 = $request->hidden_image1;
        $image1 = $request->file('image1');

        $old_image_name2 = $request->hidden_image2;
        $image2 = $request->file('image2');

        $old_image_name3 = $request->hidden_image3;
        $image3 = $request->file('image3');

        if($image != ''){

            $request->validate([
                'kategori' => 'required',
                'namawisata' => 'required|max:500',
                'alamat' => 'required',
                'biaya' => 'required',
                'longitude' => 'required',
                'latitude' => 'required',
                'info' => 'required',
                'image' => 'required|image|mimes:jpeg,jpg,png|max:5000'
            ]);
           
            $image_name = $old_image_name;
            $image->move(public_path('kumpulanfoto'), $image_name);
             

        } 

        if($image1 != ''){

            $request->validate([
                'kategori' => 'required',
                'namawisata' => 'required|max:500',
                'alamat' => 'required',
                'biaya' => 'required',
                'longitude' => 'required',
                'latitude' => 'required',
                'info' => 'required',
                'image1' => 'required|image|mimes:jpeg,jpg,png|max:5000'
            ]);
           
            $image_name1 = $old_image_name1;
            $image1->move(public_path('kumpulanfoto'), $image_name1);
             

        } 

        if($image2 != ''){

            $request->validate([
                'kategori' => 'required',
                'namawisata' => 'required|max:500',
                'alamat' => 'required',
                'biaya' => 'required',
                'longitude' => 'required',
                'latitude' => 'required',
                'info' => 'required',
                'image2' => 'required|image|mimes:jpeg,jpg,png|max:5000'
            ]);
           
            $image_name2 = $old_image_name2;
            $image2->move(public_path('kumpulanfoto'), $image_name2);
             

        } 

        if($image3 != ''){

            $request->validate([
                
                'kategori' => 'required',
                'namawisata' => 'required|max:500',
                'alamat' => 'required',
                'biaya' => 'required',
                'longitude' => 'required',
                'latitude' => 'required',
                'info' => 'required',
                'image3' => 'required|image|mimes:jpeg,jpg,png|max:5000'
            ]);
           
            $image_name3 = $old_image_name3;
            $image3->move(public_path('kumpulanfoto'), $image_name3);
             

        } 

        if($image == '' || $image1 == '' || $image2 == '' || $image3 = '')
        {
            $request->validate([
               
                'kategori' => 'required',
                'namawisata' => 'required|max:500',
                'alamat' => 'required',
                'biaya' => 'required',
                'longitude' => 'required',
                'latitude' => 'required',
                'info' => 'required'  
            ]);
        
            
            $image_name = $old_image_name;
            $image_name1 = $old_image_name1;
            $image_name2 = $old_image_name2;
            $image_name3 = $old_image_name3;
        }
        
        $data= $datawisata->find($id);
       $data->kategori = $request->kategori;
       $data->namawisata = $request->namawisata;
       $data->alamat= $request->alamat;
       $data->biaya = $request->biaya;
       $data->longitude = $request->longitude;
       $data->latitude = $request->latitude;
       $data->info = $request->info;
       $data->fotobesar = $image_name;
       $data->fotokecil1 = $image_name1;
       $data->fotokecil2 = $image_name2;
       $data->fotokecil3 = $image_name3;
       


       $data->save();
       
        return redirect('tabeldaftarwisata')->with('msg','Data Berhasil Di Update');
    }
    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Tabeldaftarwisata $datawisata, $id)
    {
        $data = $datawisata->find($id);
        FacadesFile::delete('kumpulanfoto/'.$data->foto);
        $data->delete();
        return redirect('tabeldaftarwisata')->with('msg','Data Berhasil Di Hapus');
        //
    }


    public function tambahdata(){
        $kategoriwisata = Kategoriwisata::all();

        return view('form.tambahpariwisata')->with([
            'kategoriwis' => $kategoriwisata,
            'title' => 'Tambah Pariwisata',
            
        ]);
    }
}
