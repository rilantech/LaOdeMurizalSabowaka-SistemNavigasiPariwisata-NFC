@extends('layout.templatelogin')

@section('halaman')
<div class="container">
<div class="container-fluid  mt-5">
    <div class="card col-xl-6 col-sm-12 mx-auto border-dark border-3 rounded-5">
        <div class="card-body">
            <h5 class="card-title fw-semibold mb-4 text-center">Registrasi</h5>

<form action="/registrasi" method="post">
           @csrf
<div class="form-group mb-3">
  <label for="name">Nama</label>
  <input type="text" class="form-control @error('name') is-invalid @enderror" id="name" name="name" placeholder="Masukan Nama" required value="{{ old('name') }}" autocomplete="off">
    @error('name')
    <div class="invalid-feedback">
           {{ $message }}
    </div>
    @enderror
</div>

<div class="form-group mb-3">
  <label for="username">Username</label>
  <input type="text" class="form-control @error('username') is-invalid @enderror" id="username" name="username" placeholder="Masukan Username" required value="{{ old('username') }}" autocomplete="off">
  @error('username')
    <div class="invalid-feedback">
           {{ $message }}
    </div>
    @enderror
</div>

<div class="form-group mb-3">
  <label for="password">Password</label>
  <input type="text" class="form-control @error('password') is-invalid @enderror" id="password" name="password" placeholder="Masukan Password" required autocomplete="off">
  @error('password')
  <div class="invalid-feedback">
         {{ $message }}
  </div>
  @enderror
</div>
<div class="text-center">
<button type="submit" class="btn btn-success w-100 mx-auto">Daftar</button>
</div>
</form>
<small class="d-block text-center mt-3">Sudah Punya Akun?<a href="/login" style="text-decoration: none">Silahkan Login!</a></small>
            </div>
          </div>
</div>
</div>
@endsection

