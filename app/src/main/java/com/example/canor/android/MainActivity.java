package com.example.canor.android;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.canor.android.fragment.articles.general.HomeFragment;
import com.example.canor.android.fragment.articles.general.NewsCategoriesFragment;
import com.example.canor.android.fragment.articles.general.NotifFragment;
import com.example.canor.android.fragment.articles.general.PromosCategoriesFragment;
import com.example.canor.android.fragment.articles.general.WishlistFragment;
import com.example.canor.android.fragment.category.CategoriesFragment;

/**
 * Created by Romain on 04/06/2017.
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static int orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getFragmentManager();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        orientation = getResources().getConfiguration().orientation;


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame
                        , new HomeFragment())
                .commit();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_accueil) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new HomeFragment())
                    .addToBackStack("")
                    .commit();
        } else if (id == R.id.nav_categories) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new CategoriesFragment())
                    .addToBackStack("")
                    .commit();
        } else if (id == R.id.nav_news) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new NewsCategoriesFragment())
                    .addToBackStack("")
                    .commit();
        } else if (id == R.id.nav_promos) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new PromosCategoriesFragment())
                    .addToBackStack("")
                    .commit();
        } else if (id == R.id.nav_wishlist) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new WishlistFragment())
                    .addToBackStack("")
                    .commit();
        } else if (id == R.id.nav_notif) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new NotifFragment())
                    .addToBackStack("")
                    .commit();
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public int getOrientation(){
        return orientation;
    }
}
