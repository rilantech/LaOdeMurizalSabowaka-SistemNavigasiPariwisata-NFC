<?php

use App\Http\Controllers\AkunwisatawanController;
use App\Http\Controllers\DataservisController;
use App\Http\Controllers\BisadiambilController;
use App\Http\Controllers\SudahdiambilController;
use App\Http\Controllers\ActionbsdiambilController;
use App\Http\Controllers\ActionsudahdiambilController;
use App\Http\Controllers\DaftarpengunjungwisataController;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\RegisterController;
use App\Http\Controllers\DashboardController;
use App\Http\Controllers\DetailController;
use App\Http\Controllers\KategoriwisataController;
use App\Http\Controllers\TabeldaftarwisataController;
use App\Http\Controllers\TempImageController;
use App\Http\Controllers\TentangAplikasiController;
use App\Livewire\Wisata\WisataComponent;
use App\Livewire\Wisata\AddWisataComponent;
use App\Livewire\Wisata\EditWisataComponent;
use App\Models\Akunwisatawan;
use App\Models\Dataservis;
use Illuminate\Support\Facades\Route;
use App\Models\Kategoriwisata;
use Illuminate\Database\Eloquent\Builder;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|

*/

// Route::get('/prosesservis', 'ServisanController@index')->name('prosesservis');
// Route::get('/prosesservis', [ServisanController::class, 'index']);
// Route::get('/servisanmasuk', [ServisanController::class, 'create']);
// Route::apiResource('/dataservis', ApiDataservisController::class);
// Route::apiResource('/datawisata', ApiTabeldaftarwisataController::class);
// // Route::post('/prosesservis',[ServisController::class, 'destroy']);

// Route::get('/servisanmasuk',[ServisController::class, 'create'])->middleware('auth');

// Route::get("/editan", [ServisController::class, 'edit'])->middleware('auth');


Route::get('/', function () {
    return view('welcome');
});
// Route::get('/ubahsudahdiambil', function () {
//     return view('formservis.ubahsudahdiambil');
// });


// Route::get('/bisadiambil', function () {
//     return view('tabelservisan.bisadiambil');
// });

// Route::get('/sudahdiambil', function () {
//     return view('tabelservisan.sudahdiambil');
// });

Route::get('/login', [LoginController::class, 'index'])->name('login')->middleware('guest');
Route::post('/login', [LoginController::class, 'authenticate']);
Route::post('/logout', [LoginController::class, 'logout']);

Route::get('/registrasi', [RegisterController::class, 'index'])->middleware('guest');
Route::post('/registrasi', [RegisterController::class, 'store']);


//ROUTE TERBARU

// Route::get('/servisanmasuk', function () {
//     $kategoriwisata = Kategoriwisata::all();

//     return view('formservis.servisanmasuk',[
//         'title' => 'Servisan Masuk',
//         'kategoriwis' => $kategoriwisata
//       ]);
// })->middleware('auth');



Route::resource('prosesservis',DataservisController::class)->middleware('auth');
Route::resource('bisadiambil',BisadiambilController::class)->middleware('auth');

// Route::get('/dashboard',function(){
//     return view('tabelservisan.halamandashboard',[
//       'title' => 'Dashboard'
//     ]);
// })->middleware('auth');

Route::get('/modalservisanmasuk',function(){
    return view('partials.modalservisanmasuk');
})->middleware('auth');

Route::Post('/modalservisanmasuk',function(){
    return view('partials.modalservisanmasuk');
})->middleware('auth');


Route::resource('sudahdiambil',SudahdiambilController::class)->middleware('auth');

Route::resource('editbsdiambil',ActionbsdiambilController::class)->middleware('auth');
Route::resource('editsudahdiambil',ActionsudahdiambilController::class)->middleware('auth');
Route::resource('dashboard',DashboardController::class)->middleware('auth');

// Route::get('/ubahbisadiambil',function(){
//     return view('formservis.ubahbisadiambil');
// })->middleware('auth');

// Route::get('/ubahbisadiambil', [BisadiambilController::class, 'show'])->middleware('auth');

// Route Aplikasi Admin Pariwisata
Route::resource('tabeldaftarwisata',TabeldaftarwisataController::class)->middleware('auth');
Route::resource('detailwisata',DetailController::class)->middleware('auth');


// Route::get('/tambahpariwisata', function () {
//     return view('form.tambahpariwisata',[
//         'title' => 'Tambah Pariwisata',
//       ]);
// })->middleware('auth');

Route::get('/tambahpariwisata',[TabeldaftarwisataController::class, 'tambahdata'])->middleware('auth');

Route::resource('tabeldaftarkategoriwisata',KategoriwisataController::class)->middleware('auth');

Route::get('/tambahkategoriwisata', function () {
    return view('form.tambahkategoriwisata',[
        'title' => 'Tambah Kategori'
      ]);
})->middleware('auth');
Route::resource('tabeldaftarpengunjungwisata',DaftarpengunjungwisataController::class)->middleware('auth');
Route::resource('tabeldaftarakunwisatawan',AkunwisatawanController::class)->middleware('auth');
Route::get('/tambahakunwisatawan', function () {
    return view('form.tambahakunwisatawan',[
        'title' => 'Tambah Akun Wisatawan'
      ]);
})->middleware('auth');

Route::resource('tentangaplikasi',TentangAplikasiController::class)->middleware('auth');



// Route::post('/temp-images',[TempImageController::class,'store'])->name('temp-images.create');


// Route::get('wisata', WisataComponent::class)->name('allWisata');
// // Route::get('/tambahwisata', function () {
// //     return view('livewire.wisata.add-wisata-component',[
// //         'title' => 'Wisata'
// //       ]);
// // })->middleware('auth');
// Route::get('wisata/add', AddWisataComponent::class)->name('addWisata')->middleware('auth');
// Route::get('wisata/edit/{id}', EditWisataComponent::class)->name('editWisata')->middleware('auth');