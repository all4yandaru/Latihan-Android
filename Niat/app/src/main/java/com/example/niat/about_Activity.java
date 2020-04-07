package com.example.niat;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class about_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_);

        Toolbar toolbar = findViewById(R.id.aboutToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PUBG MOBILE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

}
