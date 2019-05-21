package com.example.qurankarem.surah;
import AdaptersOfflin.SuraAdapterOfflin;
import ModelDB.SuraDB;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.qurankarem.CategoryActivity;
import com.example.qurankarem.DataBase.RoomDB.RoomBD_Abstract.RoomDataBase;
import com.example.qurankarem.R;

import adapter.Surah_Aya_Adapter;
import model.Surah_Aya;
import util.NetworkChangeReceiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import static android.os.Build.VERSION_CODES.M;

public class HomeActivity extends AppCompatActivity implements HomeView {

    public static Toolbar toolbar;
    public static ShimmerRecyclerView shimmerRecyclerView;
    private HomePresenter homePresenter;
    private Surah_Aya_Adapter adapter;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    public static RoomDataBase roomDataBase;
    public static List<SuraDB> surahDBList;
    private SuraAdapterOfflin adapterOfflin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);

        control();
        Local();
        controlToolbar();

        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));
        }
        homePresenter = new HomePresenterImp();
        homePresenter.setView(this);
        ShimmerRecycler();
        roomDataBase = Room.databaseBuilder(getApplicationContext(), RoomDataBase.class, "postsdb").allowMainThreadQueries().build();
        surahDBList = new ArrayList<>();
        if(NetworkChangeReceiver.isNetworkAvailable(this)) {
            LoadData();
        }else {
            errorMessage();
            LoadDataOfflineRoom();
        }
    }


    @Override
    public void setSurahList(List<Surah_Aya> surahAyaList) {
        adapter = new Surah_Aya_Adapter(this, surahAyaList);
        if (surahAyaList.size() > 0) {
            shimmerRecyclerView.setAdapter(adapter);
        } else {
            error();
        }
    }

    @Override
    public void recyclerOfflineRoom(List<SuraDB> surahDBList) {
        adapterOfflin = new SuraAdapterOfflin(this,  surahDBList);
        if (surahDBList.size() > 0) {
            shimmerRecyclerView.setAdapter(adapterOfflin);
        } else {
            error();
        }
    }

    @Override
    public void LoadDataOfflineRoom() {
        surahDBList = roomDataBase.oper().getAllSuras();
        recyclerOfflineRoom(surahDBList);
    }

    @Override
    public void LoadData() {
        homePresenter.getAllSurah();
    }

    @Override
    public void error() {
        try {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("عفواًً")
                    .setContentText("لا توجد أى سور")
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, "لا توجد أى سور ..", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void controlToolbar() {
        toolbar = findViewById(R.id.surah_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void Local() {
        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        String en = Locale.getDefault().getDisplayLanguage();
        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale);
        }
    }

    @Override
    public void ShimmerRecycler() {
        shimmerRecyclerView = findViewById(R.id.recycler);
        shimmerRecyclerView.showShimmerAdapter();
        shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        shimmerRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void errorMessage() {
        try {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("عفواًً")
                    .setContentText("لا يــوجد أى اتصال بالانترنت")
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, "لا يــوجد أى اتصال بالانترنت ..", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void control() {
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HomeActivity.this, CategoryActivity.class));
        Animatoo.animateSlideRight(HomeActivity.this);
    }
}
