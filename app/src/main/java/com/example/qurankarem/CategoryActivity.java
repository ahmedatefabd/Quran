package com.example.qurankarem;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.qurankarem.surah.HomeActivity;

public class CategoryActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        linearLayout = findViewById(R.id.homeAct);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, HomeActivity.class));
                Animatoo.animateSlideLeft(CategoryActivity.this);
            }
        });
    }
}