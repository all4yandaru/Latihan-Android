package com.example.myprojecct;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText et_username, et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.etUsername);
        et_password = findViewById(R.id.etPassword);
        btn_login = findViewById(R.id.btnLogin);

        btn_login.setOnClickListener(this);
    }

    private void login() {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        if (TextUtils.isEmpty(password)) {
            et_password.setError("Password tidak boleh kosong");
        }

        if (password.equals("123")) {
            Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), MenuActivity.class);
            i.putExtra("df", username);
            startActivity(i);
        } else {
            AlertDialog.Builder builder = new
                    AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Username atau Password Salah").setNegativeButton("Ulangi", null).create().show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                login();
                break;
        }
    }
}
