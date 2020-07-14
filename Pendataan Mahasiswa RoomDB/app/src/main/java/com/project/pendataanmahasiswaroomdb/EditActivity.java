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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class EditActivity extends AppCompatActivity {

    // TODO 26: Deklarasi Variable
    private TextInputEditText Nama, Jurusan, tanggalLahir;
    private AppDatabase database;
    private Button bSimpan;
    private RadioButton lakiLaki, perempuan;
    private RadioGroup jenisKelamin;
    private String myJenisKelamin;
    private Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Nama = findViewById(R.id.nama);
        Jurusan = findViewById(R.id.jurusan);
        tanggalLahir = findViewById(R.id.tanggal_lahir);
        jenisKelamin = findViewById(R.id.jenis_kelamin);
        lakiLaki = findViewById(R.id.laki_laki);
        perempuan = findViewById(R.id.perempuan);
        bSimpan = findViewById(R.id.save);

        //
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "dbMahasiswa").build();

        // TODO 27: jangan lupa menampilkan data mahasiswa yang akan di edit
        getDataMahasiswa();

        bSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mahasiswa.setNama(Nama.getText().toString());
                mahasiswa.setJurusan(Jurusan.getText().toString());
                mahasiswa.setTanggalLahir(tanggalLahir.getText().toString());
                mahasiswa.setJenisKelamin(myJenisKelamin);
                updateData(mahasiswa);
            }
        });
    }

    //Method untuk menapilkan data mahasiswa yang akan di edit
    private void getDataMahasiswa(){
        //Mendapatkan data dari Intent
        mahasiswa = (Mahasiswa)getIntent().getSerializableExtra("data");

        Nama.setText(mahasiswa.getNama());
        Jurusan.setText(mahasiswa.getJurusan());
        tanggalLahir.setText(mahasiswa.getTanggalLahir());
        switch (mahasiswa.getJenisKelamin()){
            case "Laki-Laki":
                lakiLaki.setChecked(true);
                perempuan.setChecked(false);
                myJenisKelamin = "Laki-Laki";
                break;

            case "Perempuan":
                lakiLaki.setChecked(false);
                perempuan.setChecked(true);
                myJenisKelamin = "Perempuan";
                break;
        }
    }

    //Menjalankan method Update Data
    @SuppressLint("StaticFieldLeak")
    private void updateData(final Mahasiswa mahasiswa){
        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... voids) {
                //Menjalankan proses insert data
                return database.mahasiswaDAO().updateMahasiswa(mahasiswa);
            }

            @Override
            protected void onPostExecute(Integer status) {
                //Menandakan bahwa data berhasil disimpan
                Toast.makeText(EditActivity.this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditActivity.this, ReadDataActivity.class));
                finish();
            }
        }.execute();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(EditActivity.this, ReadDataActivity.class));
        finish();
    }
}