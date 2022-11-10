package com.example.youtubemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.VideoView;


public class MainActivity2 extends AppCompatActivity {
ImageView imageView;
VideoView videoView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        imageView=findViewById(R.id.imageView3);
        videoView = findViewById(R.id.videoView2);
        imageView.setOnClickListener(view -> {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        });
        Uri uri=Uri.parse("/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4");
        videoView.setVideoURI(uri);
        videoView.start();
    }

}
