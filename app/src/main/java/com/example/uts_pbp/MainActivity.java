package com.example.uts_pbp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton navigationBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.homeFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
                        break;
                    case R.id.activityCustomer:
                        Intent intent = new Intent(MainActivity.this, CustomerActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.activityLocation:
                        Intent i = new Intent(MainActivity.this, LocationActivity.class);
                        startActivity(i);
                        finish();
                        break;
                    case R.id.activityProfile:
                        Intent intent1 = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                }
                return true;
            }
        });
        //DATA BINDING

    }
}