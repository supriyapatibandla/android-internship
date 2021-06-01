package com.example.exampleintern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String n = getIntent().getStringExtra("Key");
        Toast.makeText(this, "Welcome "+n,
                Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Welcome "+n, Toast.LENGTH_SHORT).show();
    }
}