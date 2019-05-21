package com.example.qurankarem.surah;
import ModelDB.SuraDB;
import model.Surah_Aya;
import java.util.List;

public interface HomeView {

    void setSurahList(List<Surah_Aya> surahAyaList);
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
