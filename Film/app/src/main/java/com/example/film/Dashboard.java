package com.example.film;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    private RecyclerView rvFilm;
    ArrayList<Film> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvFilm = findViewById(R.id.rv_item);
        list.addAll(FilmData.getListData());
        showRecycler();
    }

    private void showRecycler(){
        rvFilm.setLayoutManager(new LinearLayoutManager(this));
        FilmAdapter filmAdapter = new FilmAdapter(this);
        filmAdapter.setListFilm(list);
        rvFilm.setAdapter(filmAdapter);
    }
}
