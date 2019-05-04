package com.example.qurankarem.ayah;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.qurankarem.R;
import com.example.qurankarem.surah.HomeActivity;
import adapter.AyahAdapter;
import model.Ayah;
import model.Surah;
import Api.modelDB.AyahDB;
import util.NetworkChangeReceiver;
import java.util.List;
import static android.os.Build.VERSION_CODES.M;

public class AyahActivity extends AppCompatActivity implements AyahView{

    public static SharedPreferences sharedPreferences ;
    public static SharedPreferences.Editor editor;
    public static final String PREF_NAME = "prefs";
    public static final String ARABIC = "ar.asad";
    public static final String ENGLISH = "en.asad";
    public static Toolbar toolbar;
    public static ShimmerRecyclerView sShimmerRecyclerView;
    private AyahPresenter ayahPresenter;
    private AyahAdapter adapter;
    private TextView AyahName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Bundle intent = getIntent().getExtras();
        Surah surah = intent.getParcelable("surah");
        int number = surah.getNumber();

        editor.putInt("Number", number);
        editor.apply();

        control();
        Local();
        controlToolbar(surah);

        if (Build.VERSION.SDK_INT >= M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.booking));
        }
        ayahPresenter = new AyahPresenterImp();
        ayahPresenter.setView(this);
        ShimmerRecycler();
        if(NetworkChangeReceiver.isNetworkAvailable(this)) {
            LoadData();
        }else {
            errorMessage();
            LoadDataOfflineRoom();
        }

    }

    @Override
    public void setAyahList(List<Ayah> ayahList) {

        adapter = new AyahAdapter(this,  ayahList);
        if (ayahList.size() > 0) {
            sShimmerRecyclerView.setAdapter(adapter);
        } else {
            error();
        }
    }

    @Override
    public void recyclerOfflineRoom(List<AyahDB> ayahDBList) {
    }

    @Override
    public void LoadDataOfflineRoom() {
    }

    @Override
    public void LoadData() {
        ayahPresenter.getAllAyah(ARABIC);
    }

    @Override
    public void error() {
    }

    @Override
    public void controlToolbar(Surah surah) {
        toolbar = findViewById(R.id.ayah_Toolbar);
        AyahName = findViewById(R.id.ayahName);
        AyahName.setText(surah.getName());
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void Local() {
    }

    @Override
    public void ShimmerRecycler() {
        sShimmerRecyclerView = findViewById(R.id.recyclerAyah);
        sShimmerRecyclerView.showShimmerAdapter();
        sShimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        sShimmerRecyclerView.setItemAnimator(new DefaultItemAnimator());
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.arabic:
                ayahPresenter.getAllAyah(ARABIC);
                return true;
            case R.id.english:
                ayahPresenter.getAllAyah(ENGLISH);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AyahActivity.this, HomeActivity.class));
        finish();
    }
}