package com.example.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button saveButton;
    private EditText editText;
    private SharedPreferences myPrefs;
    public static final String PREFS_NAME = "myPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textViewId);
        saveButton = (Button) findViewById(R.id.saveButtonId);
        editText = (EditText) findViewById(R.id.editTextId);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString("message", editText.getText().toString());
                editor.commit();

            }
        });

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        if(prefs.contains("message")) {
            String message = prefs.getString("message", "not found");
            textView.setText("Message: " + message);
        }

    }
}