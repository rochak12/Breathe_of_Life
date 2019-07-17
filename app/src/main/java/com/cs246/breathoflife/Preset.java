package com.cs246.breathoflife;

import java.util.Arrays;
import java.util.List;

public class Preset {
    List<Integer> list;

    /*We can send some value from activity main to meditation if we want to do custom
      Meditation*/

    Preset(){
        list = Arrays.asList(3475, 3200, 3200, 2925, 2925, 2650, 2650, 2375, 2375, 2100, 2100, 1825, 1825, 1550, 1550,
                1275, 1275, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
                1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000);
        System.out.println("Preset created this list" + list);
    }

    public List<Integer> getList() {
        System.out.println("Ready to return pattern from Preset:" + list  );
        return list;
    }
}