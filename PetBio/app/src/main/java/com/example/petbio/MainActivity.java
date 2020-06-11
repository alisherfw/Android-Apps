package com.example.petbio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView catView;
    private ImageView dogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catView = (ImageView) findViewById(R.id.catButtonId);
        dogView = (ImageView) findViewById(R.id.dogButtonId);

        catView.setOnClickListener(this);
        dogView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.catButtonId:
                Toast.makeText(MainActivity.this, "This is a cat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dogButtonId:
                Toast.makeText(MainActivity.this, "This is a dog", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
