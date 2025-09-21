{{-- <!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <
  
  </head>
  <body class="bg-light">
    <main class="container">
               
    </main>
    
  </body></html>--}}


<!DOCTYPE html>
<html lang="en"> 
<head>
  <style>
    /* Center the loader */

#loader {

position: absolute;

left: 50%;

top: 50%;

z-index: 1;

width: 150px;

height: 150px;

margin: -75px 0 0 -75px;

border: 16px solid #76f310;

border-radius: 50%;

border-top: 16px solid #3498db;

width: 120px;

height: 120px;

-webkit-animation: spin 1s linear infinite;

animation: spin 1s linear infinite;

}



@-webkit-keyframes spin {

0% { -webkit-transform: rotate(0deg); }

100% { -webkit-transform: rotate(360deg); }

}



@keyframes spin {

0% { transform: rotate(0deg); }

100% { transform: rotate(360deg); }

}



/* Add animation to "page content" */

.animate-bottom {

position: relative;

-webkit-animation-name: animatebottom;

-webkit-animation-duration: 1s;

animation-name: animatebottom;

animation-duration: 1s

}



@-webkit-keyframes animatebottom {

from { bottom:-100px; opacity:0 }

to { bottom:0px; opacity:1 }

}



@keyframes animatebottom {

from{ bottom:-100px; opacity:0 }

to{ bottom:0; opacity:1 }

}



#myDiv {

display: none;

}
    </style>
  <link href='{{ asset('logo.png') }}' rel='shortcut icon'>
    <title>{{ $title}} | Sistem Pariwisata Sampolawa</title>
 
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Portal - Bootstrap 5 Admin Dashboard Template For Developers">
    <meta name="author" content="Xiaoying Riley at 3rd Wave Media">    
   

    <link rel="stylesheet" href="{{ asset('css/bootstrap.min.css') }}" />
    <link rel="stylesheet" href="{{ asset('font/css/all.min.css') }}">
    {{-- <script defer src="{{ asset('templateadmin/assets/plugins/fontawesome/js/all.min.js') }}"></script> --}}
  
    <link id="theme-style" rel="stylesheet" href="{{ asset('templateadmin/assets/css/portal.css') }}">
	<link id="theme-style" rel="stylesheet" href="{{ asset('templateadmin/assets/scss/portal.scss') }}">
    <!-- FontAwesome JS-->
    {{-- <link rel="stylesheet" href="{{ asset('assests/css/bootstrap.min.css') }}" /> --}}
    <link rel="stylesheet" href="{{ asset('assests/css/dropzone.min.css') }}" />
    <meta name="_token" content="{{ csrf_token() }}">
</head> 

<body class="app" onload="myFunction()">  
  {{-- <div id="loader">	</div>
  <div style="display:none;" id="myDiv" class="animate-bottom"></div> --}}
    <header class="app-header fixed-top bg-success">	   	            
        <div class="app-header-inner" id="app">  
	        <div class="container-fluid py-2">
				<div class="container">
		        <div class="app-header-content"> 
		            <div class="row justify-content-between align-items-center">
				    <div class="col-auto">
              {{-- @yield('judul') --}}
					    <a id="sidepanel-toggler" class="sidepanel-toggler d-inline-block d-xl-none" href="#">
						    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 30 30" role="img"><title>Menu</title><path stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10" stroke-width="2" d="M4 7h22M4 15h22M4 23h22"></path></svg>
					    </a>
              @yield('judul')
				    </div><!--//col-->
		              @yield('searchbox')
		            <div class="app-utilities col-auto">
			            <div class="app-utility-item app-user-dropdown dropdown">
							<form action="/logout" method="post">
								@csrf
								<button type="submit" class="border-0 bg-white bg-transparent"><i class="fa-solid fa-right-from-bracket"></i>Log Out</button>
							</form>
				            
			            </div><!--//app-user-dropdown--> 
		            </div><!--//app-utilities-->
		        </div><!--//row-->
	            </div><!--//app-header-content-->
			</div>
	        </div><!--//container-fluid-->
        </div><!--//app-header-inner-->
           @include('partials.sidebar')
    </header><!--//app-header-->

		    </div><!--//container-fluid-->
        <div class="app-wrapper">
          <div class="main">
            <div class="py-5 container-fluid">
              <div class="container">
	           @yield('konten')
           
            </div>
          </div>
            </div>
	  
	    
    </div><!--//app-wrapper-->    	
    <footer  class="col-sm  bg-info w-100 px-3 py-3" style="margin-top: 30%;text-align:center; padding-left:100px;" >
        <!--/* This template is free as long as you keep the footer attribution link. If you'd like to use the template without the attribution link, you can buy the commercial license via our website: themes.3rdwavemedia.com Thank you for your support. :) */-->
                              <p style="margin-left: 200px;">Copyright &copy 2024 Informatika Unidayan</p>
    </footer>				
    <!-- Javascript -->          
    <script src="{{ asset('templateadmin/assets/plugins/popper.min.js') }}"></script>
    <script src="{{ asset('templateadmin/assets/plugins/bootstrap/js/bootstrap.min.js') }}"></script>  

    <!-- Charts JS -->
    {{-- <script src="{{ asset('templateadmin/assets/plugins/chart.js/chart.min.js') }}"></script> 
    <script src="{{ asset('/templateadmin/assets/js/index-charts.js') }}"></script>  --}}
    
    <!-- Page Specific JS -->
    <script src="{{ asset('templateadmin/assets/js/app.js') }}"></script> 
	<script src="{{ asset('js/bootstrap.bundle.min.js') }}"></script>
  {{-- <script src="js/app.js"></script> --}}

  <script src="{{ asset('assests/js/jquery-3.6.4.min.js') }}"></script>
 


</body>
</html> 

