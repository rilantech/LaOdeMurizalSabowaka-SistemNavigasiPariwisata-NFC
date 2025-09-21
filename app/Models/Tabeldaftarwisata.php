<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;


class Tabeldaftarwisata extends Model
{
    use HasFactory;
    protected $table = 'tabeldaftarwisatas';
    protected $fillable = ['id','kategori','namawisata','alamat','biaya', 'longitude','latitude','info','fotobesar','fotokecil1','fotokecil2','fotokecil3'];
    public $timestamps = true;

    public function images(){
       
    }
 
  
   
}
