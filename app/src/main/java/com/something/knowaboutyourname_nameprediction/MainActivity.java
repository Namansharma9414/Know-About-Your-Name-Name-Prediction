package com.something.knowaboutyourname_nameprediction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private CardView knowAboutYourName, aboutus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
knowAboutYourName = findViewById(R.id.cardViewName);
aboutus = findViewById(R.id.cardViewAbout);


knowAboutYourName.setOnClickListener(this);
aboutus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(knowAboutYourName.isPressed()){
        Intent intent = new Intent(MainActivity.this, KnowAboutYourName.class);
        startActivity(intent);}
        if(aboutus.isPressed()){
            Intent intent = new Intent(MainActivity.this, aboutUs.class);
            startActivity(intent);
        }

    }
}
