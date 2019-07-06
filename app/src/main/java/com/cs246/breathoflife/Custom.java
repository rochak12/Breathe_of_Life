package com.cs246.breathoflife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class Custom extends AppCompatActivity {
    List<Integer> list;
    List<Integer> mts = Arrays.asList(4000, 4000, 4375, 4375, 4750, 4750, 5125, 5125, 5500, 5500, 5875, 5875);
    List<Integer> fts = Arrays.asList(1000, 1000, 1500, 1500, 2100, 2100, 2700, 2700, 3300, 3300, 3900, 3900, 4500, 4500, 5100, 5100, 5700, 5700);
    List<Integer> ftm = Arrays.asList(1000, 1000, 1275, 1275, 1550,1550, 1825, 1825, 2100, 2100, 2375, 2375, 2650, 2650, 2925, 2925, 3200, 3200, 3475, 3475, 3750, 3750, 4000, 4000);
    List<Integer> stm = Arrays.asList(5875, 5875, 5500, 5500, 5125, 5125, 4750, 4750, 4375, 4375, 4000, 4000);
    List<Integer> stf = Arrays.asList(5700, 5700, 5100, 5100, 4500, 4500, 3900, 3900, 3300, 3300, 2700, 2700, 2100, 2100, 1500, 1500, 1000, 1000);
    List<Integer> mtf = Arrays.asList(4000, 4000, 3750, 3750, 3475, 3475, 3200, 3200, 2925, 2925, 2650, 2650, 2375, 2375, 2100, 2100, 1825, 1825, 1550, 1550, 1275, 1275, 1000, 1000);
    int fast = 1000;
    int med = 4000;
    int slow = 6000;
    int duration;
    int start;
    int middle;
    int end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }
    protected void createExercise(int duration, int start, int middle, int end){

    }
}
