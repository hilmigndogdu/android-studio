package com.gazi.tekfak.ayberk.beltek71recyclerview;

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

public class SehirAdapter extends RecyclerView.Adapter<SehirAdapter.CardViewNesneTututucu>{

    private Context mContext;
    private List<Sehirler> sehirlerList;

    public SehirAdapter(Context mContext, List<Sehirler> sehirlerList) {
        this.mContext = mContext;
        this.sehirlerList = sehirlerList;
    }



    public class CardViewNesneTututucu extends RecyclerView.ViewHolder{

        public ImageView sehirImg;
        public TextView sehirName;
        public TextView ulkeName;
        public Button seyahatBtn;

        public CardViewNesneTututucu(@NonNull View itemView) {
            super(itemView);

            sehirImg = itemView.findViewById(R.id.ulke_img);
            sehirName = itemView.findViewById(R.id.sehirTxt);
            ulkeName = itemView.findViewById(R.id.ulkeTxt);
            seyahatBtn = itemView.findViewById(R.id.travelBtn);

        }
    }

    @NonNull
    @Override
    public CardViewNesneTututucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_design, parent, false);
        return new CardViewNesneTututucu(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull CardViewNesneTututucu holder, int position) {
        Sehirler sehir = sehirlerList.get(position);
        holder.sehirName.setText(sehir.getSehir_adi());
        holder.ulkeName.setText(sehir.getUlke_adi());
        holder.sehirImg.setImageResource(mContext.getResources()
                .getIdentifier(sehir.getResim_adi(),"drawable", mContext.getPackageName()));

        holder.seyahatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Seçilen Şehir: " + sehir.getSehir_adi(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return sehirlerList.size();
    }

}
