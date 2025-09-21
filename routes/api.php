<?php

use App\Http\Controllers\api\AuthController;
use App\Http\Controllers\api\DataservisController;
use App\Http\Controllers\Api\DatawisataController;
use App\Http\Controllers\AkunpengunjungController;
use App\Http\Controllers\CekkodewisataController;
use App\Http\Controllers\DaftarpengunjungwisataController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

// Route::apiResource('/dataservis', DataservisController::class);

// Route::post('dataservis/{dataservi}',[DataservisController::class, 'update']);
// Route::get('/api/dataservis', 'api\dataservis\DataservisController@index');


// API DATA WISATA
Route::get('/datawisata/{id}', [DatawisataController::class, 'index']);


// //Route Register
// Route::post('register', [AuthController::class, 'register']);

// //Route Login
// Route::post('login', [AuthController::class, 'login']);

//ROUTE TERBARU
Route::post('login',[AkunpengunjungController::class, 'login']);

Route::post('loginadmin',[AkunpengunjungController::class, 'loginadmin']);

Route::post('register',[AkunpengunjungController::class, 'register']);

Route::post('cekkodewisata',[CekkodewisataController::class, 'cekkodewisata']);

Route::post('tambahpengunjungwisata',[DaftarpengunjungwisataController::class, 'tambahpengunjungwisata']);

Route::middleware(['auth'])->group(function (){
    Route::get('userku',[AkunpengunjungController::class, 'index']);
    Route::post('logout',[AkunpengunjungController::class ,'logout']);
});
