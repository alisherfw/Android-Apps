package com.example.trymeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View WindowView;
    private Button TryMeButton;
    private int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = new int[] {Color.RED, Color.GRAY, Color.YELLOW, Color.GREEN, Color.BLACK, Color.BLUE,
        Color.DKGRAY, Color.WHITE, Color.MAGENTA, Color.LTGRAY, Color.CYAN};

        WindowView = (View) findViewById(R.id.WindowViewId);

        TryMeButton = (Button) findViewById(R.id.TryMeButtonId);
        TryMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNum = random.nextInt(colors.length);

                WindowView.setBackgroundColor(colors[randomNum]);
            }
        });

    }
}
