package com.latihan.recyclervieww;

import java.util.ArrayList;

public class MinumanData {

    public static String Nama[] = new String[]{
            "Susu Permaisuri",
            "Susu Nyai",
            "Susu Rondo",
            "Susu Ratu Ijo",
            "Kopi Sultan",
            "Kopi Ajudan",
            "Coklat Sultan",
            "Coklat Raden",
            "Thai Tea"
    };

    public static int Harga[] = new int[]{
            12000,14000,14000,14000,13000,10000,12000,10000,10000
    };

    public static String Desc[] = new String[]{
            "Minuman Sehat yang diproduksi langsung di tempat"
    };

    public static ArrayList<Minuman> getlistData(){
        ArrayList<Minuman> list = new ArrayList<>();
        for (int i=0; i<Nama.length; i++){
            Minuman gelas = new Minuman();
            gelas.setNama(Nama[i]);
            gelas.setHarga(Harga[i]);
            gelas.setDesc(Desc[0]);

            list.add(gelas);
        }

        return list;
    }


}
