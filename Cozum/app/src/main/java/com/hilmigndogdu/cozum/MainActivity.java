package com.hilmigndogdu.cozum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.text.InputType;
import android.view.View;
import android.widget.Toast;

import com.hilmigndogdu.cozum.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("com.hilmigndogdu.cozum",0);


        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = binding.emailEdt.getText().toString();
                String password = binding.passwordEdt.getText().toString();

                sharedPreferences.edit().putString("username",username).apply();
                sharedPreferences.edit().putString("password", password).apply();


            }
        });
    }
}