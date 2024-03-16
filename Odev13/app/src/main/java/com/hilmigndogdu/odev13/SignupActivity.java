package com.hilmigndogdu.odev13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hilmigndogdu.odev13.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}