package com.cs246.breathoflife;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
//import android.widget.Toast; // used before we got the animations working

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise extends AppCompatActivity {
    ImageView lungs;
    private List<Integer> breathing_Pattern;
    List<Integer> listFromCustom = new ArrayList<>();
    String receive_Intent_Message;

    Meditation meditation = new Meditation();
    Workout workout = new Workout();
    Preset preset = new Preset();
    Custom custom = new Custom();
    Button mainButton;

    Vibrator vi;
//    Toast breathInToast;
//    Toast breathOutToast;
    MediaPlayer mediaPlayer;
    private Object AnimationUtils;
    private int privateVi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
//        breathInToast =  Toast.makeText(Exercise.this, "Breathe in", Toast.LENGTH_SHORT);
//        breathOutToast = Toast.makeText(Exercise.this, "Breathe out", Toast.LENGTH_SHORT);
        vi = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.calm);
        //after initializing the object for toast and vibrator we check for the setting but
        // before that we have to load setting activity if it hasn't been opened yet
        checkSetting();
        mainButton = (Button) findViewById(R.id.btnmain);

        receive_Intent_Message = getIntent().getStringExtra(MainActivity.message_Intent);
        String custom_message = getIntent().getExtras().getString(MainActivity.message_Intent);
        if (custom_message != null) {
            receive_Intent_Message = custom_message;
            listFromCustom = getIntent().getExtras().getIntegerArrayList(Custom.custom_value);
        }
        Log.d("This is my Intent:", receive_Intent_Message);

        breathing_Pattern = get_Pattern();
        Log.d("this is my pattern", ": " + breathing_Pattern);
    }

    @Override
    public void onBackPressed() {
        System.out.println("back button pressed");
//       breathOutToast = null;
//       breathInToast = null;
       vi = null;
       if (mediaPlayer != null) {
           mediaPlayer.stop();
           mediaPlayer.release();
       }
       super.onBackPressed();
    }

    void checkSetting(){
        // Checking the shared Preference of Setting from Exercise;
        SharedPreferences sharedPref = getSharedPreferences(Settings.APP_PREFS, Context.MODE_PRIVATE);
        boolean music = sharedPref.getBoolean(Settings.MUSIC, true);
        boolean vibration = sharedPref.getBoolean(Settings.VIBRATION, true);

        System.out.println("Checking setting from exercise " + "Music: "+ music + " Vibrartion: " + vibration);
        if (!music){
            mediaPlayer = null;
        }
        if (!vibration){
            vi = null;
        }
    }


    List<Integer> get_Pattern() {
        System.out.println(receive_Intent_Message);
        if (receive_Intent_Message.equals(MainActivity.relax_Intent)) {
            Log.d("Condition: ", "Relax condition matched1");
            return meditation.getList(); // make sure the array is always odd to make sure it ends on a breathe out
        }
        if (receive_Intent_Message.equals(MainActivity.workout_Intent)) {
            Log.d("Condition: ","Workout condition matched2");
            return workout.getList();
        }
        if (receive_Intent_Message.equals(MainActivity.preset_Intent)) {
            Log.d("Condition: ","Preset condition matched3");
            return preset.getList();
        }
        if (receive_Intent_Message.equals(custom.custom_Intent)) {
            Log.d("Condition: ","Custom condition matched4");
            return listFromCustom;
        } else {
            Log.d("Condition: ","Didn't match anything");
            return Arrays.asList(1000, 2000, 3000);
        }
    }

    public void start_Exercise(final View view) {
        start_music();
        mainButton.setVisibility(View.GONE);

        int totalElapsed = 0; // adds
        final int status = 0;
        for (privateVi = 0; privateVi < breathing_Pattern.size(); privateVi++) {
            Log.d("checked" ," " + privateVi);

            final int b = breathing_Pattern.get(privateVi); // use *1000 if list is in seconds
            if (privateVi != 0)
                totalElapsed += b;
            else
                startVibrate(view, 1, b);
            Handler h = new Handler();
            final int finalI = privateVi;
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startVibrate(view, finalI, b);
                }
            }, b + totalElapsed);
            System.out.println(privateVi);
        }
    }


    public void startVibrate(View view, final int j, final int length) {
        lungs = (ImageView)findViewById(R.id.imageView5);
        Handler v = new Handler();
        for (int i = 0; i < 2; i++) {
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (vi != null) {
                        vi.vibrate(50);
                    }
                }
            }, 150 * i); // also try b + totalElapsed, current is b*i
        }

        /* This code was intended to repeat the pattern but, we eliminated the idea later*/
//        if (!receive_Intent_Message.equals(custom.custom_Intent)) {
//          if (j == (breathing_Pattern.size() - 2)) {
//                    privateVi = 0;
//                    System.out.println("Repeat the pattern");
//                    System.out.println(j);
//                }
//            }

        // If it is a breathe out, do the shrink animation
        if (j % 2 == 0){
            System.out.println("out " + length);
            lungs.animate().scaleX(0.8f).setDuration(length);
            lungs.animate().scaleY(0.8f).setDuration(length);
        }
//
        // if it is a breathe in, do the expand animation
        else{
            System.out.println("in " + length);
            lungs.animate().scaleX(1.0f).setDuration(length);
            lungs.animate().scaleY(1.0f).setDuration(length);
        }
    }

    void start_music(){
        if (mediaPlayer != null)
            mediaPlayer.start();
    }
}

