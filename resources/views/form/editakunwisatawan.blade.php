@extends('layout.template')


   @section('konten')

 <!--Untuk pengecekan kesalahan -->
   
<!-- START FORM -->
<div class="w-5 pb-3 text-center">
    <h2>Edit Akun Wisatawan</h2>
  </div>
  <!--TOMBOL KEMBALI -->
<div class="container ">
  <div class="container-fluid col-sm-6">
    <button onclick="window.location='{{ url('tabeldaftarakunwisatawan') }}'" type="button" class="btn-close btn-danger" aria-label="Close" title="Kembali"></button>
    
<form  action='{{  url('tabeldaftarakunwisatawan/'.$id) }}' method='post'>
 
    @csrf
    @method('PUT')
    
    <div class="my-3 p-3 bg-success border border-2 border-black rounded shadow-sm row-xl-6 row-sm-12 mx-auto">
     <div class="row">
        <div class="col-sm-12">
        <div class="mt-3 mb-3 row">
            <label for="nama" class="col-sm-3 col-form-label text-black fw-bold">Nama </label>
            <div class="col-sm">
                <input type="text" class="form-control text-black @error('nama') is-invalid @enderror" name='nama' value="{{ $nama }}" id="nama"  autofocus autocomplete="off">
                  @error('nama')
                      <div class="invalid-feedback">
                        {{ $message }}
                      </div>
                  @enderror
            </div>
        </div>
       
        <div class="mb-3 row">
            <label for="username" class="col-sm-3 col-form-label text-black fw-bold">Username</label>
            <div class="col-sm">
                <input type="text" class="form-control text-black @error('username') is-invalid @enderror" name='username'  id="username" autocomplete="off" value="{{ $username }}">            
                 @error('username')
                <div class="invalid-feedback">
                  {{ $message }}
                </div>
            @enderror
            </div>
        </div>
        <div class="mb-3 row">
          <label for="password" class="col-sm-3 col-form-label text-black fw-bold">Password</label>
          <div class="col-sm">
              <input type="text" class="form-control text-black @error('password') is-invalid @enderror" name='password'  id="password" autocomplete="off" value="{{ $password }}">
              @error('password')
              <div class="invalid-feedback">
                {{ $message }}
              </div>
          @enderror
          </div>
      </div>
    </div>
     </div>
     <div class="mb-3 p-2 row">
        <label for="jurusan" class="col-sm-2 col-form-label"></label>
        <button type="submit" class="btn btn-info border border-2 border-black align-center" name="submit">SIMPAN</button>
    </div>
    </div>
      </form>
    </div>
    </div>
  
    <!-- AKHIR FORM -->
    
         
   @endsection