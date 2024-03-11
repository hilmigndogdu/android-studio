package com.hilmigndogdu.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.hilmigndogdu.quiz.databinding.ActivityMainBinding;
import com.hilmigndogdu.quiz.databinding.ActivityShowBinding;

public class ShowActivity extends AppCompatActivity {

    ActivityShowBinding binding;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sharedPreferences = getSharedPreferences("com.hilmigndogdu.quiz", Context.MODE_PRIVATE);
        String metin = sharedPreferences.getString("storedMessage","0");
        binding.metinView.setText(metin);

        Snackbar snackbar = Snackbar.make(binding.getRoot(),"Metin başarı ile kaydedildi",Snackbar.LENGTH_LONG);
        snackbar.show();

        String message = binding.metinView.getText().toString();

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SQLiteDatabase veritabani = ShowActivity.this.openOrCreateDatabase("Messages",MODE_PRIVATE,null);

                    veritabani.execSQL("CREATE TABLE IF NOT EXISTS messages(message VARCHAR)");
                    veritabani.execSQL("INSERT INTO messages(message) VALUES ('"+message+"')");

                    Toast.makeText(ShowActivity.this, "Kaydedildi", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        binding.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    SQLiteDatabase veritabani = ShowActivity.this.openOrCreateDatabase("Messages", MODE_PRIVATE, null);

                    Cursor cursor = veritabani.rawQuery("SELECT * FROM messages", null);

                    while(cursor.moveToFirst()) {
                        int messageIndex = cursor.getColumnIndex("message");
                        binding.mesajView.setText("Mesaj : " + cursor.getString(messageIndex));
                    }
                    cursor.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}