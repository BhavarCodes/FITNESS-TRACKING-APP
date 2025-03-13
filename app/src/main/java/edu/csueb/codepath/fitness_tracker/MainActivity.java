package edu.csueb.codepath.fitness_tracker;

import static edu.csueb.codepath.fitness_tracker.R.id.action_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import edu.csueb.codepath.fitness_tracker.fragments.HomeFragment;
import edu.csueb.codepath.fitness_tracker.fragments.LearnFragment;
import edu.csueb.codepath.fitness_tracker.fragments.ProfileFragment;
import edu.csueb.codepath.fitness_tracker.fragments.TrackFragment;

/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity {

    final FragmentManager mFragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView mBottomNavigationView = findViewById(R.id.bottomNavigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                int id = item.getItemId();
                if (id == action_home) {
                    fragment = new HomeFragment();
                } else if (id == R.id.action_learn) {
                    fragment = new LearnFragment();
                } else if (id == R.id.action_track) {
                    fragment = new TrackFragment();
                } else if (id == R.id.action_profile) {
                    fragment = new ProfileFragment();
                }

                mFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        mBottomNavigationView.setSelectedItemId(action_home);
    }
}