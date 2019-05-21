package com.example.qurankarem.quranFull;

import adapter.SurahAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import model.Surah;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.qurankarem.Helper.FileOpener;
import com.example.qurankarem.R;
import com.example.qurankarem.details.DetailsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class QuranFullActivity extends AppCompatActivity {

    List<Surah> list = new ArrayList<>();
    Surah model;
    public static Toolbar toolbar;

    //UI Elements
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_full);

        init();
        parseData();
        controlToolbar();
    }

    public void controlToolbar() {
        toolbar = findViewById(R.id.surah_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    private void init() {

        listView = findViewById(R.id.deviceList);
        View header = getLayoutInflater().inflate(R.layout.surah_header_view,null);
        listView.addHeaderView(header);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(QuranFullActivity.this, DetailsActivity.class);
                intent.putExtra("SURAH_NUMBER",position);
                startActivity(intent);
            }
        });
    }

    private void parseData() {

        try
        {
            FileOpener opener = new FileOpener();
            String json = opener.loadJsonFromAssest("json_surah_list.json",QuranFullActivity.this);
            JSONObject jsonobject = new JSONObject(json);
            JSONArray jarray = (JSONArray) jsonobject.getJSONArray("data");
            for(int i=0;i<jarray.length();i++)
            {
                JSONObject jb =(JSONObject) jarray.get(i);
                String name = jb.getString("title");
                model = new Surah();
                model.setSurah_name(name);
                list.add(model);
                Log.e("Surah_Title",name);
            }
            listView.setAdapter(new SurahAdapter(list,QuranFullActivity.this));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
