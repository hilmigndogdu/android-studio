package com.hilmigndogdu.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.hilmigndogdu.quiz2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Intent intent;
    SharedPreferences sharedPreferences;

    String userName,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreferences = this.getSharedPreferences("com.hilmigndogdu.quiz2",MODE_PRIVATE);

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,KayitActivity.class);
                startActivity(intent);
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String storedUserName = sharedPreferences.getString("storedUserName","boş");
                String storedPassword = sharedPreferences.getString("storedPass", "boş");

                userName = binding.usernameEdt.getText().toString();
                password = binding.passwordEdt.getText().toString();

                if(storedUserName.equals(userName) && storedPassword.equals(password)){
                    intent = new Intent(MainActivity.this,AnaSayfaActivity.class);
                    startActivity(intent);
                }else{
                        Toast.makeText(MainActivity.this, "Giriş Başarısız!", Toast.LENGTH_LONG).show();
                    }
                }
        });
    }
}