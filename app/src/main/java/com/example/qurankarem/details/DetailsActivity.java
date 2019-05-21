package com.example.qurankarem.details;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import model.Details;
import android.Manifest;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.example.qurankarem.Helper.FileOpener;
import com.example.qurankarem.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    public List<Details> list = new ArrayList<>();
    public List<Integer> durationList = new ArrayList<>();
    Details model;
    public static Toolbar toolbar;
    int surah_number,duration=0;

    public static String PUBLIC_SHARED_PREF = "quran_pref";
    public TextView textQuran;
    public static String verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},19);
        }

        controlToolbar();
    }

    public void controlToolbar() {
        toolbar = findViewById(R.id.surah_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 19:
                parseData();
                break;
        }
    }

    private void init() {
        surah_number = getIntent().getIntExtra("SURAH_NUMBER",1);
        textQuran = findViewById(R.id.textQuran);
    }

    public static final Spannable getColoredString(Context context, CharSequence text, int color) {
        Spannable spannable = new SpannableString(text);
        spannable.setSpan(new ForegroundColorSpan(color), 0, spannable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    private void parseData() {
        try
        {
            FileOpener opener = new FileOpener();
            String json = opener.loadJsonFromAssest("surah_"+surah_number+".json",getApplicationContext());
            String t_json = opener.loadJsonFromAssest("t_surah_"+surah_number+".json",getApplicationContext());
            JSONObject jsonobject = new JSONObject(json);
            JSONArray jarray = jsonobject.getJSONArray("data");
            JSONObject jb =(JSONObject) jarray.get(0);
            String verseAray = jb.getString("sura");
            getColoredString(this, verseAray, Color.RED);
            textQuran.setText(verseAray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
