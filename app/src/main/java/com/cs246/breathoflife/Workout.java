package com.cs246.breathoflife;

import java.util.Arrays;
import java.util.List;

public class Workout {
    List<Integer> list;

    /*We can send some value from activity main to meditation if we want to do custom
      Meditation*/

    Workout(){
        list = Arrays.asList(1000, 1000, 1275, 1275, 1550,1550, 1825, 1825, 2100, 2100, 2375, 2375, 2650, 2650, 2925,
                2925, 3200, 3200, 3475, 3475, 3750, 3750, 4000, 4000);
        System.out.println("Workout created this list" + list);
    }

    public List<Integer> getList() {
        System.out.println("Ready to return pattern from Workout:" + list  );
        return list;
    }
}