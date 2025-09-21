<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Dataservis>
 */
class DataservisFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            //
            'nama' => fake()->name(),
            'notelp' => rand(1,9999999999),
            'barang' => 'laptop',
            'kerusakan' => 'mati total',
            'tglmasuk' => fake()->date()


        ];
    }
}
