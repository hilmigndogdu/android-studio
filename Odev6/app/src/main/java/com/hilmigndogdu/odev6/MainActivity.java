package com.hilmigndogdu.odev6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int gorselKontrol = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Kullanılacak olan sınıfın bir nesnesini oluşturulur
        ImageView imageView = findViewById(R.id.image1);
        Button button = findViewById(R.id.button);

        //Button'a basıldığının kontrol edilmesi
        //Kontrol sonrasında resim değişikliği yapılması

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ilgili butona her tıklandığında çalışan fonksiyon

                if(gorselKontrol == 1){
                    // şu an image1 aktif

                    imageView.setImageDrawable(getDrawable(R.drawable.image2));
                    gorselKontrol= 2;
                } else if (gorselKontrol == 2) {
                    // şu an image2 aktif

                    imageView.setImageDrawable(getDrawable(R.drawable.image6));
                    gorselKontrol=6;
                } else if (gorselKontrol == 6) {
                    // şu an image6 aktif

                    imageView.setImageDrawable(getDrawable(R.drawable.image7));
                    gorselKontrol=7;
                }else if (gorselKontrol== 7){
                    //şu an image7 aktif

                    imageView.setImageDrawable(getDrawable(R.drawable.image1));
                    gorselKontrol=1;
                }
            }
        });
    }
}