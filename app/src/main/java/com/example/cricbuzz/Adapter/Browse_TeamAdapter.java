package com.example.cricbuzz.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.list;
import com.example.cricbuzz.R;

public class Browse_TeamAdapter extends RecyclerView.Adapter<Browse_TeamAdapter.ViewHolder> {

    Context context;
    list[] lists;

    public Browse_TeamAdapter(Context context, list[] lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public Browse_TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.browse_team_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Browse_TeamAdapter.ViewHolder holder, int position) {

        list data = lists[position];

            holder.txtTeamName.setText(data.getTeamName() + "");

        Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c"+data.getImageId()+"/i.jpg",
                new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey)
                .build())).into(holder.imgFlag);

    }

    @Override
    public int getItemCount() {
        return lists.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTeamName;
        LinearLayout linearLayout;
        ImageView imgFlag, imgnotification;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTeamName = itemView.findViewById(R.id.txtTeamName);
            imgFlag = itemView.findViewById(R.id.imgFlag);
            imgnotification = itemView.findViewById(R.id.imgnotification);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
