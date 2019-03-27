package com.example.qurankarem.activity.main;
import com.example.qurankarem.api.ApiInterface;
import com.example.qurankarem.api.ServicesConnection;
import com.example.qurankarem.model.ResponseSurah;
import com.example.qurankarem.model.Surah;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahPresenterImp implements SurahPresenter, ApiInterface {

    SurahView surahView;

    @Override
    public Call<ResponseSurah> getResponseSurah() {
        Call<ResponseSurah> QueryCall = ServicesConnection.GetService().getResponseSurah();
        QueryCall.enqueue(new Callback<ResponseSurah>() {
            @Override
            public void onResponse(Call<ResponseSurah> call, Response<ResponseSurah> response) {
                List<Surah> surahs = response.body().getSurahList();
                if (response.isSuccessful()) {
                   SurahActivity.shimmerRecyclerView.hideShimmerAdapter();
                   surahView.setSurahList(surahs);
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
    public void setView(SurahView surahView) {

        this.surahView = surahView;
    }

    @Override
    public void getAllSurah() {
        getResponseSurah();
    }
}
