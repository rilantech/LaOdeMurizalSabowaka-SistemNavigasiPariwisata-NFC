@extends('layout.template')
@section('searchbox')
<div class="search-mobile-trigger d-sm-none col">
  <i class="search-mobile-trigger-icon fa-solid fa-magnifying-glass"></i>
</div><!--//col-->
<div class="app-search-box col">
    <form class="app-search-form" method="GET">  
<input type="text" placeholder="Cari Akun Wisatawan..." name="search" class="form-control search-input" value="{{ $search }}" id="search" autofocus>
<button type="submit" class="btn search-btn btn-primary" value="Search"><i class="fa-solid fa-magnifying-glass"></i></button> 
@error('nama')
    <div class="invalid-feedback">
      {{ $message }}
    </div>
  @enderror
</form>
</div><!--//app-search-box--> 
@endsection

    @section('konten')
  <!-- START DATA -->
</div><!--//app-search-box-->

  <div class=" my-3 p-3 bg-body rounded shadow-sm ">
      <div class="pb-3 text-center">
          <h2>Akun Wisatawan</h2>
        </div>
        <div class="row">
            <div class="col-2 pb-3">
                <div class="col-sm-10"><button onclick="window.location='{{ url('tambahakunwisatawan') }}'" type="submit" class="btn btn-info text-white" name="submit">Tambah</button></div>
              
             </div>
            </div>
        
          @if (session()->has('msg'))
          
          <div class="alert alert-success alert-dismissible col-xl-6 col-sm-12 fade show" role="alert">
                {{ session('msg') }}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
              
         @endif
          
         

         
          {{-- <form action="" method="GET" >
            <div class="mb-3 row">
              <label for="search" class="col-sm-2 col-form-label">Cari Data</label>
              <div class="col-sm-10">
                  <input type="text" class="form-control form-control-sm" value="{{ $search }}" id="search" placeholder="Masukan Data Yang Di Cari..." name="search" autofocus>
                    @error('nama')
                        <div class="invalid-feedback">
                          {{ $message }}
                        </div>
                    @enderror
              </div>
          </div>
          </form> --}}
          <table class="table text-center table-bordered border-dark table-hover">
              <thead class="table-success">
               
                  <tr>
                      <th class="col-1">No</th>
                      <th class="col-3">Nama</th>
                      <th class="col-3">Username</th>
                      <th class="col-1">Password</th>
                      <th class="col-3">Action</th>
                  </tr>
              </thead>
              <tbody>

                @php
                    $nomor = 1 + (($akunwisatawan->currentPage()-1)* $akunwisatawan->perPage());
                @endphp
                   @foreach ($akunwisatawan as $row)
                    <tr>
                           {{-- <th>{{ $loop->iteration }}</th> --}}
                           <th>{{ $nomor ++}}</th>
                           <td>{{ $row->nama }}</td>
                           <td>{{ $row->username }}</td>
                           <td>{{ $row->password }}</td>
                            <td>
                            <div class="row">
                              @can('admin')
                              <div class="col-6">
                               <button onclick="window.location='{{ url('tabeldaftarakunwisatawan/'.$row->id) }}'" type="button" class="btn btn-md btn-warning" title="Edit Data">
                                    <i class="fa fa-edit"></i>
                               </button>
                              </div>
                              <div class="col-6">
                               <form onsubmit="return deleteData('{{ $row->nama }}')"  action="{{ url('tabeldaftarakunwisatawan/'.$row->id) }}" method="POST"> 
                                @csrf
                                @method('DELETE')
                                   <button type="submit" title="Hapus Data" class="btn btn-danger btn-md">
                                    <i class="fa fa-trash-alt"></i>
                                   </button>
                              </form>
                            </div>
                            @endcan
                            {{-- <div class="col-4">
                              <button onclick="window.location='{{ url('bisadiambil/'.$row->id) }}'" type="button" class="btn btn-md btn-success" title="Ubah Bisa Di Ambil">
                                <i class="fa-sharp fa-solid fa-right-from-bracket"></i>
                              </button>
                             </div> --}}
                            </div>
                           </td>

                       </tr>
                          <script>
                                 function deleteData(nama){
                                  pesan = confirm('Yakin Data Ingin Di Hapus ?');

                                  if(pesan) return true;
                                  else return false;
                                 }
                          </script>
                      
                   @endforeach                     
                  
              </tbody>
          </table>
        
           {{-- {{ $dataservis->links() }} --}}

           {!! $akunwisatawan->appends(Request::except('page'))->render() !!}
    
    </div>
 
    @endsection
    <!-- AKHIR DATA -->
