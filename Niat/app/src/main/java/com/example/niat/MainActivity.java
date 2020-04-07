package com.example.niat;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rvGun;
    private ArrayList<Gun> list = new ArrayList<>();
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView BtnAbout = findViewById(R.id.person);
        BtnAbout.setOnClickListener(this);



        rvGun = findViewById(R.id.rv_gun);
        rvGun.setHasFixedSize(true);
        list.addAll(GunData.getListData());
        showRecyclerList();
    }
    public  void rv_click(View view){
        startActivity(new Intent(this,about_Activity.class));
    }


    private void showRecyclerList() {
        rvGun.setLayoutManager(new LinearLayoutManager(this));
        ListGunAdapter listHeroAdapter = new ListGunAdapter(this);
        listHeroAdapter.setListGun(list);
        rvGun.setAdapter(listHeroAdapter);
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,about_Activity.class));

        }


}
