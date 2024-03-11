package com.hilmigndogdu.odev10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.hilmigndogdu.odev10.databinding.ActivityDepoBinding;
import com.hilmigndogdu.odev10.databinding.ActivityMainBinding;

public class DepoActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    ActivityDepoBinding binding;
    String noteTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreferences = getSharedPreferences("com.hilmigndogdu.odev10", Context.MODE_PRIVATE);

        noteTxt = sharedPreferences.getString("storedNote","-1");
        binding.textView.setText(noteTxt);
    }
}