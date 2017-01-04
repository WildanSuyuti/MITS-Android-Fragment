package com.mits.kakaroto.fragment.fitur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mits.kakaroto.fragment.R;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private FavoriteFragment favoriteFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, homeFragment)
                .commit();
    }

    public void openHome(View view) {
        openFragment(homeFragment);
    }

    public void openFavorite(View view) {
        openFragment(favoriteFragment);
        getSupportActionBar().setTitle("Favorite");
    }

    public void openProfile(View view) {
        openFragment(profileFragment);
    }

    private void openFragment(android.support.v4.app.Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
