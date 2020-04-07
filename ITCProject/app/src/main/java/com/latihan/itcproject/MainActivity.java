package com.latihan.itcproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //TODO 12. BUAT CODINGANNYA UNTUK DITAMPILIN

    private RecyclerView rvMinuman;
    ArrayList<Minuman> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMinuman = findViewById(R.id.rv_item);

        list.addAll(MinumanData.getistData());
        showRecycler();
    }

    private void showRecycler() {
        rvMinuman.setLayoutManager(new LinearLayoutManager(this));
        MinumanAdapter minumanAdapter = new MinumanAdapter(list);
        rvMinuman.setAdapter(minumanAdapter);
    }
}
