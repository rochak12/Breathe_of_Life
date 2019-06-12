package com.cs246.breathoflife;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button vibrate;

    Vibrator v;
    @TargetApi(Build.VERSION_CODES.M)
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
                Toast.makeText(MainActivity.this, "Vibrate", Toast.LENGTH_SHORT).show();
            }
        });

        // Main Button Build
        Button customButton = findViewById(R.id.exercize_button);
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });


                // scott pierce
                // nathan rowley
                // Grayson Jones


                // i am the best
    }
}
