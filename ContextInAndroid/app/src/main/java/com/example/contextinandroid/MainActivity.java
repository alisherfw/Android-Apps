package com.example.contextinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.buybuttonID);
        editText = (EditText) findViewById(R.id.editTextID);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int money = Integer.parseInt(editText.getText().toString());
                if(money >= 1000) {
                    Toast.makeText(MainActivity.this,  "No internet connection", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.not_enough_money_message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
