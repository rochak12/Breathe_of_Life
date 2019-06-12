package com.cs246.breathoflife;

import java.util.ArrayList;

public class Meditation {
    ArrayList<Integer> arrayList = new ArrayList<>();

    /*We can send some value from activity main to meditation if we want to do custom
      Meditation*/

    Meditation(){
        arrayList.add(0);
        arrayList.add(10);
        arrayList.add(30);

    }

    ArrayList<Integer> getArrayList() {
        return arrayList;
    }
}
