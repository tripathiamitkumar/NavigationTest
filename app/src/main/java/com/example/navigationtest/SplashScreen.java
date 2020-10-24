package com.example.navigationtest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationtest.util.CsvDataSetup;

public class SplashScreen extends AppCompatActivity {

    CsvDataSetup csvDataSetup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        csvDataSetup = new CsvDataSetup(this);
        csvDataSetup.setUpCsvFile();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
