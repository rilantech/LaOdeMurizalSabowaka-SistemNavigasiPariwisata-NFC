<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class TambahPariwisataRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize(): bool
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array|string>
     */
    public function rules(): array
    {
        return [
            'kodewisata' => 'required',
            'kategori' => 'required',
            'namawisata' => 'required|max:500',
            'alamat' => 'required',
            'biaya' => 'required',
            'longitude' => 'required',
            'latitude' => 'required',
            'info' => 'required',
            'fotobesar' => 'required|image|mimes:jpeg,jpg,png|max:5000',
            'fotokecil1' => 'required|image|mimes:jpeg,jpg,png|max:5000',
            'fotokecil2' => 'required|image|mimes:jpeg,jpg,png|max:5000',
            'fotokecil3' => 'required|image|mimes:jpeg,jpg,png|max:5000'
        ];
        
    }

    public function messages(): array
    {
        return [
            'kodewisata.required' => ':attribute Tidak Boleh Kosong',
            'kategori.required' => ':attribute Tidak Boleh Kosong',
            'namawisata.required' => ':attribute Tidak Boleh Kosong',
            'alamat.required' => ':attribute Tidak Boleh Kosong',
            'biaya.required' => ':attribute Tidak Boleh Kosong',
            'longitude.required' => ':attribute Tidak Boleh Kosong',
            'latitude.required' => ':attribute Tidak Boleh Kosong',
            'info.required' => ':attribute Tidak Boleh Kosong',
            'fotobesar.required' => ':attribute Belum Di Upload',
            'fotokecil1.required' => ':attribute Belum Di Upload',
            'fotokecil2.required' => ':attribute Belum Di Upload',
            'fotokecil3.required' => ':attribute Belum Di Upload'
        ];
    }

    public function attributes(): array
    {
        return [
           
            'kodewisata' => 'Kode Wisata',
            'kategori' => 'Kategori',
            'namawisata' => 'Nama Wisata',
            'alamat' => 'Alamat',
            'biaya' => 'Biaya',
            'longitude' => 'Longitude',
            'latitude' => 'Latitude',
            'info' => 'Info',
            'fotobesar' => 'Foto Besar',
            'fotokecil1' => 'Foto Kecil 1',
            'fotokecil2' => 'Foto Kecil 2',
            'fotokecil3' => 'Foto Kecil 3'

        ];
    }

}
