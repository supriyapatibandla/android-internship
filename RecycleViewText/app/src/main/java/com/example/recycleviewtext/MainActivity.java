package com.example.recycleviewtext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycleview);
        int [] images = {R.drawable.a,R.drawable.b,R.drawable.c,
                R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
                R.drawable.h,R.drawable.i,R.drawable.j};
        String[] itemNames = {"Chicken Biryani","Chicken Lollipop", "Chicken Kebeb",
                "Fried Rice","Veg Biryani","Veg Pulav", "Paneer Masala Curry",
                "Special Noodles","Prawn Curry","Paneer Kulcha"};
        String[] itemPrices = {"200","250","100","350","200","150",
                "250","250","100","150"};
        rv.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter = new ItemAdapter(this,images,itemNames,itemPrices);
        rv.setAdapter(adapter);
    }

    public void Submit(View view) {
    }
}