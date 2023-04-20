package com.example.cricbuzz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.cricbuzz.Fragment.playerDetails;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.matchInfo;
import com.example.cricbuzz.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MatchDetail_SquadAdapter extends RecyclerView.Adapter<MatchDetail_SquadAdapter.ViewHolder> {

    Context context;
    List<playerDetails> playerDetails;

    public MatchDetail_SquadAdapter(Context context, List<playerDetails> playerDetails ) {
        this.context = context;
        this.playerDetails = playerDetails;
    }

    @NonNull
    @Override
    public MatchDetail_SquadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_detail_squad_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchDetail_SquadAdapter.ViewHolder holder, int position) {

        com.example.cricbuzz.Fragment.playerDetails myData = playerDetails.get(position);

        if(myData.isSubstitute()){

            holder.main_view.setVisibility(View.GONE);
        }else{
            holder.name.setText(myData.getName());
            holder.role.setText(myData.getRole());

            Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + myData.getFaceImageId() + "/i.jpg",
                    new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imageView);

        }
    }

    @Override
    public int getItemCount() {
        return playerDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, role;
        CircleImageView imageView;
        LinearLayout main_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtName);
            role = itemView.findViewById(R.id.txtRole);
            imageView = itemView.findViewById(R.id.imgProfile);
            main_view = itemView.findViewById(R.id.main_view);
        }
    }
}
