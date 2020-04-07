package com.example.myprojecct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tv_text = findViewById(R.id.tvText);

        //buat cek username atau data nya kosong apa engga
        if (savedInstanceState == null){

            //pake ini klo data yg dikirim banyak
            Bundle bundle = getIntent().getExtras();
            if(bundle!=null){
                String us = bundle.getString("df");

                tv_text.setText(us + " !");
            }
        }
    }
}
