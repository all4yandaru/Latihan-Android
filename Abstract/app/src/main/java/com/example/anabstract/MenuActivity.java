package com.example.anabstract;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private EditText n1, n2;
    private Button bTambah, bKurang, bKali, bBagi;
    private TextView tHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        n1 = findViewById(R.id.etNilai1);
        n2 = findViewById(R.id.etNilai2);
        tHasil = findViewById(R.id.tvHasil);
        bTambah = findViewById(R.id.btnTambah);
        bKurang = findViewById(R.id.btnKurang);
        bKali = findViewById(R.id.btnKali);
        bBagi = findViewById(R.id.btnBagi);

        bTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nilai1 = n1.getText().toString();
                    String nilai2 = n2.getText().toString();

                    double dbNilai1 = Double.parseDouble(nilai1);
                    double dbNilai2 = Double.parseDouble(nilai2);
                    double dbHasil = dbNilai1 + dbNilai2;
                    tHasil.setText(String.valueOf(dbHasil));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nilai1 = n1.getText().toString();
                    String nilai2 = n2.getText().toString();

                    double dbNilai1 = Double.parseDouble(nilai1);
                    double dbNilai2 = Double.parseDouble(nilai2);
                    double dbHasil = dbNilai1 - dbNilai2;

                    tHasil.setText(String.valueOf(dbHasil));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nilai1 = n1.getText().toString();
                    String nilai2 = n2.getText().toString();

                    double dbNilai1 = Double.parseDouble(nilai1);
                    double dbNilai2 = Double.parseDouble(nilai2);
                    double dbHasil = dbNilai1 * dbNilai2;

                    tHasil.setText(String.valueOf(dbHasil));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nilai1 = n1.getText().toString();
                    String nilai2 = n2.getText().toString();

                    double dbNilai1 = Double.parseDouble(nilai1);
                    double dbNilai2 = Double.parseDouble(nilai2);
                    double dbHasil = dbNilai1 / dbNilai2;

                    tHasil.setText(String.valueOf(dbHasil));
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
