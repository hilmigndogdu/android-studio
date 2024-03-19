package com.hilmigndogdu.odev13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hilmigndogdu.odev13.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String username = binding.usernameEdt.getText().toString();
                    String password = binding.passwordEdt.getText().toString();
                    String age = binding.yasEdt.getText().toString();

                    int heightTemp = binding.boySeekBar.getProgress();
                    String height = String.valueOf(heightTemp);

                    int weightTemp = binding.kiloPicker.getProgress();
                    String weight = String.valueOf(weightTemp);

                    database = SignupActivity.this.openOrCreateDatabase("UsersInfo",MODE_PRIVATE,null);

                    database.execSQL("CREATE TABLE IF NOT EXISTS users(id INTEGER PRIMARY KEY, username VARCHAR, password VARCHAR, age VARCHAR, height VARCHAR, weight VARCHAR)");

                    String sqlstring = "INSERT INTO users(username, password, age, height, weight) VALUES(?, ?, ?, ?, ?)";

                    SQLiteStatement sqLiteStatement = database.compileStatement(sqlstring);
                    sqLiteStatement.bindString(1,username);
                    sqLiteStatement.bindString(2,password);
                    sqLiteStatement.bindString(3,age);
                    sqLiteStatement.bindString(4,height);
                    sqLiteStatement.bindString(5,weight);
                    sqLiteStatement.execute();


                }catch (Exception e){
                    e.printStackTrace();
                }
                Toast.makeText(SignupActivity.this, "Kayıt Olma İşlemi Başarılı", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

    }
}