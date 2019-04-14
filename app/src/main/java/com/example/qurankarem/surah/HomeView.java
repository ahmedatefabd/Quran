package com.example.qurankarem.surah;
import model.Surah;
import Api.modelDB.SurahDB;
import java.util.List;

public interface HomeView {

    void setSurahList(List<Surah> surahList);
    void recyclerOfflineRoom(List<SurahDB> surahDBList);
    void LoadDataOfflineRoom();
    void LoadData();
    void error();
    void controlToolbar();
    void Local();
    void ShimmerRecycler();
    void errorMessage();
    void control();
}
