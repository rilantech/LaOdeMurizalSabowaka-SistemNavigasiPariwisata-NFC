@extends('layout.template')


   @section('konten')

 <!--Untuk pengecekan kesalahan -->

<!-- START FORM -->
<div class="w-5 pb-3 text-center">
    <h2>Edit Wisata</h2>
  </div>
  <!--TOMBOL KEMBALI -->
<div class="container">
  <div class="container-fluid">
    <button onclick="window.location='{{ url('tabeldaftarwisata') }}'" type="button" class="btn-close btn-danger" aria-label="Close" title="Kembali"></button>
    
{{-- <form  action='{{  url('tabeldaftarwisata') }}' method='post' enctype="multipart/form-data"> --}}
  
  <form  action='{{  url('tabeldaftarwisata/'.$id) }}' method='post' enctype="multipart/form-data">
    @csrf
    @method('PUT')
    <div class="my-3 p-3 bg-success border border-2 border-black rounded shadow-sm row-xl-6 row-sm-12 mx-auto">
     <div class="row">
        <div class="col-sm">
        <div class="mb-3 row">
            <label for="kodewisata" class="col-sm-2 col-form-label text-black fw-bold">Kode Wisata</label>
            <div class="col-sm-10">
                <input type="text" disabled class="form-control text-black @error('kodewisata') is-invalid @enderror"  name='kodewisata' value="{{ $kodewisata }}" id="kodewisata"  autofocus autocomplete="off">
                @error('kodewisata')
                      <div class="invalid-feedback">
                        {{ $message }}
                      </div>
                  @enderror
            </div>
        </div>
        <div class="mb-3 row">
          <label for="kategori" class="col-sm-2 col-form-label text-black fw-bold">Kategori</label>
          <div class="col-sm-10">
              <select class="form-select @error('kategori') is-invalid @enderror"  aria-label="Default select example" name="kategori" id="kategori">
                <option selected>{{ $kategori }}</option>
                @foreach ($kategoriwis as $item)
                <option value= "{{ $item->nama }}" {{ old('kategori') == $item->nama ? 'selected':null }}>{{ $item->nama }}</option>
                @endforeach
                </select>
                @error('kategori')
                <div class="invalid-feedback">
                  {{ $message }}
                </div>
            @enderror
          </div>
      </div>
        <div class="mb-3 row">
            <label for="namawisata" class="col-sm-2 col-form-label text-black fw-bold">Nama Wisata</label>
            <div class="col-sm-10">
                <input type="text" class="form-control  text-black @error('namawisata') is-invalid @enderror" name='namawisata' value="{{ $namawisata }}" id="namawisata" autocomplete="off" >
                @error('namawisata')
                <div class="invalid-feedback">
                  {{ $message }}
                </div>
            @enderror
            </div>
        </div>
        <div class="mb-3 row">
            <label for="alamat" class="col-sm-2 col-form-label text-black fw-bold">Alamat</label>
            <div class="col-sm-10">
                <input type="text" class="form-control text-black @error('alamat') is-invalid @enderror "  name='alamat' value="{{ $alamat }}" id="alamat" autocomplete="off">
                @error('alamat')
                <div class="invalid-feedback">
                  {{ $message }}
                </div>
            @enderror
            </div>
        </div>
        <div class="mb-3 row">
            <label for="biaya" class="col-sm-2 col-form-label text-black fw-bold">Biaya</label>
            <div class="col-sm-10">
                <input type="text" class="form-control  text-black @error('biaya') is-invalid @enderror"  name='biaya' value="{{ $biaya }}" id="biaya" autocomplete="off">
                @error('biaya')
                <div class="invalid-feedback">
                  {{ $message }}
                </div>
            @enderror
            </div>
        </div>
        <div class="mb-3 row">
          <label for="info" class="col-sm-2 col-form-label text-black fw-bold">Info</label>
          <div class=" col-sm-10 form-floating">
            <textarea class="form-control text-black text-black @error('info') is-invalid @enderror" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 300px" name="info">{{ $info }}</textarea>
              @error('info')
              <div class="invalid-feedback">
                {{ $message }}
              </div>
          @enderror
          </div>
      </div>
    </div>
    <div class="col-sm">
        <div class="mb-3 row">
            <label for="longitude" class="col-sm-2 col-form-label text-black fw-bold">Longitude</label>
            <div class="col-sm-10">
                <input type="text" class="form-control text-black @error('longitude') is-invalid @enderror"  name='longitude' value="{{ $longitude }}" id="longitude"  autofocus autocomplete="off">
                      @error('longitude')
                      <div class="invalid-feedback">
                        {{ $message }}
                      </div>
                  @enderror
            </div>
        </div>
        <div class="mb-3 row">
            <label for="latitude" class="col-sm-2 col-form-label text-black fw-bold">Latitude</label>
            <div class="col-sm-10">
                <input type="text" class="form-control text-black @error('latitude') is-invalid @enderror"  name='latitude' value="{{ $latitude }}" id="latitude" autocomplete="off">
                @error('latitude')
                <div class="invalid-feedback">
                  {{ $message }}
                </div>
            @enderror
            </div>
        </div>
        <div class="mb-3 row">
          <label  class="col-sm-2 col-form-label text-black fw-bold">Foto</label>
          <div class="col-sm-10">
            <label for="fotobesar" class="col-sm- col-form-label text-black">Foto Besar</label>
          <input type="file"  class="form-control @error('image') is-invalid @enderror" name='image'>
          @error('image')
                <div class="invalid-feedback">
                  {{ $message }}
                </div>
            @enderror
          <img src="{{ asset('kumpulanfoto/'.$fotobesar) }}" class="image-thumbnail mt-3" width="100px" />
          <input type="hidden"  class="form-control" name='hidden_image' value="{{ $fotobesar }}">
          </div>
      </div>    
      <div class="mb-3 row">
        <label  class="col-sm-2 col-form-label text-black fw-bold"></label>
        <div class="col-sm-10">
          <label for="fotobesar" class="col-sm- col-form-label text-black">Foto Kecil 1</label>
        <input type="file"  class="form-control @error('image1') is-invalid @enderror" name='image1'>
        @error('image1')
              <div class="invalid-feedback">
                {{ $message }}
              </div>
          @enderror
        <img src="{{ asset('kumpulanfoto/'.$fotokecil1) }}" class="image-thumbnail mt-3" width="100px" />
        <input type="hidden"  class="form-control" name='hidden_image1' value="{{ $fotokecil1 }}">
        </div>
    </div> 
    <div class="mb-3 row">
      <label  class="col-sm-2 col-form-label text-black fw-bold"></label>
      <div class="col-sm-10">
        <label for="fotobesar" class="col-sm- col-form-label text-black">Foto Kecil 2</label>
      <input type="file"  class="form-control @error('image2') is-invalid @enderror" name='image2'>
      @error('image2')
            <div class="invalid-feedback">
              {{ $message }}
            </div>
        @enderror
      <img src="{{ asset('kumpulanfoto/'.$fotokecil2) }}" class="image-thumbnail mt-3" width="100px" />
      <input type="hidden"  class="form-control" name='hidden_image2' value="{{ $fotokecil2 }}">
      </div>
  </div> 
  <div class="mb-3 row">
    <label  class="col-sm-2 col-form-label text-black fw-bold"></label>
    <div class="col-sm-10">
      <label for="fotobesar" class="col-sm- col-form-label text-black">Foto Kecil 3</label>
    <input type="file"  class="form-control @error('image3') is-invalid @enderror" name='image3'>
    @error('image3')
          <div class="invalid-feedback">
            {{ $message }}
          </div>
      @enderror
    <img src="{{ asset('kumpulanfoto/'.$fotokecil3) }}" class="image-thumbnail mt-3" width="100px" />
    <input type="hidden"  class="form-control" name='hidden_image3' value="{{ $fotokecil3 }}">
    </div>
</div> 
   
      </div>
     </div>
     <div class="mb-3 row">
        <label for="jurusan" class="col-sm-2 col-form-label"></label>
        <div class="col-sm-10"><button type="submit" class="btn btn-info border border-2 border-black" name="submit">SIMPAN</button></div>
    </div>
    </div>
      </form>
    </div>
    </div>
  
    <!-- AKHIR FORM -->
    
         
   @endsection