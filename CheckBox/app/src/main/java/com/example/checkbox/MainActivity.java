package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private CheckBox Liverpool;
    private CheckBox RealMadrid;
    private CheckBox ManCity;

    private Button Show;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Liverpool = (CheckBox) findViewById(R.id.liverpoolID);
        RealMadrid = (CheckBox) findViewById(R.id.realmadridID);
        ManCity = (CheckBox) findViewById(R.id.mancityID);

        Show = (Button) findViewById(R.id.showID);
        result = (TextView) findViewById(R.id.resultID);

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Liverpool.getText().toString() + " status is: " + Liverpool.isChecked()
                + "\n");
                stringBuilder.append(RealMadrid.getText().toString() + " status is: " + RealMadrid.isChecked()
                + "\n");
                stringBuilder.append(ManCity.getText().toString() + " status is: " + ManCity.isChecked()
                + "\n");

                result.setText(stringBuilder);

            }
        });

    }
}
