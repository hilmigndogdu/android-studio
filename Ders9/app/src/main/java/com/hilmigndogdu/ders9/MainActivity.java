package com.hilmigndogdu.ders9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.hilmigndogdu.ders9.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<String> markalar;
    ArrayAdapter<String> adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        markalar = new ArrayList<>();

        markalar.add("Nike");
        markalar.add("Adidas");
        markalar.add("Puma");
        markalar.add("Defacto");
        markalar.add("Hummel");
        markalar.add("Under Armour");
        markalar.add("Columbia");
        markalar.add("Versace");
        markalar.add("Sketcher");
        markalar.add("Nike");
        markalar.add("Adidas");
        markalar.add("Puma");
        markalar.add("Defacto");
        markalar.add("Hummel");
        markalar.add("Under Armour");
        markalar.add("Columbia");
        markalar.add("Versace");
        markalar.add("Sketcher");

        //Bağlam -->
        adaptor = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,markalar);

        binding.listView.setAdapter(adaptor);

        binding.listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Seçilen Öge" + markalar.get(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}