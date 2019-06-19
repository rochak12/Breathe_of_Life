package com.cs246.breathoflife;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Exercise extends AppCompatActivity {

    private Button HomeBtn;
    Button startTimerInExercise;
    TextView textView2;
//    private ArrayList<Double> relax = new ArrayList<Double>(
//            Arrays.<Float>asList(3.0, 3.0)
//    );
//    private List<>
    private List<Integer> relax;
    Vibrator vi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        startTimerInExercise = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
        relax = Arrays.asList(3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
        }

        public void goHome(View view) {

            finish();
        }


        public  void startTimerInExercise(View view) {

            vi = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            for (int i = 0; i < relax.size(); i++) {
                int b = relax.get(i) * 1000;
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        vi.vibrate(50);
                        Toast.makeText(Exercise.this, "Vibrate", Toast.LENGTH_SHORT).show();
                    }
                }, b*i);
//                int c = 1;
//                vi = (Vibrator) getSystemService(VIBRATOR_SERVICE);
//
//                new CountDownTimer(b, 1000) {
//                    int c = 1;
//
//                    public void onTick(long millisUntilFinished) {
//                        if (c == 1)
//                        {
//                            vi.vibrate(50);
//                            c--;
//                        }
//                        textView2.setText(new String("seconds remaining: " + millisUntilFinished / 1000));
//
//                    }
//
//                    public void onFinish() {
//                        textView2.setText("breathe");
//                    }
//                }.start();
                System.out.println(i);
            }
        }

    }


