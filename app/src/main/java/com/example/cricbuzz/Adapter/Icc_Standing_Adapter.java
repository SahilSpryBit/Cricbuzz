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
import com.example.cricbuzz.Model.values;
import com.example.cricbuzz.R;

public class Icc_Standing_Adapter extends RecyclerView.Adapter<Icc_Standing_Adapter.ViewHolder> {

    Context context;
    com.example.cricbuzz.Model.values[] values;

    public Icc_Standing_Adapter(Context context, com.example.cricbuzz.Model.values[] values) {
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.icc_rankings_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Icc_Standing_Adapter.ViewHolder holder, int position) {
        values data = values[position];

        holder.txtCountry.setVisibility(View.GONE);

        holder.txtRank.setText(data.getValue()[0]);

        Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + data.getValue()[1] + "/i.jpg", new LazyHeaders.Builder()
                .addHeader("X-RapidAPI-Key", MainActivity.apiKey)
                .build())).into(holder.imgProfile);

        holder.txtName.setText(data.getValue()[2]);

        holder.txtPoints.setText(data.getValue()[3]);


    }

    @Override
    public int getItemCount() {
        return values.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtCountry, txtPoints, txtRank;
        ImageView imgProfile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtCountry = itemView.findViewById(R.id.txtCountry);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            txtPoints = itemView.findViewById(R.id.txtPoints);
            txtRank = itemView.findViewById(R.id.txtRank);
        }
    }
}