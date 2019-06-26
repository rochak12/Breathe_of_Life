package com.cs246.breathoflife;

import java.util.Arrays;
import java.util.List;

public class Workout {
    List<Integer> list;

    /*We can send some value from activity main to meditation if we want to do custom
      Meditation*/

    Workout(){
        list = Arrays.asList(3, 3, 3, 3, 4, 4, 4, 4, 3, 3, 3, 3);
        System.out.println("Workout created this list" + list);
    }

    public List<Integer> getList() {
        System.out.println("Ready to return pattern from Workout:" + list  );
        return list;
    }
}