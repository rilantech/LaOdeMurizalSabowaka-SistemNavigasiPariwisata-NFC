@extends('layout.template')


   @section('konten')

 <!--Untuk pengecekan kesalahan -->
   
<!-- START FORM -->
<button onclick="window.location='{{ url('tabeldaftarwisata') }}'" type="button" class="btn-close btn-danger" aria-label="Close" title="Kembali"></button>
<div class="w-5 pb-3 text-center">
    <h2>Detail Wisata</h2>
  </div>
  <!--TOMBOL KEMBALI -->
<div class="container">
  <div class="container-fluid">
    
    <div class="app-card alert alert-dismissible shadow-sm mb-4 border-left-decoration" role="alert">
      <div class="inner">
          <div class="app-card-body">
            <div class="row">
               <div class="col-sm">
               <p class="text-center text-black" style="font-size:30px;">{{ $namawisata }}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
              <img src="{{ asset('kumpulanfoto/'.$fotobesar) }}" class="image rounded mx-auto d-block mt-3 justify-center" width="950" height="300" />
                </div>
            </div>
            <div class="row mt-3">
              <div class="col-sm">
                <img class="user" src="{{ asset('iconcost.png') }}" height="20px" width="20px" style="margin-right: 5px"><span class="text-black fw-bold justify-content-center">Rp. {{ $biaya }}</span>
              </div>
          </div>
            <div class="row mt-3">
              <div class="col-sm">
                <img class="user" src="{{ asset('iconhome.png') }}" height="20px" width="20px" style="margin-right: 5px"><span class="text-black">{{ $alamat }}</span>
              </div>
          </div>
            <div class="row">
              <div class="col-sm">
              <p class="text-black mt-3" style="font-size:15px; text-align: justify">{{ $info }}</p>
               </div>
           </div>
                  </div><!--//col-->
              </div><!--//row-->
          </div><!--//app-card-body-->
          
      </div><!--//inner-->
  </div><!--//app-card-->
      

    </div>
    </div>
  
    <!-- AKHIR FORM -->
         
   @endsection