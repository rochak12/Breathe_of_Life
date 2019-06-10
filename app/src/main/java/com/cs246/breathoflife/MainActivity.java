package com.cs246.breathoflife;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button vibrate;

    Vibrator v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrate = (Button) findViewById(R.id.vibrate);
        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.vibrate(50);
            }
        });


    // scott pierce
        // nathan rowley
    // Grayson Jones


        // i am the best
    }
}
