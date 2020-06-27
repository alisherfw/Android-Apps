package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button darkModeButton;
    private boolean darkMode = false;
    private TextView loremText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        darkModeButton = (Button) findViewById(R.id.darkModeButtonId);
        loremText = (TextView) findViewById(R.id.loreamTextId);

        darkModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(darkMode == false) {
                    darkModeButton.setText("Turn off Dark Mode");
                    loremText.setTextColor(Color.WHITE);
                    loremText.setBackgroundColor(Color.BLACK);
                    darkMode = true;
                } else {
                    darkModeButton.setText("Turn on Dark Mode");
                    loremText.setTextColor(Color.BLACK);
                    loremText.setBackgroundColor(Color.WHITE);
                    darkMode = false;
                }
            }
        });

    }
}