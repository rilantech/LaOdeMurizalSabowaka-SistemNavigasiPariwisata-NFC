@extends('layout.templatelogin')

@section('halaman')
  <h1 class="app-page-title text-center" style="color: azure;">Si Sampolawa</h1>
<div class="container">
<div class="container-fluid mt-5">
   
    @if (session()->has('success'))
    <div class="alert alert-success alert-dismissible fade col-xl-6 col-sm-12 mx-auto show" role="alert">
        {{ session('success') }}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    @endif

    @if (session()->has('loginError'))
    <div class="alert alert-danger alert-dismissible fade show col-xl-6 col-sm-12 mx-auto" role="alert">
        {{ session('loginError') }}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    @endif

    <div class="card col-xl-6 col-sm-12 mx-auto rounded-5  border-dark border-3" style="opacity:100; background-color: rgb(239, 243, 239)">
        <div class="card-body ">
            <div class="text-center">
            <img class="user" src="{{ asset('user.png') }}" height="100px" width="100px">
        </div>
           

<form action="/login" method="post">
    @csrf
<div class="form-group mb-3 mt-3">
  <input type="text"  placeholder="Masukan Username..." class="form-control @error('username') is-invalid @enderror" autofocus name="username" id="username" required value="{{ old('username') }}" autocomplete="off" >
   @error('username')
   <div class="invalid-feedback">
      {{ $message }}
   </div>
   @enderror
</div>

<div class="form-group mb-3">
  <input type="password"  placeholder="Masukan Password..."  class="form-control" name="password" id="password" required autocomplete="off">

</div>
<div class="form-group mb-3">
<input type="checkbox" onclick="myFunction()">Tampilkan Password
</div>
    <script>
        function myFunction() {
            var x = document.getElementById("password");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
    </script>
<div class="text-center">
<button type="submit" class="btn btn-success w-100 mx-auto">Login</button>
</div>
</form>
<small class="d-block text-center mt-3">Belum Punya Akun?<a href="/registrasi" style="text-decoration: none">Daftar Sekarang!</a></small>

            </div>
          </div>
        </div>
</div>
@endsection

