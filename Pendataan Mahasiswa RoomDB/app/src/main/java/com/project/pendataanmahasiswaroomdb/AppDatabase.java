package com.project.pendataanmahasiswaroomdb;


/*
 * Membuat Class Database
 * Entity yang digunakan adalah Mahasiswa.class
 * Version = 1
 */
// TODO 4: buat abstract class extends RoomDatabase, jangan lupa tambahin annotationnya

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MahasiswaDAO mahasiswaDAO();
}
