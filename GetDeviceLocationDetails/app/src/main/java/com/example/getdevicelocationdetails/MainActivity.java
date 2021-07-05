package com.example.getdevicelocationdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    FusedLocationProviderClient locationProviderClient;
    private Object Manifest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textview);
        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    public void getDeviceLocation(View view){
        if(ActivityCompat.checkSelfPermission(this, Manifest, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED);
        return;
    }

}