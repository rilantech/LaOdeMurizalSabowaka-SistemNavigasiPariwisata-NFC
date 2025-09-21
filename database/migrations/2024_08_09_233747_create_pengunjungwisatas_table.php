<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('pengunjungwisatas', function (Blueprint $table) {
            $table->id();
            $table->string('tanggal', 200);
            $table->string('nama', 200);
            $table->string('wisata', 200);
            $table->string('alamat', 200);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pengunjungwisatas');
    }
};
