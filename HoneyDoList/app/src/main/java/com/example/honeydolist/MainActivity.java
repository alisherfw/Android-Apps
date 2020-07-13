package com.example.honeydolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) findViewById(R.id.saveButtonId);
        editText = (EditText) findViewById(R.id.editTextId);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    String message = editText.getText().toString();
                    writeToFile(message);
                } else {

                }

            }
        });

        try {
            if(readFromFile() != null) {
                editText.setText(readFromFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeToFile(String message) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    openFileOutput("todolist.txt", Context.MODE_PRIVATE)
            );
            outputStreamWriter.write(message);
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String readFromFile() throws IOException {
        String result = "";

        InputStream inputStream = openFileInput("todolist.txt");
        if(inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String tempString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (tempString = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempString);
            }
            inputStream.close();
            result = stringBuilder.toString();
        }
        return result;
    }

}