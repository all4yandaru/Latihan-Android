package com.example.niat;

import java.util.ArrayList;

import static com.example.niat.R.drawable.luxxy;

public class GunData {
    public static String[]data = new String[]{
            "Bigetron Esport", "Evos Esport", "Onic", "RRQ Ryu", "Victim Esport", "Iluminate", "Purple Mood",
            "RRQ Athena", "WAW Esport", "Team Secret"};
    public static String[]from = new  String[]{
      "Team From : Indonesia","Team From : Indonesia","Team From : Indonesia","Team From : Indonesia","Team From : Indonesia","Team From : Thailand","Team From : Thailand","Team From : Thailand","Team From : Indonesia","Team From : Malaysia"
    };
    public static  int [] photo = new int[]{
      R.drawable.bigetron_logo,R.drawable.evos,R.drawable.onic,R.drawable.rrq,R.drawable.victim,
      R.drawable.iluminate,R.drawable.plm,R.drawable.rrq,R.drawable.waw,R.drawable.ts
    };
    public static int [] Sniper_img = new int[]{
            luxxy,R.drawable.jughead,R.drawable.matthew,R.drawable.kenbo,R.drawable.viell,R.drawable.martinn,R.drawable.naw,R.drawable.g9,
            R.drawable.takanome,R.drawable.stewart9k

    };

    public static  String[] Dari = new String[]{
            "Indonesia ","Indonesia","Indonesia","Indonesia","Indonesia","Thailand","Thailand","Thailand","Indonesia","Malaysia"
    };
    public static String[] Sniper = new String[]{
            "Luxxy","Jughed","Matthew","Kenboo","Viell","Martin","Nawin","G9","Takanome","Stwart9k"

    };
    public static String[] Rusher = new  String[]{
            "Ryzen","Auro","Nikk","Dron","Banyu","aRNJoNe","Cz","D2e","Nay","Biubiu"
    };
    public static String[] Observer = new  String[]{
            "Zuxxy","Foxe","Exc","Warunk","Mizu","Goddard","Zoom","Senior","Cupaw","Sinb"
    };
    public static String[] Support = new  String[]{
            "Microboy","Jeixy","Sky","Boonk","Onid","Madtoi","Jasper","Earnny","Jrx","Alexer"
    };

    public static ArrayList<Gun> getListData(){
        ArrayList<Gun> list = new ArrayList<>();
        for (int i = 0;i< data.length;i++){
        Gun gun = new Gun();

            gun.setGun(data[i]);
            gun.setStyle(from[i]);
            gun.setPicture(photo[i]);
            gun.setDari(Dari[i]);
            gun.setSniper_name(Sniper[i]);
            gun.setRusher_name(Rusher[i]);
            gun.setObserver_name(Observer[i]);
            gun.setSupport_name(Support[i]);
            gun.setSniper(Sniper_img[i]);


            list.add(gun);

        }
        return list;
    }
}
