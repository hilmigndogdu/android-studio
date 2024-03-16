package com.hilmigndogdu.exercise15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hilmigndogdu.exercise15.databinding.ActivityTravelBinding;

public class TravelActivity extends AppCompatActivity {

    ActivityTravelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTravelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}