package com.cs246.breathoflife;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.WindowManager;

import java.lang.ref.WeakReference;
import static android.support.v4.content.ContextCompat.getSystemService;

class Proximity implements Runnable {
    private SensorManager mySensorManager;
    private Sensor myProximitySensor;

    MainActivity mainActivity;
    WeakReference<MainActivity> weakReference;


    public Proximity(MainActivity mainActivity, Context context) {
        this.mainActivity = mainActivity;
        weakReference = new WeakReference<>(mainActivity);

        mySensorManager =  null; //(SensorManager) getSystemService(context);//Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null) {
            System.out.println("No Proximity Sensor!");
        } else {
            mySensorManager.registerListener(proximitySensorEventListener,
                    myProximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }


    SensorEventListener proximitySensorEventListener
            = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                if (event.values[0] == 0) {
                    System.out.println("Near");
                } else {
                    System.out.println("Away");
                }
            }
        }
    };

    @Override
    public void run() {
        while (true) {


            //check proximity everytime;
            // if closer objet
            // call function to turn of display
            if (true)
                display(false);
            else
                display(true);
        }
    }

    private void display(boolean b) {
        if (mainActivity == null) {
            mainActivity = weakReference.get();

        }
    }


    //check if activity is off
    // if so recall and do activity on UI thr
}