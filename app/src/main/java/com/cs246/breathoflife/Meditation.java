package com.cs246.breathoflife;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Meditation {
    List<Integer> list;

    /*We can send some value from activity main to meditation if we want to do custom
      Meditation*/

    Meditation(){
        list = Arrays.asList(3, 3, 3, 3, 4, 4, 4, 4, 3, 3, 3, 3);
        System.out.println("Relax/Meditation created this list" + list);

    }

    public List<Integer> getList() {
        return list;
    }
}
