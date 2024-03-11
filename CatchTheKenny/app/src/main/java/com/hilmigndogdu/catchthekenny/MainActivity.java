package com.hilmigndogdu.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timeTxt;
    TextView scoreTxt;
    int number =0;
    int score =0;
    ImageView imageView0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTxt = findViewById(R.id.timeTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        imageView0 =findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);

        imageArray = new ImageView[]{imageView0,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8};
        hideImages();


        score = 0;

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeTxt.setText("Time : "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeTxt.setText("Time Off");
                handler.removeCallbacks(runnable);
                for (ImageView imageView: imageArray){
                    imageView.setVisibility(View.INVISIBLE);
                }

            }
        }.start();

    }

    public void increaseScore(View view){
        score++;
        scoreTxt.setText("Score : "+score);

        }

    public void hideImages(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image: imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(runnable,300);
            }
        };

        handler.post(runnable);
        
    }


    }

