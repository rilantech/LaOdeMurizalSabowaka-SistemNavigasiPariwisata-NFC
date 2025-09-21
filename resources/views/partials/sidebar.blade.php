   <div id="app-sidepanel" class="app-sidepanel"> 
    <div id="sidepanel-drop" class="sidepanel-drop"></div>
    <div class="sidepanel-inner d-flex flex-column bg-success">
        <a href="#" id="sidepanel-close" class="sidepanel-close d-xl-none">&times;</a>
        <div class="app-branding">
            <a class="app-logo" href="{{ url('/dashboard') }}"><img class="logo-icon me-2" src="{{ asset('logo.png') }}" alt="logo"><span style="font-size: 100%; color: black; font-weight: bold">Si Sampolawa</span></a>

        </div><!--//app-branding-->  
        
        <nav id="app-nav-main" class="app-nav app-nav-main flex-grow-1">
            <ul class="app-menu list-unstyled accordion" id="menu-accordion">
                <li class="nav-item bg-success">
                    <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                    <a class="nav-link {{ ($title === "Dashboard") ?  'active' : '' }}" href="{{ url('/dashboard') }}">
                        <span class="nav-icon">
                        {{-- <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house-door" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
  <path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                    </svg> --}}
                    <img class="user" src="{{ asset('dashboard.png') }}" height="20px" width="20px">
                         </span>
                         <span class="nav-link-text fw-bold">Dashboard</span>
                    </a><!--//nav-link-->
                </li><!--//nav-item-->

                <li class="nav-item bg-success">
                    <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                    {{-- <a class="nav-link" href="" data-bs-toggle="modal" data-bs-target="{{ url('/modalservisanmasuk') }}"> --}}
                        <a class="nav-link {{ ($title === "Daftar Wisata") ?  'active' : '' }}"  href="{{ url('/tabeldaftarwisata') }}">
                            
                        <span class="nav-icon"><img class="user" src="{{ asset('tourism.png') }}" height="20px" width="20px"></span>
                        {{-- <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-folder" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
<path d="M9.828 4a3 3 0 0 1-2.12-.879l-.83-.828A1 1 0 0 0 6.173 2H2.5a1 1 0 0 0-1 .981L1.546 4h-1L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3v1z"/>
<path fill-rule="evenodd" d="M13.81 4H2.19a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4zM2.19 3A2 2 0 0 0 .198 5.181l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3H2.19z"/>
</svg> --}}
                         <span class="nav-link-text fw-bold">Daftar Wisata</span>
                    </a><!--//nav-link-->
                    
                </li><!--//nav-item-->

                <li class="nav-item bg-success">
                    <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                    <a class="nav-link {{ ($title === "Kategori Wisata") ?  'active' : '' }}" href="{{ url('/tabeldaftarkategoriwisata') }}">
                        <span class="nav-icon"> <img class="user" src="{{ asset('category.png') }}" height="20px" width="20px"></span>
                        {{-- <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-folder" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
<path d="M9.828 4a3 3 0 0 1-2.12-.879l-.83-.828A1 1 0 0 0 6.173 2H2.5a1 1 0 0 0-1 .981L1.546 4h-1L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3v1z"/>
<path fill-rule="evenodd" d="M13.81 4H2.19a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4zM2.19 3A2 2 0 0 0 .198 5.181l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3H2.19z"/>
</svg> --}}
                         <span class="nav-link-text fw-bold">Kategori Wisata</span>
                    </a><!--//nav-link-->
                </li><!--//nav-item-->
                <li class="nav-item bg-success">
                    <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                    <a class="nav-link {{ ($title === "Daftar Pengunjung Wista") ?  'active' : '' }}" href="{{ url('/tabeldaftarpengunjungwisata') }}">
                        <span class="nav-icon"><img class="user" src="{{ asset('group.png') }}" height="20px" width="20px"></span>                     
                         <span class="nav-link-text fw-bold">Daftar Pengunjung</span>
                    </a><!--//nav-link-->
                </li><!--//nav-item-->
                <li class="nav-item bg-success">
                    <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                    <a class="nav-link {{ ($title === "Akun Wisatawan") ?  'active' : '' }}" href="{{ url('/tabeldaftarakunwisatawan') }}">
                        <span class="nav-icon"><img class="user" src="{{ asset('group.png') }}" height="20px" width="20px"></span>                     
                         <span class="nav-link-text fw-bold">Akun Wisatawan</span>
                    </a><!--//nav-link-->
                </li><!--//nav-item-->
                <li class="nav-item has-submenu bg-success">
                    <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                    <a class="nav-link {{ ($title === "Tentang Aplikasi") ?  'active' : '' }}" href="{{ url('/tentangaplikasi') }}">
                        <span class="nav-icon"><img class="user" src="{{ asset('tentang_aplikasi.png') }}" height="20px" width="20px"></i>
                        <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
                        {{-- <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
<path fill-rule="evenodd" d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
<path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
</svg> --}}
 
                         </span>
                         <span class="nav-link-text fw-bold">Tentang Aplikasi</span>
                        
                    </a><!--//nav-link-->
                   
            </ul><!--//app-menu-->
        </nav><!--//app-nav-->
             
    </div><!--//sidepanel-inner-->
</div><!--//app-sidepanel-->


