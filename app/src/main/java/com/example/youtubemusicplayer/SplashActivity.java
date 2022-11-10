package com.example.youtubemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    Animation slideupanimation;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=findViewById(R.id.imageView4);
        slideupanimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_animation);
        Thread thread=new Thread() {
           public void run() {
               try {
                   imageView.startAnimation(slideupanimation);
                   sleep(1500);
               }
               catch (Exception e){
                   e.printStackTrace();
               }
               finally {
                   Intent b=new Intent(SplashActivity.this,MainActivity.class);
                   startActivity(b);
                   finish();
               }
            }
        };thread.start();
    }
}