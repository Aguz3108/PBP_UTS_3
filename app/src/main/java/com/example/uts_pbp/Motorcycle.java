package com.example.uts_pbp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp.Adapter.MotorcycleDetails;

import java.util.ArrayList;

//DATA BINDING

public class Motorcycle extends AppCompatActivity {
    private ArrayList<Motor> ListMotor;
    private RecyclerView recyclerView;
    private MotorcycleDetails adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SearchView search;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorcycle);

        ListMotor = new DaftarMotor().MOTOR;
        recyclerView = findViewById(R.id.recycler_view_motor);
        adapter = new MotorcycleDetails(Motorcycle.this, ListMotor);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        backButton = findViewById(R.id.btnBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        search = (SearchView) findViewById(R.id.search);


    }


}