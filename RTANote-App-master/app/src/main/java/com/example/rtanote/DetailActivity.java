package com.example.rtanote;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    AlertDialog.Builder dialog;

    public static final String POSITION_EXTRA = "position_extra";
    List<Note> listNotes;

    EditText etTitle, etDesc;
    Button btnDelete, btnUpdate;

    AppDatabase appDatabase;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "note")
                .allowMainThreadQueries()
                .build();
        position = getIntent().getIntExtra(POSITION_EXTRA, 0);
        listNotes = appDatabase.userDao().getAllNotes();

        etTitle = findViewById(R.id.et_title);
        etDesc = findViewById(R.id.et_desc);
        btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(this);
        btnUpdate = findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(this);


        etTitle.setText(listNotes.get(position).getTitle());
        etDesc.setText(listNotes.get(position).getDescription());
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String formattedDate = dateFormat.format(date);

        switch (view.getId()){
            case R.id.btn_update:
                updateNote(intent, formattedDate);
                break;
            case R.id.btn_delete:
                deleteNote(intent, formattedDate);
                break;
        }
    }

    public void updateNote(Intent intent, String formattedDate){
        Note note = new Note(listNotes.get(position).getId(), etTitle.getText().toString(), formattedDate, etDesc.getText().toString());
        appDatabase.userDao().updateNote(note);
        startActivity(intent);
        finish();
    }

    public void deleteNote(Intent intent, String formattedDate){
        DialogForm(intent, formattedDate);
    }

    private void DialogForm(final Intent intent, final String formattedDate) {
        dialog = new AlertDialog.Builder(DetailActivity.this);
        dialog.setCancelable(true);

        dialog.setMessage("Are you sure to delete this one?");
        dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Note note = new Note(listNotes.get(position).getId(), etTitle.getText().toString(), formattedDate, etDesc.getText().toString());
                appDatabase.userDao().deleteNote(note);
                startActivity(intent);
                dialog.dismiss();
                finish();
            }
        });

        dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
