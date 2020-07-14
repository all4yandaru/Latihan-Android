package com.example.rtanote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputData extends AppCompatActivity {

    EditText etTitle, etDesc;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        etTitle= findViewById(R.id.et_in_title);
        etDesc = findViewById(R.id.et_in_desc);
        btnSave = findViewById(R.id.btn_save);

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        final String formattedDate = dateFormat.format(date);

        final AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "note")
                .allowMainThreadQueries()
                .build();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note(etTitle.getText().toString(), formattedDate, etDesc.getText().toString());
                appDatabase.userDao().insertData(note);

                Intent intent = new Intent(InputData.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
