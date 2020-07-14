package com.example.rtanote;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM Note")
    List<Note> getAllNotes();

    @Insert
    void insertData(Note... note);

    @Delete
    void deleteNote(Note... note);

    @Update
    void updateNote(Note... note);
}
