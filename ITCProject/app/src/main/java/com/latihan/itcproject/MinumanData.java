package com.latihan.itcproject;

import java.util.ArrayList;

public class MinumanData {
    //TODO 4. BUAT SEMUA ISI DATA

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
            "Susu segar yang diproduksi dengan bumbu rahasia"
    };

    //TODO 5. ADD DATA PAKEK SET SET AN

    public static ArrayList<Minuman> getistData(){
        ArrayList<Minuman> list = new ArrayList<>(); //BUAT RAK / NAMPAN BUAT GELAS
        for (int i =0; i<Nama.length; i++){
            Minuman gelas = new Minuman(); // INI GELAS
            gelas.setNama(Nama[i]); //INI NARUH BAHAN2 MINUMAN
            gelas.setHarga(Harga[i]);
            gelas.setDesc(Desc[0]);

            list.add(gelas); // INI NARUH GELAS KE NAMPAN / RAK
        }
        return list; // RAK SIAP DIBAWA KELILING JUALAN
    }
}
