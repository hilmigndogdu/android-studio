package com.hilmigndogdu.apptravel;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.hilmigndogdu.apptravel.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private ArrayList<Cities> citiesArrayList;
    private CityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.citiesRv.setHasFixedSize(true);
        binding.citiesRv.setLayoutManager(new LinearLayoutManager(this));

        Cities barcelona = new Cities("Barcelona", "Spain", "barcelona");
        Cities rio = new Cities("Rio", "Brazil", "rio");
        Cities milano = new Cities("Milano", "Italy", "milano");
        Cities karaman = new Cities("Karaman", "Turkey", "karaman");
        Cities ankara = new Cities("Ankara", "Turkey", "ankara");
        Cities amsterdam = new Cities("Amsterdam", "Netherlands", "amsterdam");
        Cities paris = new Cities("Paris", "France", "paris");

        citiesArrayList = new ArrayList<>();

        citiesArrayList.add(barcelona);
        citiesArrayList.add(rio);
        citiesArrayList.add(milano);
        citiesArrayList.add(karaman);
        citiesArrayList.add(ankara);
        citiesArrayList.add(amsterdam);
        citiesArrayList.add(paris);

        adapter = new CityAdapter(this,citiesArrayList);
        binding.citiesRv.setAdapter(adapter);


    }
}