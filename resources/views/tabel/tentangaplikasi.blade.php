@extends('layout.template')    

   @section('judul')
  
        
   @endsection

   @section('konten')

    <div class="app-content">
      
        <div class="container-xl">
            
            <h1 class="app-page-title" >Tentang Aplikasi</h1>
            
            <div class="app-card alert alert-dismissible shadow-sm mb-4 border-left-decoration" role="alert">
                <div class="inner">
                    <div class="app-card-body p-3 p-lg-4">
                        <div class="row align-items-center"> 
                            <div class="col"> 
                                <! -- gambar lain dapat disisipkan di sini --> 
                                <img src="{{ asset('fotowisata.jpg') }}" alt="..." class="img-fluid"/> 
                            </div> 
                            <div class="col"> 
                                <h1 >Si NavPar Sampolawa</h1> 
                                <p>Merupakan Aplikasi Untuk Mengelola Data Pariwisata Di Kecamatan Sampolawa.</p> 
                                <p>Aplikasi Ini Di Ciptakan Untuk Mempermudah Wisatawan Dalam Mendapatkan Informasi Yang Lengkap
                                Tentang Wisata Di Kecamatan Sampolawa.</p>
                              
                          </div> 
                        </div> 
                            </div><!--//col-->
                        </div><!--//row-->
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div><!--//app-card-body-->
                    
                </div><!--//inner-->
            </div><!--//app-card-->
                
            <div class="row g-4 mb-4 col-xl-12 col-sm-12 col-md-12 mx-auto text-center">
                
            </div><!--//row-->
                       
        </div><!--//app-content-->
    

        @endsection