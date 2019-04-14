package com.example.qurankarem.ayah;
import Api.ApiInterface;
import Api.ServicesConnection;
import model.Ayah;
import model.Data;
import model.ResponseSurah;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AyahPresenterImp implements AyahPresenter, ApiInterface {

    AyahView ayahView;

    @Override
    public void setView(AyahView ayahView) {
        this.ayahView = ayahView;
    }

    @Override
    public void getAllAyah(String lang) {

        int Num = AyahActivity.sharedPreferences.getInt("Number",0);
        getResponseAyah(Num,lang);
    }

    @Override
    public Call<Data> getResponseAyah(Integer number, String language) {
        Call<Data> QueryCall = ServicesConnection.GetService().getResponseAyah(number, language);
        QueryCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                List<Ayah> ayahs = response.body().getAyah().getAyahs();
                if (response.isSuccessful()) {
                    AyahActivity.sShimmerRecyclerView.hideShimmerAdapter();
                    ayahView.setAyahList(ayahs);
                }
            }
            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                System.out.print(toString());
            }
        });
        return null;
    }

    @Override
    public Call<ResponseSurah> getResponseSurah() {
        return null;
    }


}
