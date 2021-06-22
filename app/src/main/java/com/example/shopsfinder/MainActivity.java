package com.example.shopsfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Button showmap_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_nav_id);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_placeholder,new SearchFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                switch (item.getItemId())
                {
                    case R.id.search_menu_id:
                        selectedFragment=new SearchFragment();
                        break;
                    case R.id.addshop_menu_id:
                        selectedFragment=new AddShopFragment();
                        break;
//                    case R.id.save_menu_id:
//                        selectedFragment=new SaveShopFragment();
//                        break;
                    case R.id.account_menu_id:
                        selectedFragment=new AccountFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_placeholder,selectedFragment).commit();
                return true;
            }
        });

        showmap_btn=findViewById(R.id.btnshow_map_id);
        showmap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ShowMap.class));
            }
        });


    }
}