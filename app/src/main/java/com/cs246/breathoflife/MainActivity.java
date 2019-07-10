package com.cs246.breathoflife;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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

    SensorManager mySensorManager;
    Sensor myProximitySensor;


    Button vibrate;
    Meditation meditation;
    Vibrator v;
    TextView mTextField;

    private Button BtnMove;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        setContentView(R.layout.activity_main);


        mySensorManager = (SensorManager) getSystemService(
                Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);

        final SensorEventListener proximitySensorEventListener
                = new SensorEventListener() {
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // TODO Auto-generated method stub
            }


            @Override
            public void onSensorChanged(SensorEvent event) {

                if (event.values[0] < myProximitySensor.getMaximumRange()) {
                    // getWindow().getDecorView().setBackgroundColor(Color.BLACK);
                    System.out.println("Is this working");
                } else {
                    // getWindow().getDecorView().setBackgroundColor(Color.BLACK);
                    ;
                }
            }
        };
        mySensorManager.registerListener(proximitySensorEventListener, myProximitySensor, SensorManager.SENSOR_DELAY_NORMAL);

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
