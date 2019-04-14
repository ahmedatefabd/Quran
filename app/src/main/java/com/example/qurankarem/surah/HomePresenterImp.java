package com.example.qurankarem.surah;
import Api.ApiInterface;
import Api.ServicesConnection;
import model.Data;
import model.ResponseSurah;
import model.Surah;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenterImp implements HomePresenter, ApiInterface {

    HomeView homeView;

    @Override
    public Call<ResponseSurah> getResponseSurah() {
        Call<ResponseSurah> QueryCall = ServicesConnection.GetService().getResponseSurah();
        QueryCall.enqueue(new Callback<ResponseSurah>() {
            @Override
            public void onResponse(Call<ResponseSurah> call, Response<ResponseSurah> response) {
                List<Surah> surahs = response.body().getSurahList();
                if (response.isSuccessful()) {
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

    @Override
    public Call<Data> getResponseAyah(Integer number, String language) {
        return null;
    }

    @Override
    public void setView(HomeView homeView) {

        this.homeView = homeView;
    }

    @Override
    public void getAllSurah() {
        getResponseSurah();
    }
}
