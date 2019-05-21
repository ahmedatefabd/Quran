package com.example.qurankarem.readers;
import adapter.ReaderAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.pedant.SweetAlert.SweetAlertDialog;
import model.Readers;
import util.NetworkChangeReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.qurankarem.CategoryActivity;
import com.example.qurankarem.R;
import java.util.List;
import java.util.Locale;

public class ReaderActivity extends AppCompatActivity implements ReadersView{

    public static Toolbar toolbar;
    public static ShimmerRecyclerView shimmerRecyclerView;
    private ReaderAdapter adapter;
    private ReadersPresenter readersPresenter;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    public static int body ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reader);
        readersPresenter = new ReadersPresenterImp();
        readersPresenter.setView(this);
        control();
        Local();
        controlToolbar();
        ShimmerRecycler();

        if(NetworkChangeReceiver.isNetworkAvailable(this)) {
            LoadData();
        }else {
            errorMessage();
            LoadDataOfflineRoom();
        }
    }

    @Override
    public void setReaderList(List<Readers> readerList) {
        adapter = new ReaderAdapter(this, readerList);
        if (readerList.size() > 0) {
            shimmerRecyclerView.setAdapter(adapter);
        } else {
            error();
        }
    }

    @Override
    public void LoadDataOfflineRoom() {

    }

    @Override
    public void LoadData() {
        readersPresenter.getAllReader(body);
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
        toolbar = findViewById(R.id.reader_Toolbar);
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

    public void ShimmerRecycler() {
        shimmerRecyclerView = findViewById(R.id.recyclerReader);
        shimmerRecyclerView.showShimmerAdapter();
        shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        shimmerRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void errorMessage() {
    }

    @Override
    public void control() {
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ReaderActivity.this, CategoryActivity.class));
        Animatoo.animateSlideLeft(ReaderActivity.this);
    }
}