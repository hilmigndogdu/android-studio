package com.gazi.tekfak.ayberk.beltek71recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.gazi.tekfak.ayberk.beltek71recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ArrayList<Sehirler> sehirlerArrayList;
    private SehirAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.sehirlerRv.setHasFixedSize(true);
        binding.sehirlerRv.setLayoutManager(new LinearLayoutManager(this));
        //rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        Sehirler barcelona = new Sehirler("Barcelona", "Spain", "barcelona");
        Sehirler madrid = new Sehirler("Madrid", "Spain", "madrid");
        Sehirler milano = new Sehirler("Milano", "Italy", "milano");
        Sehirler palermo = new Sehirler("Palermo", "Italy", "palermo");
        Sehirler burdur = new Sehirler("Burdur", "Turkey", "burdur");
        Sehirler ankara = new Sehirler("Ankara", "Turkey", "ankara");
        Sehirler amsterdam = new Sehirler("Amsterdam", "Netherlands", "amsterdam");
        Sehirler paris = new Sehirler("Paris", "France", "paris");
        Sehirler marsilya = new Sehirler("Marseille", "France", "marsilya");

        sehirlerArrayList = new ArrayList<>();
        sehirlerArrayList.add(barcelona);
        sehirlerArrayList.add(madrid);
        sehirlerArrayList.add(milano);
        sehirlerArrayList.add(palermo);
        sehirlerArrayList.add(burdur);
        sehirlerArrayList.add(ankara);
        sehirlerArrayList.add(amsterdam);
        sehirlerArrayList.add(paris);
        sehirlerArrayList.add(marsilya);

        adapter = new SehirAdapter(this,sehirlerArrayList);
        binding.sehirlerRv.setAdapter(adapter);

    }
}