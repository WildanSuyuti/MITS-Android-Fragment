package com.mits.kakaroto.fragment.fitur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mits.kakaroto.fragment.R;
import com.mits.kakaroto.fragment.model.Movie;

public class MainActivity extends AppCompatActivity {
    public static final int PAGE_HOME = 0, PAGE_FAVORITE = 1, PAGE_PROFILE = 2;
    public static final String EXTRAS_DATA = "data";

    private HomeFragment homeFragment;
    private FavoriteFragment favoriteFragment;
    private ProfileFragment profileFragment;
    private ActionBar actionBar;

    private ImageView imgHome;
    private ImageView imgFavorite;
    private ImageView imgProfile;

    public static Intent newInstance(Context context, Movie movie) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRAS_DATA, movie);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();

        imgHome = (ImageView) findViewById(R.id.img_home);
        imgFavorite = (ImageView) findViewById(R.id.img_favorite);
        imgProfile = (ImageView) findViewById(R.id.img_profile);

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

    public void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void setActionBarTitle(String text) {
        actionBar.setTitle(text);
    }

    public void setActivePage(int page) {
        imgProfile.setColorFilter(R.color.icons);
        imgHome.setColorFilter(R.color.icons);
        imgFavorite.setColorFilter(R.color.icons);

        if (page == PAGE_HOME) imgHome.setColorFilter(R.color.red);
        else if (page == PAGE_FAVORITE) imgFavorite.setColorFilter(R.color.red);
        else imgProfile.setColorFilter(R.color.red);
    }
}
