package com.project.pendataanmahasiswaroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TODO 8: deklarasi
    private TextInputEditText NIM, Nama, Jurusan, tanggalLahir;
    private AppDatabase database;
    private Button bSimpan, bLihatData;
    private RadioButton lakiLaki, perempuan;
    private String myJenisKelamin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 9: buat findViewById & onClickListener

        NIM = findViewById(R.id.nim);
        Nama = findViewById(R.id.nama);
        Jurusan = findViewById(R.id.jurusan);
        tanggalLahir = findViewById(R.id.tanggal_lahir);

        lakiLaki = findViewById(R.id.laki_laki);
        perempuan = findViewById(R.id.perempuan);

        bSimpan = findViewById(R.id.save);
        bSimpan.setOnClickListener(this);

        bLihatData = findViewById(R.id.show);
        bLihatData.setOnClickListener(this);

        // TODO 10: Menentukan Jenis Kelamin pada Data Mahasiswa Baru
        if(lakiLaki.isChecked()){
            myJenisKelamin = "Laki-Laki";
        }else if (perempuan.isChecked()){
            myJenisKelamin = "Perempuan";
        }

    }

    @Override
    public void onClick(View v) {
        // TODO 12: buat case nya
        switch (v.getId()){
            case R.id.save:

                //Mengecek Data NIM dan Nama
                if(NIM.getText().toString().isEmpty() || Nama.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "NIM atau Nama TIdak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }else {
                    //Membuat Instance/Objek Dari Class Entity Mahasisiwaa
                    Mahasiswa data = new Mahasiswa();

                    //Memasukan data yang diinputkan user pada database
                    data.setNim(NIM.getText().toString());
                    data.setNama(Nama.getText().toString());
                    data.setJurusan(Jurusan.getText().toString());
                    data.setTanggalLahir(tanggalLahir.getText().toString());
                    data.setJenisKelamin(myJenisKelamin);
                    //insertData(data);

                    final AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "dbMahasiswa")
                            .allowMainThreadQueries()
                            .build();

                    appDatabase.mahasiswaDAO().insertMahasiswa(data);


                    //Mengembalikan EditText menjadi seperti semula\
                    NIM.setText("");
                    Nama.setText("");
                    Jurusan.setText("");
                    tanggalLahir.setText("");
                }
                break;

            case R.id.show:
                startActivity(new Intent(MainActivity.this, ReadDataActivity.class));
                break;
        }
    }
}