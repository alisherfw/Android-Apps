package com.example.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private View view;
    private ToggleButton toggleButton;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (View) findViewById(R.id.ViewID);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButtonID);
        textView = (TextView) findViewById(R.id.textViewID);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    view.setBackgroundColor(Color.WHITE);
                    textView.setTextColor(Color.BLACK);
                    textView.setText("DARK MODE IS OFF");
                } else {
                    view.setBackgroundColor(Color.BLACK);
                    textView.setTextColor(Color.WHITE);
                    textView.setText("DARK MODE IS ON");
                }
            }
        });


    }
}
