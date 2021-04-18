package com.example.miscontactosintens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class AcercaDE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_de);
        Toolbar miBar= findViewById(R.id.miActionBar2);
        setSupportActionBar(miBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}