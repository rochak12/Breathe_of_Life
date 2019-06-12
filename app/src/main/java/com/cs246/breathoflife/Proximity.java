package com.cs246.breathoflife;

import java.lang.ref.WeakReference;

class Proximity implements Runnable {
MainActivity mainActivity;
WeakReference<MainActivity> weakReference;



    public Proximity(MainActivity mainActivity) {
        weakReference = new WeakReference<>(mainActivity);
    }

    @Override
    public void run() {
        while (true){
            //check proximity everytime;
            // if closer objet
                 // call function to turn of display
            //else
                //if display off then turn om
        }
    }

    //check if activity is off
    // if so recall and do activity on UI thread.
}
