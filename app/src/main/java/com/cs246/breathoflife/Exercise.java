package com.cs246.breathoflife;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exercise extends AppCompatActivity {

    private Button HomeBtn;
    Button startTimerInExercise;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        startTimerInExercise = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);

        }

        public void goHome(View view) {

            finish();
        }


        public  void startTimerInExercise(View view){
            new CountDownTimer(30000, 1000) {
                public void onTick(long millisUntilFinished) {
                    textView2.setText(new String("seconds remaining: " + millisUntilFinished / 1000));
                }

                public void onFinish() {
                    textView2.setText("done!");
                }
            }.start();
        }


    };


