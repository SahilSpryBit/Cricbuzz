package com.example.cricbuzz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricbuzz.Model.seriesMapProto;
import com.example.cricbuzz.R;

public class Browse_SeriesAdapter extends RecyclerView.Adapter<Browse_SeriesAdapter.ViwHolder> {

    Context context;
    seriesMapProto[] seriesMapProto;

    public Browse_SeriesAdapter(Context context, com.example.cricbuzz.Model.seriesMapProto[] seriesMapProto) {
        this.context = context;
        this.seriesMapProto = seriesMapProto;
    }

    @NonNull
    @Override
    public Browse_SeriesAdapter.ViwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.browse_layout, parent, false);
        return new ViwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Browse_SeriesAdapter.ViwHolder holder, int position) {

        seriesMapProto data = seriesMapProto[position];
        holder.txtMonthYear.setText(data.getDate()+"");
        holder.txtSeriesName.setText(data.getSeries().get(0).getName() + "");

    }

    @Override
    public int getItemCount() {
        return seriesMapProto.length;
    }

    public class ViwHolder extends RecyclerView.ViewHolder {

        TextView txtMonthYear, txtSeriesName;
        public ViwHolder(@NonNull View itemView) {
            super(itemView);

            txtMonthYear = itemView.findViewById(R.id.txtMonthYear);
            txtSeriesName = itemView.findViewById(R.id.txtSeriesName);
        }
    }
}
