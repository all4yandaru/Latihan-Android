package com.example.anabstract;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText un, pw;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        un = findViewById(R.id.EtUsername);
        pw = findViewById(R.id.EtPassword);
        login = findViewById(R.id.BtnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = un.getText().toString();
                String password = pw.getText().toString();

                if (TextUtils.isEmpty((username))) {
                    un.setError("Username tidak boleh kosong");
                }
                if (TextUtils.isEmpty((password))) {
                    pw.setError("Password tidak boleh kosong");
                }

                if (username.equals("Allyandaru") && password.equals("123180054")) {
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(i);
                } else {
                    AlertDialog.Builder builder = new
                            AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau Password Salah").setNegativeButton("Ulangi", null).create().show();
                }
            }
        });
    }
}




