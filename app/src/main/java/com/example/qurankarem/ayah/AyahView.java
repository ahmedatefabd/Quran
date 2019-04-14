package com.example.qurankarem.ayah;
import model.Ayah;
import model.Surah;
import Api.modelDB.AyahDB;
import java.util.List;

public interface AyahView {

    void setAyahList(List<Ayah> ayahList);
    void recyclerOfflineRoom(List<AyahDB> ayahDBList);
    void LoadDataOfflineRoom();
    void LoadData();
    void error();
    void controlToolbar(Surah surah);
    void Local();
    void ShimmerRecycler();
    void errorMessage();
    void control();
}