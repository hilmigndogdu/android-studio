package com.hilmigndogdu.quiz;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.hilmigndogdu.quiz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Intent intent;
    SharedPreferences sharedPreferences;
    ActivityResultLauncher<Intent> activityResultLauncher;
    ActivityResultLauncher<String> permissionLauncher;
    Bitmap secilenfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LauncherKaydet();

        permissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean o) {

                if (o){
                    Intent intentToGaleri = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activityResultLauncher.launch(intentToGaleri);
                }else {
                    Toast.makeText(MainActivity.this,"Galeriye Gitmek İçin Izin Gerekli",Toast.LENGTH_SHORT).show();
                }

            }
        });
        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                        Snackbar.make(v,"Galeriye Erişim için İzin Vermeniz Gerekiyor",Snackbar.LENGTH_INDEFINITE).setAction("İzin Ver", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE);
                            }
                        }).show();
                    }
                    else {
                        permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE);
                    }
                }
                else {

                    Intent intentToGaleri = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activityResultLauncher.launch(intentToGaleri);

                }


            }
        });

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = binding.textEdt.getText().toString();

                sharedPreferences = getSharedPreferences("com.hilmigndogdu.quiz", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("storedMessage",message).apply();

                intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);


            }
        });

    }

    private void LauncherKaydet(){

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {

                if (o.getResultCode() == RESULT_OK){
                    Intent intentFromResult = o.getData();
                    if (intentFromResult != null){
                        Uri imagelocation = intentFromResult.getData();

                        try {
                            ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(),imagelocation);
                            secilenfoto = ImageDecoder.decodeBitmap(source);
                            binding.imageView.setImageBitmap(secilenfoto);
                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }
                }
            }
        });
    }

}