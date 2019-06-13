package com.cs246.breathoflife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercise extends AppCompatActivity {

    //private Button HomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

//        // Create a button to go back to home
//        HomeBtn = findViewById(R.id.exercize_button);
//        HomeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                moveToHome();
//            }
//        });

    }
    // Home Button
//    private void moveToHome() {
//        Intent intent = new Intent(Exercise.this, MainActivity.class);
//        startActivity(intent);
//    }
}
