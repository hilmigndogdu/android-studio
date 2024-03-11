package com.hilmigndogdu.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.hilmigndogdu.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    ArrayList<LandMark> landMarksArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        LandMark pisa = new LandMark("Pisa","Italy",R.drawable.images15);
        LandMark eiffel = new LandMark("Eiffel","France",R.drawable.images16);
        LandMark colosseum = new LandMark("Colosseum","Italy",R.drawable.images17);
        LandMark londonBridge = new LandMark("London Bridge","UK",R.drawable.images18);

        landMarksArrayList = new ArrayList<>();

        landMarksArrayList.add(pisa);
        landMarksArrayList.add(eiffel);
        landMarksArrayList.add(colosseum);
        landMarksArrayList.add(londonBridge);

        //Adapter
         //ListView

        //mapping
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landMarksArrayList.stream().map(landMark -> landMark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,landMarksArrayList.get(position).name,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landMarksArrayList.get(position));
                startActivity(intent);
            }
        });

    }
}