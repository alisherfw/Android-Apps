package com.example.internetisconnected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
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

        if(isInternetConnected()) {
            imageView.setBackgroundResource(R.drawable.internet_24);
            statusText.setText("Connected!");
        } else {
            imageView.setBackgroundResource(R.drawable.nointernet_24);
            statusText.setText("Not Connected!");
        }

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                statusText.setText("Please wait!");

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

    private boolean isInternetConnected() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(
                Context.CONNECTIVITY_SERVICE
        );
        return cm.getActiveNetworkInfo() != null;

    }

}