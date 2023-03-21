package com.example.cricbuzz.Fragment.ICC_Men;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

public class Men_BatterFragment extends Fragment {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    TextView txtTest, txtOdi, txtT20;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_men__batter, container, false);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = view.findViewById(R.id.recyclerView_batsmen);
        txtTest = view.findViewById(R.id.txtTest_batsmen);
        txtOdi = view.findViewById(R.id.txtOdi_batsmen);
        txtT20 = view.findViewById(R.id.txtT20_batsmen);

        txtTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtTest.setBackgroundColor(getContext().getResources().getColor(R.color.app_color));
                txtTest.setTextColor(getContext().getResources().getColor(R.color.white));

                txtOdi.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtT20.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtOdi.setTextColor(getContext().getResources().getColor(R.color.app_color));
                txtT20.setTextColor(getContext().getResources().getColor(R.color.app_color));

                /*ApiCall("test");*/

            }
        });

        txtOdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtOdi.setBackgroundColor(getContext().getResources().getColor(R.color.app_color));
                txtOdi.setTextColor(getContext().getResources().getColor(R.color.white));

                txtTest.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtT20.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtTest.setTextColor(getContext().getResources().getColor(R.color.app_color));
                txtT20.setTextColor(getContext().getResources().getColor(R.color.app_color));


                /*ApiCall("odi");*/

            }
        });

        txtT20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtT20.setBackgroundColor(getContext().getResources().getColor(R.color.app_color));
                txtT20.setTextColor(getContext().getResources().getColor(R.color.white));

                txtOdi.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtTest.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtOdi.setTextColor(getContext().getResources().getColor(R.color.app_color));
                txtTest.setTextColor(getContext().getResources().getColor(R.color.app_color));

                /*ApiCall("t20");*/

            }
        });

        return view;
    }
}