	
@extends('layout.template')    

   @section('judul')
   <div class="app-search-box col">
            <h2>Sistem Navigasi Pariwisata Sampolawa</h2>
    </div><!--//app-utilities-->
        
   @endsection

        	
   
   @section('konten')
   <div style="display:none;" id="myDiv" class="animate-bottom"></div>
    <div class="app-content">
      
        <div class="container-xl">
           
            <h1 class="app-page-title" >Dashboard</h1>
            
            <div class="app-card alert alert-dismissible shadow-sm mb-4 border-left-decoration" role="alert">
                <div class="inner">
                    <div class="app-card-body p-3 p-lg-4">
                        <p>Selamat Datang Di Sistem Pariwisata Sampolawa!</p>
                            </div><!--//col-->
                        </div><!--//row-->
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div><!--//app-card-body-->
                    
                </div><!--//inner-->
            </div><!--//app-card-->
                
            <div class="row g-4 mb-4 col-xl-12 col-sm-12 col-md-12 mx-auto text-center">
                <div class="col">
                    <div class="app-card app-card-stat shadow-sm h-100">
                        <div class="app-card-body p-3 p-lg-4">
                            <h4 class="stats-type mb-1">Wisata Alam</h4>
                            <div class="stats-figure">{{ $wisataalam }}</div>
                            
                        </div><!--//app-card-body-->
                        <a class="app-card-link-mask" href="#"></a>
                    </div><!--//app-card-->
                </div><!--//col-->
                
                <div class="col">
                    <div class="app-card app-card-stat shadow-sm h-100">
                        <div class="app-card-body p-3 p-lg-4">
                            <h4 class="stats-type mb-1">Wisata Religi</h4>
                            <div class="stats-figure">{{ $wisatareligi }}</div>
                            
                        </div><!--//app-card-body-->
                        <a class="app-card-link-mask" href="#"></a>
                    </div><!--//app-card-->
                </div><!--//col-->
                <div class="col">
                    <div class="app-card app-card-stat shadow-sm h-100">
                        <div class="app-card-body p-3 p-lg-4">
                            <h4 class="stats-type mb-1">Wisata Budaya</h4>
                            <div class="stats-figure">{{ $wisatabudaya }}</div>
                            
                      
                            
                        </div><!--//app-card-body-->
                        <a class="app-card-link-mask" href="#"></a>
                    </div><!--//app-card-->
                </div><!--//col-->
                <div class="col">
                    <div class="app-card app-card-stat shadow-sm h-100">
                        <div class="app-card-body p-3 p-lg-4">
                            <h4 class="stats-type mb-1">Wisata Pertanian</h4>
                            <div class="stats-figure">{{ $wisatapertanian }}</div>
                            
                        </div><!--//app-card-body-->
                        <a class="app-card-link-mask" href="#"></a>
                    </div><!--//app-card-->
                </div><!--//col-->
            </div><!--//row-->
                       
        </div><!--//app-content-->
    
        @endsection