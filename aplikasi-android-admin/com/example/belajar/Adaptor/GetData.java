package com.example.belajar.Adaptor;

public class GetData {
    String alamat = "";
    String biaya = "";
    String foto = "";
    int id = 0;
    String info = "";
    String kategori = "";
    String kodewisata = "";
    String latitude = "";
    String longitude = "";
    String namawisata = "";

    public GetData(int id2, String kodewisata2, String kategori2, String namawisata2, String alamat2, String biaya2, String longitude2, String latitude2, String info2, String foto2) {
        this.id = id2;
        this.kodewisata = kodewisata2;
        this.kategori = kategori2;
        this.namawisata = namawisata2;
        this.alamat = alamat2;
        this.biaya = biaya2;
        this.longitude = longitude2;
        this.latitude = latitude2;
        this.info = info2;
        this.foto = foto2;
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }

    public String getKodewisata() {
        return this.kodewisata;
    }

    public String getKategori() {
        return this.kategori;
    }

    public String getNamawisata() {
        return this.namawisata;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public String getBiaya() {
        return this.biaya;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getInfo() {
        return this.info;
    }

    public String getFoto() {
        return this.foto;
    }
}
