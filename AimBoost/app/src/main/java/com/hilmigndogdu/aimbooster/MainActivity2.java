package com.hilmigndogdu.aimbooster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hilmigndogdu.aimbooster.databinding.ActivityMain2Binding;
import com.hilmigndogdu.aimbooster.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
    public void start(View view){

        Intent intent1 = new Intent(MainActivity2.this,MainActivity.class);

        intent1.putExtra("userName",binding.nameEdt.getText().toString());

        startActivity(intent1);

    }

    public void show(View view){

        Intent intent1 = new Intent(MainActivity2.this,ShowActivity.class);

        startActivity(intent1);

    }
}