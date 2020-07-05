package com.example.musicbox;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Button playButton, previousButton, nextButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = (Button) findViewById(R.id.playButtonId);
        previousButton = (Button) findViewById(R.id.previousButtonId);
        nextButton = (Button) findViewById(R.id.nextButtonId);
        mediaPlayer = new MediaPlayer();


    }
}