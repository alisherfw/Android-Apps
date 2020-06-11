package com.example.milestokilometers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editTextId);
        button = (Button) findViewById(R.id.convertId);
        textView = (TextView) findViewById(R.id.textViewId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double multipler = 1.609;
                double result = 0.0;

                if(editText.getText().toString().equals("")) {
                    textView.setText(R.string.error_message);
                    textView.setTextColor(Color.RED);
                }
                else {
                    double kmValue = Double.parseDouble(editText.getText().toString());
                    result = kmValue * multipler;
                    textView.setTextColor(Color.rgb(244, 92, 0));
                    textView.setText(String.format("%.3f", result));

                }


            }
        });


    }
}
