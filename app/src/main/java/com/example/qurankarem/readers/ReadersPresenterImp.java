package com.example.qurankarem.readers;

import java.util.List;

import Api.ApiInterface;
import Api.ServicesConnection;
import Api.ServicesConnectionReader;
import model.Data;
import model.Readers;
import model.ResponseSurah;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.Constant;

public class ReadersPresenterImp implements ReadersPresenter, ApiInterface {

    ReadersView readersView ;

    @Override
    public Call<ResponseSurah> getResponseSurah() {
        return null;
    }

    @Override
    public Call<Data> getResponseAyah(Integer number, String language) {
        return null;
    }


    @Override
    public void getAllReader(Integer body) {
        getAllReaders(body);
    }

    @Override
    public Call<List<Readers>> getAllReaders(int body) {

        Call<List<Readers>> QueryCall = ServicesConnectionReader.GetService().getAllReaders(body);
        QueryCall.enqueue(new Callback<List<Readers>>() {
            @Override
            public void onResponse(Call<List<Readers>> call, Response<List<Readers>> response) {
                List<Readers> readers = response.body();
                if (response.isSuccessful()) {
                    ReaderActivity.shimmerRecyclerView.hideShimmerAdapter();
                    readersView.setReaderList(readers);
                }
            }
            @Override
            public void onFailure(Call<List<Readers>> call, Throwable t) {
                System.out.print(toString());
            }
        });

        return null;
    }

    @Override
    public void setView(ReadersView readersView) {

        this.readersView = readersView ;
    }
}
