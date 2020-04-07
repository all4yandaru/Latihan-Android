package com.latihan.latihanintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etnama;
    Button btnintentbiasa, btnintentdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = findViewById(R.id.et_nama);

        btnintentbiasa = findViewById(R.id.btn_intent_biasa);
        btnintentdata = findViewById(R.id.btn_intent_data);

        btnintentbiasa.setOnClickListener(this);
        btnintentdata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_intent_biasa:
                Intent i = new Intent(getApplicationContext(),pindah2.class);
                startActivity(i);
                break;

            case R.id.btn_intent_data:
                String nama = etnama.getText().toString();
                Intent intent = new Intent(getApplicationContext(),pindah.class);
                intent.putExtra(pindah.nama, nama);
                startActivity(intent);
                break;
        }
    }
}
