<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class EditPengunjungWisataRequest extends FormRequest
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
            'tanggal' => 'required',
            'nama' => 'required',
            'wisata' => 'required',
            'alamat' => 'required'
            
        ];
        
    }

    public function messages(): array
    {
        return [
            'tanggal.required' => ':attribute Tidak Boleh Kosong',
            'nama.required' => ':attribute Tidak Boleh Kosong',
            'wisata.required' => ':attribute Tidak Boleh Kosong',
            'alamat.required' => ':attribute Tidak Boleh Kosong'

        ];
    }

    public function attributes(): array
    {
        return [
           
            'tanggal' => 'Tanggal',
            'nama' => 'Nama',
            'wisata' => 'Wisata',
            'alamat' => 'Alamat',
           
        ];
    }

}
