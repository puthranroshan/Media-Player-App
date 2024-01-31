package com.example.m2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer media;
    Button play,pause,fwd,bwd,restart;

    int starttime=0;
    int bctime=5000;
    int fwtime =5000;



    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        media=MediaPlayer.create(this,R.raw.cham);
        play=findViewById(R.id.btnpl);
        pause=findViewById(R.id.btpu);
        fwd=findViewById(R.id.btnbw);
        bwd=findViewById(R.id.btnfw);
        restart=findViewById(R.id.btnrs);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media.pause();
            }
        });

        fwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curr=media.getCurrentPosition();

                media.seekTo(curr+fwtime);

            }
        });

        bwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curr =media.getCurrentPosition();
                media.seekTo(curr-bctime);
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                media.seekTo(starttime);
                media.start();
            }
        });




    }
}