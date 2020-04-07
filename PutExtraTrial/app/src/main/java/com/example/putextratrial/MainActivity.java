package com.example.putextratrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText etName;
    private Button btnGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        btnGo = findViewById(R.id.btn_go);

        btnGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
    }
}
