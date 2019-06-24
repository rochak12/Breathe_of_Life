package com.cs246.breathoflife;

import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Exercise extends AppCompatActivity {

    private Button HomeBtn;
    Button startTimerInExercise;
    TextView textView2;
    //    private ArrayList<Double> breathing_Pattern = new ArrayList<Double>(
//            Arrays.<Float>asList(3.0, 3.0)
//    );
//    private List<>
    private List<Integer> breathing_Pattern;
    Vibrator vi;
    String receive_Intent_Message;
    Meditation meditation = new Meditation();
    Workout workout = new Workout();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        startTimerInExercise = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);

        receive_Intent_Message = getIntent().getStringExtra(MainActivity.message_Intent);
        System.out.println("This is my Intent:" + receive_Intent_Message);

        breathing_Pattern = get_Pattern();
        System.out.println("this is my pattern" + breathing_Pattern);

    }

    List<Integer> get_Pattern() {
        System.out.println(receive_Intent_Message);
        System.out.println(MainActivity.relax_Intent + "\n" + MainActivity.workout_Intent + "Condition checked");
        if (receive_Intent_Message.equals(MainActivity.relax_Intent)) {
            System.out.println("This condition matched1");
            return meditation.getList(); // make sure the array is always odd to make sure it ends on a breathe out
        }
        if (receive_Intent_Message.equals(MainActivity.workout_Intent)){
            System.out.println("This condition matched2");
            return workout.getList();
        }
        return Arrays.asList(1,2,3);
       // return null;
    }

    public void goHome(View view) {
        finish();
    }

    public void startVibrate(View view, final int j) {
        vi = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        Handler v = new Handler();
        for (int i = 0; i < 2; i++) {
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    vi.vibrate(50);
                    if (j % 2 == 0)
                        Toast.makeText(Exercise.this, "Breathe out", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Exercise.this, "Breathe in", Toast.LENGTH_SHORT).show();
                }
            }, 150 * i); // also try b + totalElapsed, current is b*i
        }
    }


    public void startTimerInExercise(final View view) {
//            vi = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        int totalElapsed = 0; // adds
        final int status = 0;
        for (int i = 0; i < breathing_Pattern.size(); i++) {
            int b = breathing_Pattern.get(i) * 1000;
            if (i != 0)
                totalElapsed += b;
            else
//                    vi.vibrate(50); // initial starting vibration
                startVibrate(view, 1);
            Handler h = new Handler();
            final int finalI = i;
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
//                        vi.vibrate(50);
                    startVibrate(view, finalI);

                }
            }, b + totalElapsed); //
            System.out.println(i);
        }
    }

}


