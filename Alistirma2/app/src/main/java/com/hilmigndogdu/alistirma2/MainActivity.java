package com.hilmigndogdu.alistirma2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    TextView textView;
    SharedPreferences sharedPreferences;
    int level;
    Button btnOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        btnOne = findViewById(R.id.btn_one);

        sharedPreferences = getSharedPreferences("com.hilmigndogdu.alistirma2", Context.MODE_PRIVATE);
        level = sharedPreferences.getInt("level",1);
        textView.setText("Level : "+level);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });



    }
}