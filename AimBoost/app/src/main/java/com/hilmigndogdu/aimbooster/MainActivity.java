package com.hilmigndogdu.aimbooster;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hilmigndogdu.aimbooster.databinding.ActivityMain2Binding;
import com.hilmigndogdu.aimbooster.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    Handler handler;
    Runnable runnable;
    Intent intent2;
    int score=0;
    ImageView[] imageArray;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        imageArray = new ImageView[]{binding.imageView0,binding.imageView1,binding.imageView2,binding.imageView3,binding.imageView4,binding.imageView5,binding.imageView6,binding.imageView7,binding.imageView8,binding.imageView9,binding.imageView10,binding.imageView11,binding.imageView12,binding.imageView13,binding.imageView14,binding.imageView15};
        hideImages();


        intent2 = getIntent();

        userName = intent2.getStringExtra("userName");
        binding.userNameTxt.setText(userName);

        countDownTimer();


    }

    public void countDownTimer(){

        new CountDownTimer(10000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                binding.timeTxt.setText("Time : "+millisUntilFinished/1000);
            }
            @Override
            public void onFinish() {

                binding.timeTxt.setText("Time Off");
                handler.removeCallbacks(runnable);
                for (ImageView imageView: imageArray){
                    imageView.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder finishAlert = new AlertDialog.Builder(MainActivity.this);
                finishAlert.setTitle("Game Over");
                finishAlert.setMessage("Tekrar Oynamak İster misiniz?");

                finishAlert.setPositiveButton("Tekrar Oyna", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intent2);

                    }
                });
                finishAlert.show();

                finishAlert.setNegativeButton("Menüye Geri Dön", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent3 = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(intent3);
                    }
                });
                finishAlert.show();
            }
        }.start();

    }
    public void increaseScore(View view){
        score++;
        binding.scoreTxt.setText("Score : "+score);

        sharedPreferences = this.getSharedPreferences("com.hilmigndogdu.aimbooster", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("storedScore",score);
        sharedPreferences.edit().putString("storedName",userName);

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
                int i = random.nextInt(16);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(runnable,1000);
            }
        };

        handler.post(runnable);

    }





}

