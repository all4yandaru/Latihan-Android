package com.example.film;

import java.util.ArrayList;

public class FilmData {
    public static String Judul[] = new String[]{
            "Avengers: Endgame",
            "Captain Marvel",
            "Spider-Man: Far From Home",
            "Joker",
            "John Wick: Chapter 3 - Parabellum",
            "Aladdin",
            "Gundala",
            "Star Wars: The Rise of Skywalker",
            "Frozen 2",
            "Toy Story 4"
    };

    public static int[] Photo = new int[]{
            R.drawable.endgame, R.drawable.captmarvel, R.drawable.farfromhome, R.drawable.joker,
            R.drawable.john3, R.drawable.aladin, R.drawable.gundala, R.drawable.starwars, R.drawable.frozen,
            R.drawable.toystory
    };

    public static String[] TanggalRilis = new String[]{
            "24 April 2019",
            "8 Maret 2019",
            "3 Juli 2019",
            "2 Oktober 2019",
            "17 Mei 2019",
            "24 Mei 2019",
            "29 Agustus 2019",
            "18 Desember 2019",
            "20 November 2019",
            "20 Juni 2019"
    };

    public static String[] Sutradara = new String[]{
            "Russo Bersaudara, Joe Russo",
            "Anna Boden, Ryan Fleck",
            "Jon Watts",
            "Todd Phillips",
            "Chad Stahelski",
            "Guy Ritchie",
            "Joko Anwar",
            "J.J. Abrams",
            "Jennifer Lee, Chris Buck",
            "Josh Cooley"
    };

    public static String[] Desc = new String[]{
            "Melanjutkan Avengers Infinity War, dimana kejadian setelah Thanos berhasil mendapatkan semua infinity stones dan memusnahkan 50% semua mahluk hidup di alam semesta. Akankah para Avengers berhasil mengalahkan Thanos?",
            "Captain Marvel adalah superhero wanita dari Marvel yang mempunyai banyak kekuatan setara seperti Superman. Superhero yang bernama Carol Danvers ini awalnya merupakan seorang pilot luar angkasa, konon ia mendapatakan kekuatan supernya dari bangsa alien.",
            "Peter Parker (Tom Holland) tengah mengunjungi Eropa untuk liburan panjang bersama temaan-temanya. Sayangnya , Parker tidak bisa dengan tenang menikmati liburannya, karena Nick Fury datang secara tiba-tiba di kamar hotelnya. Selama di Eropa pun Peter harus menghadapi banyak musuh mulai dari Hydro Man, Sandman dan Molten Man.",
            "Joker adalah film cerita seru psikologis Amerika Serikat tahun 2019 yang disutradarai oleh Todd Phillips dan diproduseri oleh Todd Philips, Bradley Cooper, dan Emma Tillinger Koskoff.",
            "DeskripsiSeri ketiga \"John Wick\" ini akan mengisahkan kelanjutan nasib si pembunuh bayaran usai menghabisi nyawa anggota High Table dalam The Continental. Ia sendiri diburu dan hidupnya dihargai sebesar USD 14 juta (sekitar Rp 201 miliar). Diburu oleh berbagai pembunuh bayaran hebat, John akan dibantu oleh karakter baru yang misterius bernama Sofia (Halle Berry).",
            "Aladdin, seorang anak jalanan yang jatuh cinta pada seorang putri. Dengan perbedaan kasta dan harta, Aladdin pun berusaha mencari jalan agar bisa mejadi seorang pangeran, tak disangka ia menemukan lampu dengan jin di dalamnya. Aladdin pun menggunakan lampu untuk mengubah dirinya menjadi seorang pangeran untuk memenangkan hatiPutri Jasmine, tapi Wazir jahat juga mengejar lampu tersebut untuk menguasai kerajaan.",
            "Sancaka hidup di jalanan sejak ditinggal ayah dan ibunya. Menghadapi hidup yang keras, Sancaka belajar untuk bertahan hidup dengan tidak peduli dengan orang lain dan hanya mencoba untuk mendapatkan tempat yang aman bagi dirinya sendiri. Ketika situasi kota semakin tidak aman dan ketidakadilan merajalela di seluruh negeri, Sancaka harus buat keputusan yang berat, tetap hidup di zona amannya, atau keluar sebagai Gundala untuk membela orang-orang yang ditindas.",
            "Resistance yang selamat sekali lagi akan menghadapi First Order dalam sebuah saga final yang akan menentukan nasib mereka.",
            "Anna, Elsa, Kristoff, Olaf dan Sven pergi meninggalkan Arendelle untuk melakukan perjalanan ke sebuah tempat asing dan penuh keajaiban. Mereka berangkat untuk menemukan asal usul kekuatan Elsa dan juga untuk menyelamatkan kerajaan mereka. Kali ini akan ada teks lirik lagu sehingga penonton bisa ikut bernyanyi bersama karakter Frozen II favorit mereka.",
            "Woody selalu merasa percaya diri akan posisinya di dunia, dan prioritasnya adalah menjaga anaknya, baik itu Andy atau Bonnie. Namun ketika Bonnie menambahkan sebuah mainan baru bernama Forky dalam kamar mainannya, sebuah pengembaraan bersama teman-teman lama dan baru akan membawa Woody untuk menyaksikan betapa besarnya dunia ini bagi sebuah mainan seperti dirinya."
    };


    public static ArrayList<Film> getListData(){
        ArrayList<Film> list = new ArrayList<>();

        for (int i=0; i<Judul.length; i++){
            Film data = new Film();
            data.setJudul(Judul[i]);
            data.setPhoto(Photo[i]);
            data.setTanggalRilis(TanggalRilis[i]);
            data.setSutradara(Sutradara[i]);
            data.setDesc(Desc[i]);

            list.add(data);
        }
        return list;
    }
}
