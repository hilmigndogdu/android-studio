package com.hilmigndogdu.alistirma2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Intent intent;
    Button winBtn;
    Button loseBtn;
    SharedPreferences sharedPreferences;
    int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        winBtn = findViewById(R.id.btn_win);
        loseBtn = findViewById(R.id.btn_gameover);

        sharedPreferences = getSharedPreferences("com.hilmigndogdu.alistirma2", Context.MODE_PRIVATE);
        level = sharedPreferences.getInt("level",1);

        winBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++level;
                sharedPreferences.edit().putInt("level",level).apply();

                intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().remove("level").apply();

                intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}