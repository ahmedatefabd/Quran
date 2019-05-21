package com.example.qurankarem.ayah;
import model.Ayah;
import model.Surah_Aya;
import Api.modelDB.AyahDB;

import java.util.List;

public interface AyahView {

    void setAyahList(List<Ayah> ayahList);
    void recyclerOfflineRoom(List<AyahDB> ayahDBList);
    void LoadDataOfflineRoom();
    void LoadData();
    void error();
    void controlToolbar(Surah_Aya surahAya);
    void Local();
    void ShimmerRecycler();
    void errorMessage();
    void control();
}