package com.example.qurankarem.splash;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qurankarem.CategoryActivity;
import com.example.qurankarem.R;
import com.example.qurankarem.surah.HomeActivity;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    ImageView splash;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        splash = findViewById(R.id.spalsh);
        TextView textView = findViewById(R.id.spname);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Local();
        StartAnimations();
    }

    private void Local() {
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

    private void StartAnimations() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_animate);
        splash.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            Intent i;
                            i = new Intent(SplashActivity.this, CategoryActivity.class);
                            startActivity(i);
                            finish();
                        } catch (Exception e) {
                        }
                    }
                }, 2000);

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
