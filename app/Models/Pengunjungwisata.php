<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Pengunjungwisata extends Model
{
    use HasFactory;
    protected $table = 'pengunjungwisatas';
    public $timestamps = true;
    protected $fillable = ['tanggal','nama','wisata','alamat'];
}
