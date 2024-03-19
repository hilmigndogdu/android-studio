package com.hilmigndogdu.odev13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hilmigndogdu.odev13.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<UsersInfo> usersInfoArrayList;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("com.hilmigndogdu.odev12",MODE_PRIVATE);

        usersInfoArrayList = new ArrayList<>();
        getData();

        binding.signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {

            boolean userFound = false;
            @Override
            public void onClick(View v) {
                for (UsersInfo user: usersInfoArrayList) {
                    if (binding.usernameEdt.getText().toString().equals(user.username) && binding.passwordEdt.getText().toString().equals(user.password)){
                        userFound = true;

                        sharedPreferences.edit().putInt("storedId",user.id).apply();

                        break;

                    }
                }
                if (userFound){
                    Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Kullanıcı adı veya şifre yanlış", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getData(){

        try {
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("UsersInfo",MODE_PRIVATE,null);

            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users",null);
            int usernameIndex = cursor.getColumnIndex("username");
            int passwordIndex = cursor.getColumnIndex("password");
            int idIndex = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                String username = cursor.getString(usernameIndex);
                String password = cursor.getString(passwordIndex);
                int id = cursor.getInt(idIndex);

                UsersInfo usersInfo = new UsersInfo(username,password,id);
                usersInfoArrayList.add(usersInfo);
            }
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}