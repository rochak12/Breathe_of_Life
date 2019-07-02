package com.cs246.breathoflife;

import android.content.Context;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static public String message_Intent = "intent_Message";
    static public String relax_Intent = "i_Want_To_Be_In_Relax_Mode";
    static public String workout_Intent = "i_Want_To_Be_In_Workout";
    static public String custom_Intent = "i_Want_To_Be_In_Custom";
    static public String preset_Intent = "i_Want_To_Be_In_Preset";
    static public String string_Intent = "i_Want_To_Be_In_Setting";




    Button vibrate;
    Vibrator v;
    TextView mTextField;

    private Button BtnMove;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        setContentView(R.layout.activity_main);


//        // This is part of strength challenge
//        Proximity proximity = new Proximity(this, this);
//        Thread thread1 = new Thread(proximity);
//        thread1.start();








//        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
//        // Button for vibrate
//        vibrate = (Button) findViewById(R.id.vibrate);
//        vibrate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                List<Integer> meditationData = meditation.getList();
//                for (int i = meditationData.get(0); i <= meditationData.get(2); i++)
//                    if (i == meditationData.get(1))
//                        v.vibrate(50);
//                v.vibrate(50);
//                Toast.makeText(MainActivity.this, "Vibrate", Toast.LENGTH_SHORT).show();
//            }
//        });


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
    public void launch_Workout(View view){
        System.out.println("Ready to go to Workout Mode");
        Intent intent = new Intent(MainActivity.this, Exercise.class);
        intent.putExtra(message_Intent, workout_Intent);
        startActivity(intent);
    }

    //Relax/Meditation
    public void launch_Meditate(View view){
        System.out.println("Ready to go to Relax/Meditation Mode");
        Intent intent = new Intent(MainActivity.this, Exercise.class);
        intent.putExtra(message_Intent, relax_Intent);
        startActivity(intent);
    }

    //Goes to Custom Activity
    public void launch_Custom(View view){
        System.out.println("Ready to go to Custom Mode");
        Intent intent = new Intent(MainActivity.this, Custom.class);
        intent.putExtra(message_Intent, workout_Intent);
        startActivity(intent);
    }

    //Goes to Setting Activity
    public void launch_Setting(View view){
        System.out.println("Ready to go to Setting");
        Intent intent = new Intent(MainActivity.this, settings.class);
        intent.putExtra(message_Intent, workout_Intent);
        startActivity(intent);
    }

    //Goes to Preset Activity
    public void launch_Preset(View view){
        System.out.println("Ready to go to Preset");
        Intent intent = new Intent(MainActivity.this, Exercise.class);
        intent.putExtra(message_Intent, preset_Intent);
        startActivity(intent);
    }
}
