package com.project.pendataanmahasiswaroomdb;
// TODO 3: buat interface DAO (Data Access Database) tambahin annotation @Dao

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MahasiswaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // kalo data udah ada, nanti bakal di replace
    long insertMahasiswa(Mahasiswa mahasiswa);

    // TODO 11: buat query untuk crud
    @Query("SELECT * FROM Mahasiswa")
    List<Mahasiswa> readDataMahasiswa();

    @Insert
    void insertData(Mahasiswa... mhs);

    @Delete
    void deleteMahasiswa(Mahasiswa... mahasiswa);

    @Update
    int updateMahasiswa(Mahasiswa mahasiswa);
    //void updateMhs(Mahasiswa... mhs);
}
