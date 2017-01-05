package com.mits.kakaroto.fragment.fitur;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.mits.kakaroto.fragment.R;
import com.mits.kakaroto.fragment.ScrollingActivity;
import com.mits.kakaroto.fragment.fitur.FavoriteFragment;
import com.mits.kakaroto.fragment.fitur.HomeFragment;
import com.mits.kakaroto.fragment.fitur.ProfileFragment;

public class NavDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final int PAGE_HOME = 0, PAGE_FAVORITE = 1, PAGE_PROFILE = 2;

    private HomeFragment homeFragment;
    private FavoriteFragment favoriteFragment;
    private ProfileFragment profileFragment;
    private ActionBar actionBar;

    private ImageView imgHome;
    private ImageView imgFavorite;
    private ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            finish();
        } else if(id == R.id.action_scroll){
            startActivity(new Intent(this, ScrollingActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home)
            openFragment(homeFragment);
        else if (id == R.id.nav_favorite)
            openFragment(favoriteFragment);
        else if (id == R.id.nav_profil)
            openFragment(profileFragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
        imgHome.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        imgFavorite.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        imgProfile.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        if (page == PAGE_HOME) {
            imgHome.setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        } else if (page == PAGE_FAVORITE) {
            imgFavorite.setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        } else {
            imgProfile.setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        }
    }
}
