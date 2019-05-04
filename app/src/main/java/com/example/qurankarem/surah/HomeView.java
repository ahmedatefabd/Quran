package com.example.qurankarem.surah;
import ModelDB.SuraDB;
import model.Surah;
import java.util.List;

public interface HomeView {

    void setSurahList(List<Surah> surahList);
    void recyclerOfflineRoom(List<SuraDB> surahDBList);
    void LoadDataOfflineRoom();
    void LoadData();
    void error();
    void controlToolbar();
    void Local();
    void ShimmerRecycler();
    void errorMessage();
    void control();
}
