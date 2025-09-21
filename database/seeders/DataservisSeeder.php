<?php

namespace Database\Seeders;

use App\Models\Dataservis;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class DataservisSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        Dataservis::factory()->count(50)->create();
    }
}
