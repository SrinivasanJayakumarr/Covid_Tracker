package com.example.covid_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo,imgTop1,imgTop2,imgBottom1,imgBottom2;
    private TextView slogan;
    private Animation topAnim,bottomAnim,rotateAnim,rotateBottomAnim;

    private static final int DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Window window = SplashActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(SplashActivity.this, R.color.green_color));

        logo = findViewById(R.id.logo);
        slogan = findViewById(R.id.slogan);
        imgTop1 = findViewById(R.id.img_top1);
        imgTop2 = findViewById(R.id.img_top2);
        imgBottom1 = findViewById(R.id.img_btm1);
        imgBottom2 = findViewById(R.id.img_btm2);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
        rotateAnim.setInterpolator(new LinearInterpolator());
        rotateBottomAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_bottom_animation);
        rotateBottomAnim.setInterpolator(new LinearInterpolator());

        logo.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);
        imgTop1.setAnimation(rotateAnim);
        imgTop2.setAnimation(rotateAnim);
        imgBottom1.setAnimation(rotateBottomAnim);
        imgBottom2.setAnimation(rotateBottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },DELAY);

    }
}