package com.example.qurankarem.readers;

import java.util.List;

import model.Readers;

public interface ReadersView {
    void setReaderList(List<Readers> readerList);
//    void recyclerOfflineRoom(List<SuraDB> surahDBList);
    void LoadDataOfflineRoom();
    void LoadData();
    void error();
    void controlToolbar();
    void Local();
    void errorMessage();
    void control();
}
