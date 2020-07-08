package com.example.internetisconnected;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button checkButton;
    private TextView statusText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();


    }
    public void setupUI() {
        checkButton = (Button) findViewById(R.id.checkButtonId);
        statusText = (TextView) findViewById(R.id.statusTextId);
        imageView = (ImageView) findViewById(R.id.imageViewId);
    }

    public boolean isInternetConnected() {
        return false;
    }

}