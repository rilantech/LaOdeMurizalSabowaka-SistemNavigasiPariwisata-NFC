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
        Schema::create('akunwisatawan', function (Blueprint $table) {
            $table->id();
            $table->string('nama',200);
            $table->string('username',200);
            $table->string('password',200);
            $table->string('api_token')->unique()->nullable()->default(null);
            $table->rememberToken()->nullable();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('akunwisatawan');
    }
};
