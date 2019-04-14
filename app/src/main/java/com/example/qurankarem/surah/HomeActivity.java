package com.example.qurankarem.surah;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.qurankarem.R;
import adapter.SurahAdapter;
import model.Surah;
import Api.modelDB.SurahDB;
import util.NetworkChangeReceiver;
import util.Utils;
import java.util.List;
import java.util.Locale;
import static android.os.Build.VERSION_CODES.M;

public class HomeActivity extends AppCompatActivity implements HomeView {

    public static Toolbar toolbar;
    public static ShimmerRecyclerView shimmerRecyclerView;
    private HomePresenter homePresenter;
    private SurahAdapter adapter;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);

        control();
        Local();
        controlToolbar();

        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.booking));
        }
        homePresenter = new HomePresenterImp();
        homePresenter.setView(this);
        ShimmerRecycler();
        if(NetworkChangeReceiver.isNetworkAvailable(this)) {
            LoadData();
        }else {
            errorMessage();
            LoadDataOfflineRoom();
        }
    }


    @Override
    public void setSurahList(List<Surah> surahList) {
        adapter = new SurahAdapter(this,  surahList);
        if (surahList.size() > 0) {
            shimmerRecyclerView.setAdapter(adapter);
        } else {
            error();
        }
    }

    @Override
    public void recyclerOfflineRoom(List<SurahDB> surahDBList) {

    }

    @Override
    public void LoadDataOfflineRoom() {

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
                    .setContentText("لا توجد أى حجوزات سابقة")
                    .setConfirmText("تم")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, "لا توجد أى حجوزات سابقة ..", Toast.LENGTH_SHORT).show();
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
        if(back_pressed + TIME_DELAY > System.currentTimeMillis()){
            Intent exit = new Intent(Intent.ACTION_MAIN);
            exit.addCategory(Intent.CATEGORY_HOME);
            exit.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(exit);
            finish();
            System.exit(0);
        }else {
            Utils.makeToast(getApplicationContext(), "للخروج من التطبيق اضغط مرة أخرى ", 3000);
        }
        back_pressed = System.currentTimeMillis();
    }
}
