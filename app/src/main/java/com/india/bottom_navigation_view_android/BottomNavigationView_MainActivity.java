package com.india.bottom_navigation_view_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.india.bottom_navigation_view_android.fragment_Files.Fragment_A;
import com.india.bottom_navigation_view_android.fragment_Files.Fragment_B;
import com.india.bottom_navigation_view_android.fragment_Files.Fragment_C;
import com.india.bottom_navigation_view_android.fragment_Files.Fragment_D;
import com.india.bottom_navigation_view_android.fragment_Files.Fragment_E;

public class BottomNavigationView_MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigation = findViewById(R.id.bottomNavigationView);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.item_home){
                    addFragments(new Fragment_A(),1);
                }else if (item.getItemId() == R.id.item_search){
                    addFragments(new Fragment_B(),1);
                }else if (item.getItemId() == R.id.item_settings){
                    addFragments(new Fragment_C(),1);
                }else if (item.getItemId() == R.id.item_contacts){
                    addFragments(new Fragment_D(),1);
                }else{
                    addFragments(new Fragment_E(),0);
                }

                return true;
            }
        });

        bottomNavigation.setSelectedItemId(R.id.item_location);  // to select any frament as default

    }

    public void addFragments(Fragment fragment, int flag){
        FragmentManager fManager = getSupportFragmentManager(); // for getting the fragment
        FragmentTransaction fTransaction = fManager.beginTransaction(); // for starting the fragment services
        if(flag == 0){
            fTransaction.add(R.id.frameLayout,fragment);
        }else{
            fTransaction.replace(R.id.frameLayout,fragment);
        }
        fTransaction.commit();
    }
}