package com.hilmigndogdu.artbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.hilmigndogdu.artbook.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }


    // Menüyü bağla
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    // Menü öğelerinin seçimlerini işle
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Öğe ID'sine göre işlemleri yap
        if (id == R.id.addTravel) {
            // Ayarlar öğesi seçildiğinde yapılacak işlemler
            return true;
        } else if (id == R.id.deleteTravel) {
            // Hakkında öğesi seçildiğinde yapılacak işlemler
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}