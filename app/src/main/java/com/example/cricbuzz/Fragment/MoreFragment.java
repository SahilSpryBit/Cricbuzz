package com.example.cricbuzz.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cricbuzz.Activity.Browse_Player_Activity;
import com.example.cricbuzz.Activity.Browse_Series_Activity;
import com.example.cricbuzz.Activity.Browse_Team_Activity;
import com.example.cricbuzz.R;
public class MoreFragment extends Fragment {

    TextView browse_series, browse_team, browse_player;
    public MoreFragment() {
        // Required empty public constructor
    }
    public static MoreFragment newInstance() {
        MoreFragment fragment = new MoreFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        Toolbar myToolbar = view.findViewById(R.id.my_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolbar);

        browse_series = view.findViewById(R.id.browse_series);
        browse_team = view.findViewById(R.id.browse_team);
        browse_player = view.findViewById(R.id.browse_player);

        browse_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Browse_Series_Activity.class);
                startActivity(intent);
            }
        });

        browse_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Browse_Team_Activity.class);
                startActivity(intent);

            }
        });

        browse_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Browse_Player_Activity.class);
                startActivity(intent);

            }
        });

        return view;
    }
}