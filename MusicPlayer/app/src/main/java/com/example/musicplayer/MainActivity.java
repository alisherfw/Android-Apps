package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private TextView durationText;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.theme_music);

        durationText = (TextView) findViewById(R.id.durationTextId);
        seekBar = (SeekBar) findViewById(R.id.seekBarId);

        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                int duration = mp.getDuration();
                String mDuration = String.valueOf(duration / 1000);
                Toast.makeText(MainActivity.this, "duration: "
                        + mDuration, Toast.LENGTH_SHORT).show();
            }
        });

        playButton = (Button) findViewById(R.id.playButtonId);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int duration = mediaPlayer.getDuration();
                int secund = duration / 1000;
                int minute = secund / 60;
                secund = secund  % 60;

                String mDuration = String.valueOf(minute);
                String sDuration = String.valueOf(secund);
                durationText.setText("Duration: " + mDuration + ":" + sDuration);

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

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}