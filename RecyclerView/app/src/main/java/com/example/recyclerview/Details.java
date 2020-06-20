package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.Random;


public class Details extends AppCompatActivity {

    private TextView name, description, rating;
    private Bundle extras;
    private View windowView;
    private int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        extras = getIntent().getExtras();

        name = (TextView) findViewById(R.id.dNameId);
        description = (TextView) findViewById(R.id.dDescriptionId);
        rating = (TextView) findViewById(R.id.dRatingId);
        windowView = (View) findViewById(R.id.windowViewID);

        colors = new int[] {
                Color.RED, Color.GRAY, Color.YELLOW, Color.GREEN, Color.BLACK, Color.BLUE,
                Color.DKGRAY, Color.WHITE, Color.MAGENTA, Color.LTGRAY, Color.CYAN
        };


        if(extras != null) {
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
            rating.setText(extras.getString("rating"));
            Random random = new Random();
            int randomNum = random.nextInt(colors.length);
            windowView.setBackgroundColor(colors[randomNum]);
        }
    }
}