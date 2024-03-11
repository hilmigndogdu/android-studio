package com.hilmigndogdu.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hilmigndogdu.quiz2.databinding.ActivityAnaSayfaBinding;
import com.hilmigndogdu.quiz2.databinding.ActivityMainBinding;

public class AnaSayfaActivity extends AppCompatActivity {

    ActivityAnaSayfaBinding binding;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnaSayfaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(AnaSayfaActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}