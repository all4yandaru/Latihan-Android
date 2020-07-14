package com.example.rtanote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnFloat;
    RecyclerView rvUser;
    List<Note> listNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFloat = findViewById(R.id.btn_float);
        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InputData.class);
                startActivity(intent);
                finish();
            }
        });

        rvUser = findViewById(R.id.rv_note);
        rvUser.setHasFixedSize(true);

        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "note")
                .allowMainThreadQueries()
                .build();

        listNotes = appDatabase.userDao().getAllNotes();

        rvUser.setLayoutManager(new LinearLayoutManager(this));
        rvUser.setAdapter(new NoteAdapter(listNotes, this));
    }
}
