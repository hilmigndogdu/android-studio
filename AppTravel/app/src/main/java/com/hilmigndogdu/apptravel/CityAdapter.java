package com.hilmigndogdu.apptravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ObjectHolder> {

    private Context context;

    private List<Cities> citiesList;

    public CityAdapter(Context context, List<Cities> citiesList){
        this.context = context;
        this.citiesList = citiesList;
    }

    public class ObjectHolder extends RecyclerView.ViewHolder{

        public ImageView cityImg;

        public TextView cityName;
        public TextView countryName;
        public Button selectBtn;

        public ObjectHolder(@NonNull View itemView) {
            super(itemView);

            cityImg = itemView.findViewById(R.id.countryimg);
            cityName = itemView.findViewById(R.id.cityTxt);
            countryName = itemView.findViewById(R.id.countryTxt);
            selectBtn = itemView.findViewById(R.id.selectBtn);
        }
    }

    @NonNull
    @Override
    public ObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_design, parent, false);

        return new ObjectHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ObjectHolder holder, int position) {
        Cities city = citiesList.get(position);

        holder.cityName.setText(city.getCityName());
        holder.countryName.setText(city.getCountryName());
        holder.cityImg.setImageResource(context.getResources()
                .getIdentifier(city.getImageName(),"drawable", context.getPackageName()));


        holder.selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "SELECTED CITY : " + city.getCityName(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public int getItemCount() {

        return citiesList.size();
    }



}
