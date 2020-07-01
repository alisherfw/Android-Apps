package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.theme_music);

        playButton = (Button) findViewById(R.id.playButtonId);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    pauseMusic();
                } else {
                    startMusic();
                }
            }
        });
    }
    public void pauseMusic() {
        if(mediaPlayer != null) {
            mediaPlayer.pause();
            playButton.setText("Play");
        }
    }
    public void startMusic() {
        mediaPlayer.start();
        playButton.setText("Pause");
    }
}