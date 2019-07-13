package com.cs246.breathoflife;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class settings extends AppCompatActivity {
    public static String APP_PREFS = "APPLICATION_PREFERENCES";
    public static String MUSIC = "MUSIC";
    public static String VIBRATION = "VIBRATION";

    static boolean music;
    static boolean vibration;

    Switch music_Switch;
    Switch vibration_Switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        vibration_Switch =  findViewById(R.id.switch3);
        music_Switch =  findViewById(R.id.switch2);
        check_Setting();
    }

    private void check_Setting() {
        SharedPreferences sharedPref = getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        music = sharedPref.getBoolean(MUSIC, true);
        vibration = sharedPref.getBoolean(VIBRATION, true);
        if (!music) no_Music();
        if (!vibration) no_Vibration();
    }

    private void no_Vibration() {
        vibration_Switch.setChecked(false);
    }

    private void no_Music() {
        music_Switch.setChecked(false);
    }

    public void turn_On_Vibration(View view){
        vibration = (vibration ? false : true) ;
        edit_Setting();
    }


    public void turn_On_Music(View view){
        music = (music ? false : true);
        edit_Setting();
    }

    private void edit_Setting() {
        System.out.println(music);
        System.out.println(vibration);
        SharedPreferences sharedPrefs = getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putBoolean(MUSIC, music);
        editor.putBoolean(VIBRATION, vibration);

        editor.apply();
    }
}
