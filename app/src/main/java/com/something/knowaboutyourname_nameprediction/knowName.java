package com.something.knowaboutyourname_nameprediction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

public class knowName extends AppCompatActivity implements View.OnClickListener, ViewSwitcher.ViewFactory {
ImageSwitcher is, imageSwitcher;
ImageView finalImage;
TextView Name, tarif,desc;
Button b, buttonk,Button, downbtn;
RadioButton male, female;
String se;
ConstraintLayout main;
String string;
RadioGroup rg;
String[] array,array2;
    private InterstitialAd mInterstitialAd;


private ImageView spc;
String st;
Integer [] name={R.drawable.backtwo,R.drawable.backa,R.drawable.backslide,R.drawable.backred,R.drawable.backblue};
int length1=name.length;

int c=-1,pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.know_name);



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

       array = getResources().getStringArray(R.array.man);
        array2 = getResources().getStringArray(R.array.woman);

ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.INTERNET} , PackageManager.PERMISSION_GRANTED);


imageSwitcher = findViewById(R.id.image1);
        st=getIntent().getExtras().getString("value");
        pos=getIntent().getExtras().getInt("pos");

        finalImage = findViewById(R.id.finalPhoto);
        if(pos==0){
          finalImage.setImageResource(R.drawable.man);
        }
        else{
            finalImage.setImageResource(R.drawable.woman);
        }
       tarif = findViewById(R.id.tareef);
        desc = findViewById(R.id.desc);
       Button = findViewById(R.id.button);
rg = findViewById(R.id.radiog);



        is = findViewById(R.id.image1);
        male= findViewById(R.id.man);
        female= findViewById(R.id.woman);
        Name = findViewById(R.id.name);
        b= findViewById(R.id.b1);
        b.setOnClickListener(this);
        is.setFactory(this);

        main = findViewById(R.id.main);
        Name.setText(st);

        Random r = new Random();


if(pos==0)
{int i1 = r.nextInt(array.length - 0 + 1) + 0;
   string= array[i1];
}
else{
    int i1 = r.nextInt(array2.length - 0 + 1) + 0;
    string= array2[i1];
}

        string=string.replace("zz",""+ st);
        desc.setText(string);
    }

    @Override
    public View makeView() {
        ImageView iv= new ImageView(this);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
        return iv;
    }

    @Override
    public void onClick(View view) {
c++;
if(c==length1){
c=0;
is.setImageResource(name[c]);
}
else{
    is.setImageResource(name[c]);
}
        }








}
