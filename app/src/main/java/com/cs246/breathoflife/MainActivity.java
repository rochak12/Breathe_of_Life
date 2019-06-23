package com.cs246.breathoflife;

import android.content.Intent;
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

    private Button BtnMove;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a button to go to Exercise Screen
        BtnMove = findViewById(R.id.exercize_button);
        BtnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToExercise();
            }
        });



        // This is part of strength challenge
//      //  Proximity proximity = new Proximity(this);
//        Thread thread1 = new Thread(proximity);
//        thread1.start();


        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        // Button for vibrate
        vibrate = (Button) findViewById(R.id.vibrate);
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



        // create timer
        mTextField =(TextView) findViewById(R.id.timerTextView);
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                mTextField.setText(new String("seconds remaining: " + millisUntilFinished / 1000));
            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();


    }



    // Exercise Button
    public void moveToExercise(){
        System.out.println("Ready to go to Workout/Exercise Mode");
        Intent intent = new Intent(MainActivity.this, Exercise.class);
        startActivity(intent);
    }

    //Relax/Meditation
    public void launch_Relax(View view){
        System.out.println("Ready to go to Relax/Meditation Mode");
    }

    //Goes to Custom Activity
    public void launch_Custom(View view){
        System.out.println("Ready to go to Custom Mode");
    }

    //Goes to Setting Activity
    public void launch_Setting(View view){
        System.out.println("Ready to go to Setting");
    }

    //Goes to Info Activity
    public void launch_Info(View view){
        System.out.println("Ready to go to Info");
    }
}
