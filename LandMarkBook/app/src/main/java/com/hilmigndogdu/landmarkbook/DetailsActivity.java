package com.hilmigndogdu.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hilmigndogdu.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        LandMark selectedLandmark =(LandMark) intent.getSerializableExtra("landmark");

        binding.nameTxt.setText(selectedLandmark.name);
        binding.countryTxt.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);

    }
}