package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        result = (TextView) findViewById(R.id.resultID);

        result.setText("Your TOPIK level: " + seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                result.setText("Your TOPIK level: " + seekBar.getProgress() + "/" + seekBar.getMax());
                if(seekBar.getProgress() >= 5) {
                    result.setTextColor(Color.RED);
                }
                if(seekBar.getProgress() > 2 && seekBar.getProgress() < 5) {
                    result.setTextColor(Color.YELLOW);
                }
                if(seekBar.getProgress() >= 1 && seekBar.getProgress() < 3) {
                    result.setTextColor(Color.GREEN);
                }
                if(seekBar.getProgress() == 0) {
                    result.setText(":(");
                    result.setTextColor(Color.DKGRAY);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
