package com.hilmigndogdu.aimbooster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        textView = findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.hilmigndogdu.aimbooster", Context.MODE_PRIVATE);
        int score = sharedPreferences.getInt("storedScore",0);

        textView.setText("Your : "+score);



        //Adapter

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);

    }
}