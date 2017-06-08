package com.example.canor.android;

import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.canor.android.fragment.SettingsFragment;
import com.example.canor.android.fragment.articles.general.HomeFragment;
import com.example.canor.android.fragment.articles.general.NewsCategoriesFragment;
import com.example.canor.android.fragment.articles.general.NotifFragment;
import com.example.canor.android.fragment.articles.general.PromosCategoriesFragment;
import com.example.canor.android.fragment.articles.general.WishlistFragment;
import com.example.canor.android.fragment.category.CategoriesFragment;
import com.example.canor.android.model.Article;
import com.example.canor.android.model.Preferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static int orientation;
    List<com.example.canor.android.model.Notification> notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getFragmentManager();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Preferences.createPrefInit();
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



        //TODO
        notifications = new ArrayList<>();
        notifications.add(new com.example.canor.android.model.Notification(new Article("", "Plates Coutures - Matmatah", "", "", "Nouveauté 2017!", "", "", "", "", "", "", ""), "name"));
        notifications.add(new com.example.canor.android.model.Notification(new Article("", "Evènement!", "", "", "Venez rencontrer Alexandre Astier jeudi midi!", "", "", "", "", "", "", ""), "name"));
        notifications.add(new com.example.canor.android.model.Notification(new Article("", "Puissance 4", "", "", "Promo sur le jeu incontournable!", "", "", "", "", "", "", ""), "name"));
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notif) {
            if(SettingsFragment.getIsNotif()==true) {
                createNotification(notifications);
                com.example.canor.android.model.Notification.updateNotif(notifications);
            }
            else{
                Toast.makeText(getBaseContext(),"Activez les notifications!",
                        Toast.LENGTH_SHORT).show();
            }
        }

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
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new SettingsFragment())
                    .addToBackStack("")
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public int getOrientation() {
        return orientation;
    }

    private final void createNotification(List<com.example.canor.android.model.Notification> notifications) {
        int i = 0;
        for (com.example.canor.android.model.Notification n : notifications) {
            NotificationManager mNotification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Intent mainActivity = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mainActivity, PendingIntent.FLAG_ONE_SHOT);
            android.app.Notification.Builder builder = new android.app.Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle(n.getArticle().getTitle())
                    .setSmallIcon(R.drawable.ic_shopping_cart)
                    .setContentText(n.getArticle().getDescription())
                    .setContentIntent(pendingIntent);
            mNotification.notify(i, builder.build());
            i++;
        }
    }

}
