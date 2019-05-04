package com.example.qurankarem.surah;
import Api.ApiClient;
import Api.ApiInterface;
import Api.ServicesConnection;
import ModelDB.SuraDB;
import model.Data;
import model.Readers;
import model.ResponseSurah;
import model.Surah;
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
                List<Surah> surahs = response.body().getSurahList();
                if (response.isSuccessful()) {
                    roomDataBase.oper().deleteSuras();
                    for (int i = 0; i < surahs.size(); i++) {
                        //SingleTon
                        SuraDB suraDB =
                                SuraDB.getInstance(surahs.get(i).getNumber()
                                        ,surahs.get(i).getName()
                                        ,surahs.get(i).getEnglishName()
                                        ,surahs.get(i).getEnglishNameTranslation()
                                        ,surahs.get(i).getNumberOfAyahs()
                                        ,surahs.get(i).getRevelationType());

                        suraDB.setNumber(surahs.get(i).getNumber());
                        suraDB.setName(surahs.get(i).getName());
                        suraDB.setEnglishName(surahs.get(i).getEnglishName());
                        suraDB.setEnglishNameTranslation(surahs.get(i).getEnglishNameTranslation());
                        suraDB.setNumberOfAyahs(surahs.get(i).getNumberOfAyahs());
                        suraDB.setRevelationType(surahs.get(i).getRevelationType());

                        roomDataBase.oper().addSuras(suraDB);
                    }
                   HomeActivity.shimmerRecyclerView.hideShimmerAdapter();
                   homeView.setSurahList(surahs);
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
//                    List<Surah> surahs = response.body().getSurahList();
//                    if (response.isSuccessful()) {
//                        HomeActivity.shimmerRecyclerView.hideShimmerAdapter();
//                        homeView.setSurahList(surahs);
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
