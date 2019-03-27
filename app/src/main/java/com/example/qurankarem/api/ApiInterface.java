package com.example.qurankarem.api;

import com.example.qurankarem.model.ResponseSurah;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("surah")
    Call<ResponseSurah> getResponseSurah();
}
