package com.hilmigndogdu.odev12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.hilmigndogdu.odev12.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    ActivityMainBinding binding;
    int count=0;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("com.hilmigndogdu.odev12",MODE_PRIVATE);

        binding.saveBtn.setEnabled(false);
        binding.stopBtn.setEnabled(false);

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        binding.stopBtn.setEnabled(true);
                        binding.startBtn.setEnabled(false);
                        binding.saveBtn.setEnabled(false);
                        binding.deleteBtn.setEnabled(false);
                        count++;
                        String countstring = String.valueOf(count);
                        binding.countTxt.setText(countstring);
                        handler.postDelayed(this,1000);
                    }
                };
                handler.postDelayed(runnable,1);
            }
        });

        binding.stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
                binding.startBtn.setEnabled(true);
                binding.saveBtn.setEnabled(true);
                binding.deleteBtn.setEnabled(true);
            }
        });

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit().putInt("storedData",count).apply();

                Toast.makeText(MainActivity.this, "Kaydedildi", Toast.LENGTH_SHORT).show();

            }
        });

        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setTitle("SİL");
                alert.setMessage("Silmek İstediğinize Emin Misin");
                alert.setCancelable(false);
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        count=0;
                        binding.countTxt.setText(""+count);
                        Toast.makeText(MainActivity.this,"Silindi",Toast.LENGTH_LONG).show();
                    }
                });

                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Silme İşlemi İptal Edildi",Toast.LENGTH_LONG).show();
                    }
                });
                alert.show();

            }
        });

        binding.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int storedData;


                storedData = sharedPreferences.getInt("storedData", 0);

                Toast.makeText(MainActivity.this, "Kaydedilen Değer: " + storedData, Toast.LENGTH_LONG).show();

            }

        });
    }
}