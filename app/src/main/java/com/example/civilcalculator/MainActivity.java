package com.example.civilcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static int Splash_screen=3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView=(VideoView)findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/"+ R.raw.second_more_last);
        videoView.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }
        },Splash_screen);


    }

    }
