package com.latihan.asimplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNama;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_submit:
                String NAMA = etNama.getText().toString();
                Toast.makeText(this, "Hi " + NAMA, Toast.LENGTH_SHORT).show();
                Intent move =new Intent(getApplicationContext(),calculator.class);
                move.putExtra(calculator.NAME,NAMA);
                startActivity(move);
                break;
        }
    }
}
