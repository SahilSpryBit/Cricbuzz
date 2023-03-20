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
import com.example.cricbuzz.Model.player;
import com.example.cricbuzz.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Browse_PlayersAdapter extends RecyclerView.Adapter<Browse_PlayersAdapter.ViewHolder> {

    Context context;
    player[] players;

    public Browse_PlayersAdapter(Context context, player[] players) {
        this.context = context;
        this.players = players;
    }

    @NonNull
    @Override
    public Browse_PlayersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.browse_player, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Browse_PlayersAdapter.ViewHolder holder, int position) {
        player data = players[position];

        Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c"+data.getFaceImageId()+"/i.jpg", new LazyHeaders.Builder()
                .addHeader("X-RapidAPI-Key", MainActivity.apiKey)
                .build())).into(holder.imgPlayer);

        holder.txtPlayerName.setText(data.getName());
        holder.txtPlayerNation.setText(data.getTeamName());
    }

    @Override
    public int getItemCount() {
        return players.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgPlayer;
        TextView txtPlayerName, txtPlayerNation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPlayer = itemView.findViewById(R.id.imgPlayer);
            txtPlayerName = itemView.findViewById(R.id.txtPlayerName);
            txtPlayerNation = itemView.findViewById(R.id.txtPlayerNation);
        }
    }
}