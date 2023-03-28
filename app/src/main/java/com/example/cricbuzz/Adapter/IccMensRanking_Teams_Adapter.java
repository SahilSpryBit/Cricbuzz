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

public class IccMensRanking_Teams_Adapter extends RecyclerView.Adapter<IccMensRanking_Teams_Adapter.ViewHolder> {

    Context context;
    List<rank> ranks;

    public IccMensRanking_Teams_Adapter(Context context, List<rank> ranks) {
        this.context = context;
        this.ranks = ranks;
    }

    @NonNull
    @Override
    public IccMensRanking_Teams_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.icc_rankings_layout, parent, false);
        return new IccMensRanking_Teams_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IccMensRanking_Teams_Adapter.ViewHolder holder, int position) {

        rank data = ranks.get(position);

        holder.txtRank.setText(data.getRank()+"");
        holder.txtName.setText(data.getName());
        holder.txtCountry.setText(data.getCountry());
        holder.txtPoints.setText(data.getPoints()+"");

        holder.imgProfile.setVisibility(View.GONE);
        holder.imgProfile_team.setVisibility(View.VISIBLE);
        holder.trend.setVisibility(View.GONE);


        if(data.getCountry() == null){
            holder.txtCountry.setVisibility(View.GONE);
        }

        if(data.getImageId() == null) {
            Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + data.getFaceImageId() + "/i.jpg", new LazyHeaders.Builder()
                    .addHeader("X-RapidAPI-Key", MainActivity.apiKey)
                    .build())).into(holder.imgProfile_team);
        }
        else{
            holder.imgProfile.getLayoutParams().width = 100;
            Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + data.getImageId() + "/i.jpg", new LazyHeaders.Builder()
                    .addHeader("X-RapidAPI-Key", MainActivity.apiKey)
                    .build())).into(holder.imgProfile_team);
        }

    }

    @Override
    public int getItemCount() {
        return ranks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRank, txtName, txtCountry, txtPoints;
        CircleImageView imgProfile;
        ImageView trend, imgProfile_team;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtRank = itemView.findViewById(R.id.txtRank);
            txtName = itemView.findViewById(R.id.txtName);
            txtCountry = itemView.findViewById(R.id.txtCountry);
            txtPoints = itemView.findViewById(R.id.txtPoints);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            imgProfile_team = itemView.findViewById(R.id.imgProfile_team);
            trend = itemView.findViewById(R.id.trend);
        }
    }
}