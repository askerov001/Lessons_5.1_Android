package com.example.lessons_5_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.lessons_5_android.databinding.ActivityMainBinding;
import com.example.lessons_5_android.fragments.DashFragment;
import com.example.lessons_5_android.fragments.HomeFragment;
import com.example.lessons_5_android.fragments.NotifFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private HomeFragment homeFragment = new HomeFragment();
    private DashFragment dashFragment = new DashFragment();
    private NotifFragment notifFragment = new NotifFragment();

    private FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment active = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.bottomNav.setOnNavigationItemSelectedListener(listener);

        fragmentManager.beginTransaction().add(R.id.fm_container,notifFragment,"notif").hide(notifFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fm_container,dashFragment,"Dash").hide(notifFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fm_container,homeFragment).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            item -> {
                switch (item.getItemId()){
                    case R.id.home_fragment:
                        fragmentManager.beginTransaction()
                                .setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
                                .hide(active).show(homeFragment).commit();
                        active = homeFragment;

                        return true;
                    case R.id.dashboard_fragment:
                        fragmentManager.beginTransaction().
                                hide(active).show(dashFragment).commit();
                        active = dashFragment;

                        return true;
                    case R.id.notification_fragment:
                        fragmentManager.beginTransaction()
                                .setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
                                .hide(active).show(notifFragment).commit();
                        active = notifFragment;
                }

                return false;
            };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId () == R.id.setting){
            startActivity(new Intent(MainActivity.this, SettingActivity.class));

        };
        return super.onOptionsItemSelected(item);
    }

    public void hideBottomNav(){
        binding.bottomNav.setVisibility(View.GONE);
    }

    public void hideToolbar(){
        binding.toolbar.setVisibility(View.GONE);
    }

}