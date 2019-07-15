package com.cs246.breathoflife;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
//import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise extends AppCompatActivity {
    ImageView lungs;
    ObjectAnimator objectanimator1, objectanimator2, objectanimator3, objectanimator4;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lungs = (ImageView)findViewById(R.id.imageView5);
        objectanimator1 = ObjectAnimator.ofFloat(lungs,"scaleX",1.5f);
        objectanimator2 = ObjectAnimator.ofFloat(lungs,"scaleY",1.5f);
        objectanimator3 = ObjectAnimator.ofFloat(lungs,"scaleX",0.66f);
        objectanimator4 = ObjectAnimator.ofFloat(lungs,"scaleY",0.66f);
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
        System.out.println("This is my Intent:" + receive_Intent_Message);


        breathing_Pattern = get_Pattern();
        System.out.println("this is my pattern" + breathing_Pattern);
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
            System.out.println("Relax condition matched1");
            return meditation.getList(); // make sure the array is always odd to make sure it ends on a breathe out
        }
        if (receive_Intent_Message.equals(MainActivity.workout_Intent)) {
            System.out.println("Workout condition matched2");
            return workout.getList();
        }
        if (receive_Intent_Message.equals(MainActivity.preset_Intent)) {
            System.out.println("Preset condition matched3");
            return preset.getList();
        }
        if (receive_Intent_Message.equals(custom.custom_Intent)) {
            System.out.println("Custom condition matched4");
            return listFromCustom;
        } else {
            System.out.println("Didn't match anything");
            return Arrays.asList(1000, 2000, 3000);
        }
    }

    public void start_Exercise(final View view) {
        start_music();
        mainButton.setVisibility(View.GONE);

        int totalElapsed = 0; // adds
        final int status = 0;
        for (int i = 0; i < breathing_Pattern.size(); i++) {
//            if (i == breathing_Pattern.size()-1) i = 0;
//                System.out.println("Repeat the pattern");
            final int b = breathing_Pattern.get(i); // use *1000 if list is in seconds
            if (i != 0)
                totalElapsed += b;
            else
                startVibrate(view, 1, b);
            Handler h = new Handler();
            final int finalI = i;
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startVibrate(view, finalI, b);
                }
            }, b + totalElapsed);
            System.out.println(i);
        }
    }


    public void startVibrate(View view, final int j, final int length) {
        Handler v = new Handler();
        for (int i = 0; i < 2; i++) {
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (vi != null) {
                        vi.vibrate(50);
                    }
//                    if (breathInToast != null && breathOutToast != null) {

//                            breathInToast.show();
//                    }
                }
            }, 150 * i); // also try b + totalElapsed, current is b*i
        }
        if (j % 2 == 0){
            System.out.println("out " + length);
            objectanimator3.setDuration(length);
            objectanimator4.setDuration(length);
            objectanimator3.start();
            objectanimator4.start();

        }
//
        else{
            System.out.println("in " + length);
            objectanimator1.setDuration(length);
            objectanimator2.setDuration(length);
            objectanimator1.start();
            objectanimator2.start();
        }
    }

    void start_music(){
        if (mediaPlayer != null)
            mediaPlayer.start();
    }


}

