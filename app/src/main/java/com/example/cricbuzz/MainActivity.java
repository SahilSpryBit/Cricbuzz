package com.example.cricbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.cricbuzz.Activity.SplashActivity;

public class MainActivity extends AppCompatActivity {

    public static final String apiKey = "73bd3e0f70msheb9bee176bc470ap142772jsn90fce50fcf15";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}