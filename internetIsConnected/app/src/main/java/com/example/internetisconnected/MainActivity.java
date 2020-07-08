package com.example.internetisconnected;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isInternetConnected()) {
                    imageView.setBackgroundResource(R.drawable.internet_24);
                    statusText.setText("Connected!");
                } else {
                    imageView.setBackgroundResource(R.drawable.nointernet_24);
                    statusText.setText("Not Connected!");
                }
            }
        });

    }
    public void setupUI() {
        checkButton = (Button) findViewById(R.id.checkButtonId);
        statusText = (TextView) findViewById(R.id.statusTextId);
        imageView = (ImageView) findViewById(R.id.imageViewId);
    }

    public boolean isInternetConnected() {
        try {
            String command = "ping -c 1 google.com";
            return (Runtime.getRuntime().exec(command).waitFor() == 0);
        } catch (Exception e) {
            return false;
        }
    }

}