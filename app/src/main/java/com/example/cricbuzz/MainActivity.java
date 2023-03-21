package com.example.cricbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.cricbuzz.Activity.SplashActivity;

public class MainActivity extends AppCompatActivity {

    public static final String apiKey = "5d510530d1msh0eaab1fe046fb56p1245a2jsn50955b0b9800";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}