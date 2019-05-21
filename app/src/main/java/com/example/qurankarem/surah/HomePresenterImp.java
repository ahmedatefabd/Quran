package com.example.qurankarem.surah;
import Api.ApiInterface;
import Api.ServicesConnection;
import ModelDB.SuraDB;
import model.Data;
import model.Readers;
import model.ResponseSurah;
import model.Surah_Aya;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.Constant;

import static com.example.qurankarem.surah.HomeActivity.roomDataBase;

public class HomePresenterImp implements HomePresenter, ApiInterface {

    HomeView homeView;

    @Override
    public void getAllSurah() {
        getResponseSurah();
    }

    @Override
    public Call<ResponseSurah> getResponseSurah() {
        Call<ResponseSurah> QueryCall = ServicesConnection.GetService(Constant.Api.BASE_URL).getResponseSurah();

//        ApiInterface apiClient = ApiClient.getInstance().getClient().create(ApiInterface.class);

//        Call<ResponseSurah> QueryCall = apiClient.getResponseSurah();

        QueryCall.enqueue(new Callback<ResponseSurah>() {
            @Override
            public void onResponse(Call<ResponseSurah> call, Response<ResponseSurah> response) {
                List<Surah_Aya> surahAyas = response.body().getSurahAyaList();
                if (response.isSuccessful()) {
                    roomDataBase.oper().deleteSuras();
                    for (int i = 0; i < surahAyas.size(); i++) {
                        //SingleTon
                        SuraDB suraDB =
                                SuraDB.getInstance(surahAyas.get(i).getNumber()
                                        , surahAyas.get(i).getName()
                                        , surahAyas.get(i).getEnglishName()
                                        , surahAyas.get(i).getEnglishNameTranslation()
                                        , surahAyas.get(i).getNumberOfAyahs()
                                        , surahAyas.get(i).getRevelationType());

                        suraDB.setNumber(surahAyas.get(i).getNumber());
                        suraDB.setName(surahAyas.get(i).getName());
                        suraDB.setEnglishName(surahAyas.get(i).getEnglishName());
                        suraDB.setEnglishNameTranslation(surahAyas.get(i).getEnglishNameTranslation());
                        suraDB.setNumberOfAyahs(surahAyas.get(i).getNumberOfAyahs());
                        suraDB.setRevelationType(surahAyas.get(i).getRevelationType());

                        roomDataBase.oper().addSuras(suraDB);
                    }
                   HomeActivity.shimmerRecyclerView.hideShimmerAdapter();
                   homeView.setSurahList(surahAyas);
                }
            }
            @Override
            public void onFailure(Call<ResponseSurah> call, Throwable t) {
                System.out.print(toString());
            }
        });
        return null;
    }



//    @Override
//    public Call<ResponseSurah> getResponseSurah() {
//        Call<ResponseSurah> QueryCall = ServicesConnection.GetService(Constant.Api.BASE_URL).getResponseSurah();
//        QueryCall.enqueue(new Callback<ResponseSurah>() {
//            @Override
//            public void onResponse(Call<ResponseSurah> call, Response<ResponseSurah> response) {
//                try {
//                    List<Surah_Aya> surahs = response.body().getSurahAyaList();
//                    if (response.isSuccessful()) {
//                        HomeActivity.shimmerRecyclerView.hideShimmerAdapter();
//                        homeView.setSurahAyaList(surahs);
//                    }
//
//                }catch (Exception e){
//                    System.out.print(e);
//                }
//
//            }
//            @Override
//            public void onFailure(Call<ResponseSurah> call, Throwable t) {
//                System.out.print(toString());
//            }
//        });
//        return null;
//    }

    @Override
    public Call<Data> getResponseAyah(Integer number, String language) {
        return null;
    }

    @Override
    public Call<List<Readers>> getAllReaders(int body) {
        return null;
    }

    @Override
    public void setView(HomeView homeView) {

        this.homeView = homeView;
    }

}
