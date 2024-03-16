package com.hilmigndogdu.artbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hilmigndogdu.artbook.databinding.ActivityArtBinding;
import com.hilmigndogdu.artbook.databinding.ActivityMainBinding;

public class ArtActivity extends AppCompatActivity {

    ActivityArtBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}