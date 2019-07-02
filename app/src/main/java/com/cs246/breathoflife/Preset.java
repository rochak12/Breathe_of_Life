package com.cs246.breathoflife;


import java.util.Arrays;
import java.util.List;

public class Preset {
    List<Integer> list;

    /*We can send some value from activity main to meditation if we want to do custom
      Meditation*/

    Preset(){
        list = Arrays.asList(3, 3, 3, 3, 4, 4, 4, 4, 3, 3, 3, 3);
        System.out.println("Preset created this list" + list);
    }

    public List<Integer> getList() {
        System.out.println("Ready to return pattern from Preset:" + list  );
        return list;
    }
}