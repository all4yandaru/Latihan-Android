package com.latihan.asimplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calculator extends AppCompatActivity implements View.OnClickListener {
    public static final String NAME = "kamu";

    TextView tvNama, tvHasil;
    EditText etAngka1, etAngka2;
    Button btnTambah, btnKurang, btnKali, btnBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        String nama =getIntent().getStringExtra(NAME);
        tvNama = findViewById(R.id.tv_nama);
        tvNama.setText("Hi " + nama + "!");

        etAngka1 = findViewById(R.id.et_angka1);

        etAngka2 = findViewById(R.id.et_angka2);

        btnTambah = findViewById(R.id.btn_tambah);
        btnTambah.setOnClickListener(this);

        btnKurang = findViewById(R.id.btn_kurang);
        btnKurang.setOnClickListener(this);

        btnKali = findViewById(R.id.btn_kali);
        btnKali.setOnClickListener(this);

        btnBagi = findViewById(R.id.btn_bagi);
        btnBagi.setOnClickListener(this);

        tvHasil = findViewById(R.id.tv_hasil);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_tambah :
                penjumlahan();
                break;

            case R.id.btn_kurang :
                pengurangan();
                break;

            case R.id.btn_kali :
                perkalian();
                break;

            case R.id.btn_bagi :
                pembagian();
                break;
        }
    }

    private void penjumlahan(){
        try{
            String angka1 = etAngka1.getText().toString();
            String angka2 = etAngka2.getText().toString();

            double dbAngka1 = Double.parseDouble(angka1);
            double dbAngka2 = Double.parseDouble(angka2);
            double dbHasil = dbAngka1 + dbAngka2;

            String hasil = String.valueOf(dbHasil);

            tvHasil.setText(hasil);
        }catch (Exception e){
            Toast.makeText(this, "Gaboleh ada yang kosong ***", Toast.LENGTH_SHORT).show();
        }
    }

    private void pengurangan(){
        try{
            String angka1 = etAngka1.getText().toString();
            String angka2 = etAngka2.getText().toString();

            double dbAngka1 = Double.parseDouble(angka1);
            double dbAngka2 = Double.parseDouble(angka2);
            double dbHasil = dbAngka1 - dbAngka2;

            String hasil = String.valueOf(dbHasil);

            tvHasil.setText(hasil);
        }catch (Exception e){
            Toast.makeText(this, "Gaboleh ada yang kosong ***", Toast.LENGTH_SHORT).show();
        }
    }

    private void perkalian(){
        try{
            String angka1 = etAngka1.getText().toString();
            String angka2 = etAngka2.getText().toString();

            double dbAngka1 = Double.parseDouble(angka1);
            double dbAngka2 = Double.parseDouble(angka2);
            double dbHasil = dbAngka1 * dbAngka2;

            String hasil = String.valueOf(dbHasil);

            tvHasil.setText(hasil);
        }catch (Exception e){
            Toast.makeText(this, "Gaboleh ada yang kosong ***", Toast.LENGTH_SHORT).show();
        }
    }

    private void pembagian(){
        try{
            String angka1 = etAngka1.getText().toString();
            String angka2 = etAngka2.getText().toString();

            double dbAngka1 = Double.parseDouble(angka1);
            double dbAngka2 = Double.parseDouble(angka2);
            double dbHasil = dbAngka1 / dbAngka2;

            String hasil = String.valueOf(dbHasil);

            tvHasil.setText(hasil);
        }catch (Exception e){
            Toast.makeText(this, "Gaboleh ada yang kosong ***", Toast.LENGTH_SHORT).show();
        }
    }
}
