package com.example.qurankarem.DataBase.RoomDB.DAO;
import java.util.List;
import ModelDB.SuraDB;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DAO {

    @SuppressWarnings("unchecked")
    @Insert
     void addSuras(SuraDB suraDB);

    @SuppressWarnings("unchecked")
    @Query("DELETE FROM Suras")
     void deleteSuras();

    @SuppressWarnings("unchecked")
    @Query("select * from Suras")
    List<SuraDB> getAllSuras();


    @SuppressWarnings("unchecked")
    @Delete
     void deleteAllSuras(SuraDB suraDB);
}
