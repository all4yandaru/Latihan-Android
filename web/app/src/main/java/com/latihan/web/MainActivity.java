package com.latihan.web;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnGoogle, btnRajin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoogle = findViewById(R.id.btn_google);
        btnRajin = findViewById(R.id.btn_rajin);

        btnRajin.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);

        Toast.makeText(this, "Activity onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "Activity onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Activity onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "Activity onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "Activity onStop()", Toast.LENGTH_SHORT).show();
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_google:
                Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(google);
                break;
            case R.id.btn_rajin:
                Intent rajin = new Intent(Intent.ACTION_VIEW);
                rajin.setData(Uri.parse("http://www.makinrajin.com"));
                startActivity(rajin);
                break;
        }
    }

}
