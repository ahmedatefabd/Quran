package com.example.qurankarem.readers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.qurankarem.R;

public class ReadersssActivity extends AppCompatActivity {

   private LinearLayout reader_1, reader_2, reader_3, reader_4,
    reader_5, reader_6, reader_7, reader_8, reader_9, reader_10, reader_11, reader_12,reader_13;

    public static Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readersss);

        reader_1 = findViewById(R.id.reader_1);
        reader_2 = findViewById(R.id.reader_2);
        reader_3 = findViewById(R.id.reader_3);
        reader_4 = findViewById(R.id.reader_4);
        reader_5 = findViewById(R.id.reader_5);
        reader_6 = findViewById(R.id.reader_6);
        reader_7 = findViewById(R.id.reader_7);
        reader_8 = findViewById(R.id.reader_8);
        reader_9 = findViewById(R.id.reader_9);
        reader_10 = findViewById(R.id.reader_10);
        reader_11 = findViewById(R.id.reader_11);
        reader_12 = findViewById(R.id.reader_12);
        reader_13 = findViewById(R.id.reader_13);

        controlToolbar();



        reader_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 1;
            }
        });

        reader_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 2;
            }
        });

        reader_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 3;
            }
        });

        reader_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 4;
            }
        });

        reader_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 5;
            }
        });

        reader_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 6;
            }
        });

        reader_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 7;
            }
        });

        reader_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 8;
            }
        });

        reader_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 9;
            }
        });

        reader_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 10;
            }
        });

        reader_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 11;
            }
        });

        reader_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 12;
            }
        });

        reader_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadersssActivity.this, ReaderActivity.class));
                ReaderActivity.body = 13;
            }
        });
    }

    public void controlToolbar() {
        toolbar = findViewById(R.id.readersssssss_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

}
