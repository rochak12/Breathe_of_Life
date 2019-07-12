
package com.cs246.breathoflife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import java.util.Arrays;
import java.util.List;

import static com.cs246.breathoflife.MainActivity.message_Intent;
import static com.cs246.breathoflife.MainActivity.relax_Intent;
public class Custom extends AppCompatActivity {
    static String custom_Intent = "I_WANT_TO_GO_TO_CUSTOM";

    List<Integer> list;
    List<Integer> mts = Arrays.asList(4000, 4000, 4375, 4375, 4750, 4750, 5125, 5125, 5500, 5500, 5875, 5875);
    List<Integer> fts = Arrays.asList(1000, 1000, 1500, 1500, 2100, 2100, 2700, 2700, 3300, 3300, 3900, 3900, 4500, 4500, 5100, 5100, 5700, 5700);
    List<Integer> ftm = Arrays.asList(1000, 1000, 1275, 1275, 1550, 1550, 1825, 1825, 2100, 2100, 2375, 2375, 2650, 2650, 2925, 2925, 3200, 3200, 3475, 3475, 3750, 3750, 4000, 4000);
    List<Integer> stm = Arrays.asList(5875, 5875, 5500, 5500, 5125, 5125, 4750, 4750, 4375, 4375, 4000, 4000);
    List<Integer> stf = Arrays.asList(5700, 5700, 5100, 5100, 4500, 4500, 3900, 3900, 3300, 3300, 2700, 2700, 2100, 2100, 1500, 1500, 1000, 1000);
    List<Integer> mtf = Arrays.asList(4000, 4000, 3750, 3750, 3475, 3475, 3200, 3200, 2925, 2925, 2650, 2650, 2375, 2375, 2100, 2100, 1825, 1825, 1550, 1550, 1275, 1275, 1000, 1000);
    List<Integer> fast1min = Arrays.asList(1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
            1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
            1000, 1000, 1000, 1000, 1000, 1000, 1000); // enough for 1 minute
    List<Integer> med1min = Arrays.asList(4000, 4000, 4000, 4000, 4000, 4000, 4000, 4000, 4000, 4000, 4000, 4000, 4000, 4000); // 1 minute
    List<Integer> slow1min = Arrays.asList(6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000); // 1 minute
    int fast = 1000;
    int med = 4000;
    int slow = 6000;
    int duration;  // values 0, 1, and 2 because it reflects how many times to append 1 minute intervals
    int start; // values 1, 2, or 3
    int middle; // values 1, 2, or 3
    int end; // values 1, 2, or 3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    protected void defaultAppender(int dur, int type) {
        // dur has values 0, 1, or 2.  Depending on the value, it will add
        // that many minutes to the list
        for (int i = 0; i < dur; i++) {
            switch (type) {
                case 1:
                    list.addAll(fast1min);
                    break;
                case 2:
                    list.addAll(med1min);
                    break;
                case 3:
                    list.addAll(slow1min);
                    break;
                default:
                    break;
            }
        }
    }

    protected void transitionAppender(int first, int second) {
        switch (first) {
            case 1:
                switch (second) {
                    case 1:
                        list.addAll(fast1min);
                    case 2:
                        list.addAll(ftm);
                    case 3:
                        list.addAll(fts);
                }
                break;
            case 2:
                switch (second) {
                    case 1:
                        list.addAll(mtf);
                    case 2:
                        list.addAll(med1min);
                    case 3:
                        list.addAll(mts);
                }
                break;
            case 3:
                switch (second) {
                    case 1:
                        list.addAll(stf);
                    case 2:
                        list.addAll(stm);
                    case 3:
                        list.addAll(slow1min);
                }
                break;
        }
    }

    protected void createExercise(int duration, int start, int middle, int end) {
        defaultAppender(duration, start);
        transitionAppender(start, middle);
        defaultAppender(duration, middle);
        transitionAppender(middle, end);
        defaultAppender(duration, end);
    }

    //Relax/Meditation
    public void launch_Meditate(View view) {
        Intent intent = new Intent(Custom.this, Exercise.class);
        intent.putExtra(message_Intent, relax_Intent);
        startActivity(intent);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.three_min:
                if (checked)
                    duration = 0;
                    break;
            case R.id.six_min:
                if (checked)
                    duration = 1;
                    break;
            case R.id.nine_min:
                if (checked)
                    duration = 2;
                    break;
            case R.id.s_slow:
                if (checked)
                    start = 1;
                    break;
            case R.id.s_med:
                if (checked)
                    start = 2;
                    break;
            case R.id.s_fast:
                if (checked)
                    start = 3;
                    break;
            case R.id.m_slow:
                if (checked)
                    middle = 1;
                    break;
            case R.id.m_med:
                if (checked)
                    middle = 2;
                    break;
            case R.id.m_fast:
                if (checked)
                    middle = 3;
                    break;
            case R.id.e_slow:
                if (checked)
                    end = 1;
                    break;
            case R.id.e_med:
                if (checked)
                    end = 2;
                    break;
            case R.id.e_fast:
                if (checked)
                    end = 3;
                    break;
        }
    }


    //Launching custom
    public void launch_custom(View view){
        System.out.println("Ready to go to Workout Mode");
        Intent intent = new Intent(Custom.this, Exercise.class);
        intent.putExtra(MainActivity.message_Intent, custom_Intent);
        startActivity(intent);
    }
}

