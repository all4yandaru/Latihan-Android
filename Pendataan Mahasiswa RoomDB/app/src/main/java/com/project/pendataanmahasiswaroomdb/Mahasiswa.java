package com.project.pendataanmahasiswaroomdb;
// TODO 2: bual class mahasiswa untuk menampung entity & implements Serializable, jangan lupa annotationnya

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Mahasiswa implements Serializable {

    @PrimaryKey // @PrimaryKey(autoGenerate = true) kalo mau auto increment
    @ColumnInfo(name = "nim_mahasiswa")
    @NonNull
    private String nim;

    @ColumnInfo(name = "nama_mahasiswa")
    private String nama;

    @ColumnInfo(name = "tanggal_lahir")
    private String tanggalLahir;

    @ColumnInfo(name = "jurusan")
    private String jurusan;

    @ColumnInfo(name = "jenis_kelamin")
    private String jenisKelamin;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
