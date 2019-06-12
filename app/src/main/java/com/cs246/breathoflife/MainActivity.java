package com.cs246.breathoflife;

import android.os.CountDownTimer;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button vibrate;
    Vibrator v;
    Proximity proximity;
    Meditation meditation = new Meditation();
    TextView mTextField;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextField =(TextView) findViewById(R.id.timerTextView);


        vibrate = (Button) findViewById(R.id.vibrate);
        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        Proximity proximity = new Proximity(this);
        Thread thread1 = new Thread(proximity);
        thread1.start();


        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> meditationData = meditation.getArrayList();
                for (int i = meditationData.get(0); i <= meditationData.get(2); i++)
                    if (i == meditationData.get(1))
                        v.vibrate(50);
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
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                mTextField.setText(new String("seconds remaining: " + millisUntilFinished / 1000));
            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();


                // scott pierce
                // nathan rowley
                // Grayson Jones


                // i am the best
    }
}
