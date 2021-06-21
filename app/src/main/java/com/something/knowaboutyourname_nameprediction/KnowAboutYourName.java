package com.something.knowaboutyourname_nameprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class KnowAboutYourName extends AppCompatActivity {
    Button buttonk;
    TextView tarif,tarifa;
    RadioGroup rg;
    RadioButton m, f;
    ImageView lastpic;
    String st;
    EditText enterYourName;
    Integer []photos = {R.drawable.man,R.drawable.woman};

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_about_your_name);
       // Meaningofname = findViewById(R.id.name);
        this.lastpic = findViewById(R.id.finalPhoto);
        enterYourName = findViewById(R.id.editText);
        enterYourName.setInputType(InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        tarif=findViewById(R.id.tareef);

        //rg = findViewById(R.id.radiog);
        rg= findViewById(R.id.radiog);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1565728959377176/8083047844");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                if(mInterstitialAd.isLoaded()){
                    mInterstitialAd.show();
                }
                else{

                }
            }
        });

        buttonk = findViewById(R.id.button);
        buttonk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KnowAboutYourName.this,knowName.class);
                int m= rg.getCheckedRadioButtonId();
                if(m==R.id.man){
                    m=0;
                }
                else{
                   m=1;
                }



                st = enterYourName.getText().toString();
                intent.putExtra("value",st);
                intent.putExtra("pos",m);
                startActivity(intent);
                finish();
            }
        });

    }
    public void prepareAD(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }
}
