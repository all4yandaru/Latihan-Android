package com.example.rtanote;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "Title")
    private String title;
    @ColumnInfo(name = "Date")
    private String date;
    @ColumnInfo(name = "Description")
    private String description;

    public Note(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    @Ignore
    public Note(int id, String title, String date, String description) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
