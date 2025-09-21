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
        Schema::create('tabeldaftarwisatas', function (Blueprint $table) {
            $table->id();
            $table->string('kategori',100);
            $table->string('namawisata',100);
            $table->string('alamat',100);
            $table->string('biaya');
            $table->string('longitude',100);
            $table->string('latitude',100);
            $table->text('info');
            $table->string('fotobesar');
            $table->string('fotokecil1');
            $table->string('fotokecil2');
            $table->string('fotokecil3');
            $table->timestamps();
        });

    }
    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('tabeldaftarwisatas');
    }
};
