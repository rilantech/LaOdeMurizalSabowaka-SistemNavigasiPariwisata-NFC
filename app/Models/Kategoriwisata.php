<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Kategoriwisata extends Model
{
    use HasFactory;
    protected $table = 'kategoriwisata';
    public $timestamps = true;
    protected $fillable = ['nama','keterangan'];
}
