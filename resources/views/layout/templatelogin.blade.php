<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='{{ asset('logo.png') }}' rel='shortcut icon'>
    <title>{{ $title }} | Sistem Pariwisata Sampolawa</title>
    <link rel="stylesheet" href="{{ asset('css/bootstrap.min.css') }}" />
  </head>
  
  <body class="bg-image"  style="background-image: url({{ asset('bg.png') }}); 
  height: 100vh;background-repeat:no-repeat;background-size:cover;">
    <main class="container">
              
               @yield('halaman')
    </main>
    <script src="{{ asset('js/bootstrap.bundle.min.js') }}"></script>
  </body>
</html>