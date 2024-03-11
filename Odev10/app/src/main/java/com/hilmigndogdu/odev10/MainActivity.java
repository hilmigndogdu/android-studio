package com.hilmigndogdu.odev10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hilmigndogdu.odev10.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    Intent intent;
    String noteTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreferences = getSharedPreferences("com.hilmigndogdu.odev10", Context.MODE_PRIVATE);

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 noteTxt = binding.noteEdt.getText().toString();

                 sharedPreferences.edit().putString("storedNote",noteTxt).apply();

                Toast.makeText(MainActivity.this,"Kaydedildi",Toast.LENGTH_LONG).show();

                intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        binding.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,DepoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}