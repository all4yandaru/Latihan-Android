package com.latihan.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class pindah extends AppCompatActivity {
    public static final String nama = "Kamu";

    TextView tvnama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah);

        String Nama = getIntent().getStringExtra(nama);
        if (!Nama.isEmpty()){
            tvnama = findViewById(R.id.tv_nama);
            tvnama.setText("Hi " + Nama + "!");
        }

    }
}
