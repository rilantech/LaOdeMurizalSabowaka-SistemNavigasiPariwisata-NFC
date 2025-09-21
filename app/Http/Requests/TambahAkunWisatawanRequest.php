<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class TambahAkunWisatawanRequest extends FormRequest
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
            'nama' => 'required',
            'username'=> 'required|unique:users',
            'password' => 'required'
            
        ];
        
    }

    public function messages(): array
    {
        return [
            'nama.required' => ':attribute Tidak Boleh Kosong',
            'username.required' => ':attribute Tidak Boleh Kosong',
            'password.required' => ':attribute Tidak Boleh Kosong'

        ];
    }

    public function attributes(): array
    {
        return [
           
            'nama' => 'Nama',
            'username' => 'Username',
            'password' => 'Password'
           
        ];
    }

}
