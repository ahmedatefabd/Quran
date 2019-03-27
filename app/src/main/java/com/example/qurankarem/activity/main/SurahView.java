package com.example.qurankarem.activity.main;

import com.example.qurankarem.model.Surah;
import com.example.qurankarem.modelDB.SurahDB;

import java.util.List;

public interface SurahView {

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
