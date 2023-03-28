package com.example.cricbuzz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.rank;
import com.example.cricbuzz.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class IccMensRanking_Batsmen_Adapter extends RecyclerView.Adapter<IccMensRanking_Batsmen_Adapter.ViewHolder> {

    Context context;
    List<rank> ranks;

    public IccMensRanking_Batsmen_Adapter(Context context, List<rank> ranks) {
        this.context = context;
        this.ranks = ranks;
    }

    @NonNull
    @Override
    public IccMensRanking_Batsmen_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.icc_rankings_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IccMensRanking_Batsmen_Adapter.ViewHolder holder, int position) {

        rank data = ranks.get(position);

        holder.txtRank.setText(data.getRank()+"");
        holder.txtName.setText(data.getName());
        holder.txtCountry.setText(data.getCountry());
        holder.txtPoints.setText(data.getPoints()+"");

        if(data.getCountry() == null){
            holder.txtCountry.setVisibility(View.GONE);
        }

        if(data.getImageId() == null) {
            Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + data.getFaceImageId() + "/i.jpg", new LazyHeaders.Builder()
                    .addHeader("X-RapidAPI-Key", MainActivity.apiKey)
                    .build())).into(holder.imgProfile);
        }
        else{
            holder.imgProfile.getLayoutParams().width = 100;
            Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + data.getImageId() + "/i.jpg", new LazyHeaders.Builder()
                    .addHeader("X-RapidAPI-Key", MainActivity.apiKey)
                    .build())).into(holder.imgProfile);
        }

        if(!data.getTrend().isEmpty() && data.getTrend().equals("Up")){
            Glide.with(context).load(R.drawable.ic_up_arrow).into(holder.trend);
        } else if (!data.getTrend().isEmpty() && data.getTrend().equals("Down")) {
            Glide.with(context).load(R.drawable.ic_down_arrow).into(holder.trend);
        }else if (!data.getTrend().isEmpty() && data.getTrend().equals("Flat")) {
            Glide.with(context).load(R.drawable.ic_flat).into(holder.trend);
        }

    }

    @Override
    public int getItemCount() {
        return ranks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRank, txtName, txtCountry, txtPoints;
        CircleImageView imgProfile;
        ImageView trend;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtRank = itemView.findViewById(R.id.txtRank);
            txtName = itemView.findViewById(R.id.txtName);
            txtCountry = itemView.findViewById(R.id.txtCountry);
            txtPoints = itemView.findViewById(R.id.txtPoints);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            trend = itemView.findViewById(R.id.trend);
        }
    }
}
