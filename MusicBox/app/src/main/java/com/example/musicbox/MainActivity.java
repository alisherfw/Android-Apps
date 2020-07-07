package com.example.musicbox;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playButton, previousButton, nextButton;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private TextView leftTime, rightTime;
    private ImageView artistImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();


    }
    public void setupUI() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);

        artistImage = (ImageView) findViewById(R.id.ovalimageId);
        leftTime = (TextView) findViewById(R.id.leftTimeId);
        rightTime = (TextView) findViewById(R.id.rightTimeId);
        seekBar = (SeekBar) findViewById(R.id.seekBarId);
        previousButton = (Button) findViewById(R.id.previousButtonId);
        nextButton = (Button) findViewById(R.id.nextButtonId);
        playButton = (Button) findViewById(R.id.playButtonId);

        previousButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.previousButtonId:

                break;
            case R.id.nextButtonId:

                break;
            case R.id.playButtonId:
                if(mediaPlayer.isPlaying()) {
                    pauseMusic();
                } else {
                    playMusic();
                }
                break;
        }
    }
    public void pauseMusic() {
        if(mediaPlayer != null) {
            mediaPlayer.pause();
            playButton.setBackgroundResource(R.drawable.pause_button_24);
        }
    }
    public void playMusic() {
        if(mediaPlayer != null) {
            mediaPlayer.start();
            playButton.setBackgroundResource(R.drawable.play_button_24);
        }
    }
}
