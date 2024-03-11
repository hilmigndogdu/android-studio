package com.hilmigndogdu.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hilmigndogdu.quiz2.databinding.ActivityKayitBinding;
import com.hilmigndogdu.quiz2.databinding.ActivityMainBinding;

public class KayitActivity extends AppCompatActivity {

    ActivityKayitBinding binding;
    SharedPreferences sharedPreferences;
    String name,password,birthday,userName;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKayitBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreferences = this.getSharedPreferences("com.hilmigndogdu.quiz2",MODE_PRIVATE);


        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.nameEdt.getText().toString();
                password = binding.passwordEdt.getText().toString();
                birthday = binding.birthEdt.getText().toString();
                userName = binding.usernameEdt.getText().toString();

                sharedPreferences.edit().putString("storedName",name).apply();
                sharedPreferences.edit().putString("storedPass",password).apply();
                sharedPreferences.edit().putString("storedBirth",birthday).apply();
                sharedPreferences.edit().putString("storedUserName",userName).apply();

                Toast.makeText(KayitActivity.this,"Kayıt Başarılı",Toast.LENGTH_LONG).show();

                intent = new Intent(KayitActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}