package com.example.film;

public class Film {
    private String Judul;
    private String TanggalRilis;
    private String Sutradara;
    private int Photo;
    private String Desc;

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getTanggalRilis() {
        return TanggalRilis;
    }

    public void setTanggalRilis(String tanggalRilis) {
        TanggalRilis = tanggalRilis;
    }

    public String getSutradara() {
        return Sutradara;
    }

    public void setSutradara(String sutradara) {
        Sutradara = sutradara;
    }

}
