package com.hilmigndogdu.odev13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hilmigndogdu.odev13.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("com.hilmigndogdu.odev12",MODE_PRIVATE);

        int storedId = sharedPreferences.getInt("storedId", 0);



        binding.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    SQLiteDatabase sqLiteDatabase = ProfileActivity.this.openOrCreateDatabase("UsersInfo",MODE_PRIVATE,null);

                    Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE id = ?", new String[]{String.valueOf(storedId)});

                    int usernameIndex = cursor.getColumnIndex("username");
                    int ageIndex = cursor.getColumnIndex("age");
                    int heightIndex = cursor.getColumnIndex("height");
                    int weightIndex = cursor.getColumnIndex("weight");
                    int idIndex = cursor.getColumnIndex("id");

                    while (cursor.moveToNext()){
                        String username = cursor.getString(usernameIndex);
                        binding.myUsernameTxt.setText("Kullanıcı Adı : "+username);
                        int age = cursor.getInt(ageIndex);
                        binding.yasTxt.setText("Yaş : "+age);
                        int weight = cursor.getInt(weightIndex);
                        binding.kiloEdt.setText(""+weight);
                        int height = cursor.getInt(heightIndex);
                        binding.boyEdt.setText(""+height);
                        int id = cursor.getInt(idIndex);
                    }
                    cursor.close();



                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        binding.calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String boytemp = binding.boyEdt.getText().toString();
                    String kilotemp = binding.kiloEdt.getText().toString();

                    Double boy = Double.parseDouble(boytemp) + 100.0 ;
                    Double kilo = Double.parseDouble(kilotemp);

                    double vkitemp = (boy*boy)/10000;
                    double vki = kilo / vkitemp;

                    binding.vkiTxt.setText("Vücut Kitle Endeksiniz : "+vki);
                }catch (Exception e){
                    Toast.makeText(ProfileActivity.this, "Giriş Bilgileri Bulunamadı", Toast.LENGTH_SHORT).show();

                }
            }
        });

        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newHeight = binding.boyEdt.getText().toString();
                String newWeight = binding.kiloEdt.getText().toString();

                try {
                    SQLiteDatabase sqLiteDatabase = ProfileActivity.this.openOrCreateDatabase("UsersInfo",MODE_PRIVATE,null);

                    //burayı hocaya sor*
                    String updateQuery = "UPDATE users SET height = ?, weight = ? WHERE id = ?";
                    SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(updateQuery);
                    sqLiteStatement.bindString(1, newHeight);
                    sqLiteStatement.bindString(2, newWeight);
                    sqLiteStatement.bindString(3, String.valueOf(storedId)); // storedId: Güncellenecek kullanıcının id'si
                    int rowsAffected = sqLiteStatement.executeUpdateDelete();
                    //*

                    if (rowsAffected > 0) {
                        Toast.makeText(ProfileActivity.this, "Bilgiler güncellendi", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ProfileActivity.this, "Bilgiler güncellenemedi", Toast.LENGTH_SHORT).show();
                    }
                    sqLiteDatabase.close();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SQLiteDatabase sqLiteDatabase = ProfileActivity.this.openOrCreateDatabase("UsersInfo", MODE_PRIVATE, null);

                    String deleteQuery = "DELETE FROM users WHERE id = ?";
                    SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(deleteQuery);
                    sqLiteStatement.bindString(1, String.valueOf(storedId));
                    sqLiteStatement.executeUpdateDelete();
                    sqLiteDatabase.close();

                    Toast.makeText(ProfileActivity.this, "Kullanıcı bilgileri silindi", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                    startActivity(intent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}