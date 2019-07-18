package com.cs246.breathoflife;

import android.util.Log;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    ArrayList<Integer> testCode1 = new ArrayList<Integer>(Arrays.asList(6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000));
    ArrayList<Integer> testCode2 = new ArrayList<Integer>(Arrays.asList(5875, 5500, 5500, 5125, 5125, 4750, 4750, 4375, 4375, 4000, 4000, 4000, 4000, 3750, 3750, 3475, 3475, 3200, 3200, 2925, 2925, 2650, 2650, 2375, 2375, 2100, 2100, 1825, 1825, 1550, 1550, 1275, 1275, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000));


    @Test
    public void testCustom() {

            Custom c = new Custom();


            c.createExercise(0, 3, 3, 3);
//        test = c.list;
            int numFails = 0;
            for (int i = 0; i < testCode1.size(); i++) {
//            if (testCode.get(i) == c.list.get(i))
                int p = c.list.get(i);
                int q = testCode1.get(i);

                if (p != q)
                    numFails += 1;
//                System.out.println("Actual: " + c.list.get(i) + " Test: " + testCode.get(i));


            }


            System.out.println(numFails + " failures");
        }
    }
