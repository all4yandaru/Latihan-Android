package com.project.pendataanmahasiswaroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadDataActivity extends AppCompatActivity {

    // TODO 21: Deklarasi Variable
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private AppDatabase database;
    private List<Mahasiswa> daftarMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        // TODO 22: Inisialisasi ArrayList
        daftarMahasiswa = new ArrayList<>();

        recyclerView = findViewById(R.id.dataItem);

        //Inisialisasi RoomDatabase
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "dbMahasiswa").allowMainThreadQueries().build();

        /*
         * Mengambil data Mahasiswa dari Database
         * lalu memasukannya ke kedalam ArrayList (daftarMahasiswa)
         */
        daftarMahasiswa = database.mahasiswaDAO().readDataMahasiswa();

        //Agar ukuran RecyclerView tidak berubah
        recyclerView.setHasFixedSize(true);

        //Menentukan bagaimana item pada RecyclerView akan tampil
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Mamasang adapter pada RecyclerView
        adapter = new RecyclerMahasiswaAdapter(daftarMahasiswa, ReadDataActivity.this);
        recyclerView.setAdapter(adapter);
    }
}