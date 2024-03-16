package com.hilmigndogdu.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DirectAction;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.hilmigndogdu.sqliteproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Footbal",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS player (id INTEGER PRIMARY KEY, name VARCHAR, age INT)");


            //database.execSQL("INSERT INTO player (name, age) VALUES ('Messi',36)");
            database.execSQL("INSERT INTO player (name, age) VALUES ('Ronaldo',37)");
            //database.execSQL("INSERT INTO player (name, age) VALUES ('Neymar',35)");

            //database.execSQL("UPDATE player SET  age = 61 WHERE name = 'Messi'");
            //database.execSQL("UPDATE player SET  name = 'Hilmi' WHERE id = 3");

            //database.execSQL("DELETE FROM player WHERE id = 2");

            Cursor cursor = database.rawQuery("SELECT * FROM player",null);

            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");
            int idIndex = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                System.out.println("Name : " + cursor.getString(nameIndex));
                System.out.println("Age : " + cursor.getInt(ageIndex));
                System.out.println("Id : " + cursor.getInt(idIndex));
            }
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}