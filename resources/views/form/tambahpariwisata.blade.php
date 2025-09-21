@extends('layout.template')


   @section('konten')

 <!--Untuk pengecekan kesalahan -->

<!-- START FORM -->
<div class="w-5 pb-3 text-center">
    <h2>Tambah Wisata</h2>
  </div>
  <!--TOMBOL KEMBALI -->
<div class="container">
  <div class="container-fluid">
    <button onclick="window.location='{{ url('tabeldaftarwisata') }}'" type="button" class="btn-close btn-danger" aria-label="Close" title="Kembali"></button>
    
{{-- <form  action='{{  url('tabeldaftarwisata') }}' method='post' enctype="multipart/form-data"> --}}
  
  <form  action='{{  url('tabeldaftarwisata') }}' method='post' enctype="multipart/form-data">
    @csrf
    
    <div class="my-3 p-3 bg-success border border-2 border-black rounded shadow-sm row-xl-6 row-sm-12 mx-auto">
     <div class="row">
        <div class="col-sm">
        <div class="mb-3 row">
            <label for="kodewisata" class="col-sm-2 col-form-label text-black fw-bold">Kode Wisata</label>
            <div class="col-sm-10">
                <input type="text" class="form-control @error('kodewisata') is-invalid @enderror text-black"  name='kodewisata' value="{{ old('kodewisata') }}" id="kodewisata"  autofocus autocomplete="off">
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
                  <option selected>--Pilih Kategori--</option>
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
                <input type="text" class="form-control text-black  @error('namawisata') is-invalid @enderror" name='namawisata' value="{{ old('namawisata') }}" id="namawisata" autocomplete="off" >
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
                <input type="text" class="form-control @error('alamat') is-invalid @enderror text-black"  name='alamat' value="{{ old('alamat') }}" id="alamat" autocomplete="off">
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
                <input type="text" class="form-control @error('biaya') is-invalid @enderror text-black"  name='biaya' value="{{ old('biaya') }}" id="biaya" autocomplete="off">
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
            <textarea class="form-control text-black @error('info') is-invalid @enderror" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 300px" name="info">{{ old('info') }}</textarea>
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
                <input type="text" class="form-control text-black @error('longitude') is-invalid @enderror"  name='longitude' value="{{ old('longitude') }}" id="longitude"  autofocus autocomplete="off">
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
                <input type="text" class="form-control text-black  @error('latitude') is-invalid @enderror"  name='latitude' value="{{ old('latitude') }}" id="latitude" autocomplete="off">
                @error('latitude')
                <div class="invalid-feedback">
                  {{ $message }}
                </div>
            @enderror
            </div>
        </div>
        <div class="mb-3 row">
          <label class="col-sm-2 col-form-label text-black fw-bold">Foto</label>
          <div class="col-sm-10">
            <label for="fotobesar" class="col-sm- col-form-label text-black">Foto Besar</label>
            <input type="file"  class="form-control @error('fotobesar') is-invalid @enderror" name='fotobesar'>
              @error('fotobesar')
              <div class="invalid-feedback">
                {{ $message }}
              </div>
          @enderror
          </div>
      </div> 
      <div class="mb-3 row">
        <label class="col-sm-2 col-form-label text-black fw-bold"></label>
        <div class="col-sm-10">
          <label for="fotobesar" class="col-sm- col-form-label text-black">Foto Kecil 1</label>
          <input type="file"  class="form-control @error('fotokecil1') is-invalid @enderror" name='fotokecil1'>
            @error('fotokecil1')
            <div class="invalid-feedback">
              {{ $message }}
            </div>
        @enderror
        </div>
    </div>    
    <div class="mb-3 row">
      <label class="col-sm-2 col-form-label text-black fw-bold"></label>
      <div class="col-sm-10">
        <label for="fotokecil2" class="col-sm- col-form-label text-black">Foto Kecil 2</label>
        <input type="file"  class="form-control @error('fotokecil2') is-invalid @enderror" name='fotokecil2'>
          @error('fotokecil2')
          <div class="invalid-feedback">
            {{ $message }}
          </div>
      @enderror
      </div>
  </div>       
      <div class="mb-3 row">
        <label class="col-sm-2 col-form-label text-black fw-bold"></label>
        <div class="col-sm-10">
          <label for="fotokecil3" class="col-sm- col-form-label text-black">Foto Kecil 3</label>
          <input type="file"  class="form-control @error('fotokecil3') is-invalid @enderror" name='fotokecil3'>
            @error('fotokecil3')
            <div class="invalid-feedback">
              {{ $message }}
            </div>
        @enderror
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