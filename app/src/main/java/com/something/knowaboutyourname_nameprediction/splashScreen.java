package com.something.knowaboutyourname_nameprediction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.something.knowaboutyourname_nameprediction.R;

public class splashScreen extends AppCompatActivity {

    private static int splashTimeOut = 3050;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(splashScreen.this,MainActivity.class);
                startActivity(homeIntent);
                finish();

            }
        },splashTimeOut);
    }
}
