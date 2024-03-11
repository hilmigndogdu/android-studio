package com.hilmigndogdu.cozum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hilmigndogdu.cozum.databinding.ActivityMain2Binding;
import com.hilmigndogdu.cozum.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}