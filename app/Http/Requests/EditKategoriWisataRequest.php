<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class EditKategoriWisataRequest extends FormRequest
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
            'nama' => 'required|max:500',
            'keterangan' => 'required|max:500'
            
        ];
        
    }

    public function messages(): array
    {
        return [
            'nama.required' => ':attribute Tidak Boleh Kosong',
            'keterangan.required' => ':attribute Tidak Boleh Kosong'

        ];
    }

    public function attributes(): array
    {
        return [
           
            'nama' => 'Kode Wisata',
            'keterangan' => 'Kategori'
           
        ];
    }

}
