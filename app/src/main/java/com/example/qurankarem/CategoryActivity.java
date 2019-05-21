package com.example.qurankarem;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.qurankarem.quranFull.QuranFullActivity;
import com.example.qurankarem.readers.ReaderActivity;
import com.example.qurankarem.readers.ReadersssActivity;
import com.example.qurankarem.surah.HomeActivity;

public class CategoryActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private LinearLayout reader;
    private LinearLayout quranFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        linearLayout = findViewById(R.id.homeAct);
        reader = findViewById(R.id.reader);
        quranFull = findViewById(R.id.quranFull);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, HomeActivity.class));
                Animatoo.animateSlideLeft(CategoryActivity.this);
            }
        });

        reader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, ReadersssActivity.class));
                Animatoo.animateSlideRight(CategoryActivity.this);
            }
        });

        quranFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, QuranFullActivity.class));
                Animatoo.animateSlideRight(CategoryActivity.this);
            }
        });
    }
}