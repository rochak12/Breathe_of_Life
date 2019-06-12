package com.cs246.breathoflife;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button vibrate;
    Vibrator v;
    Proximity proximity;
    Meditation meditation = new Meditation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
            }
        });



    // scott pierce
        // nathan rowley
    // Grayson Jones


        // i am the best
    }
}
