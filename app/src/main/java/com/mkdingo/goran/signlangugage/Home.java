package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mkdingo.goran.signlangugage.adapter.RecyclerViewAdapter;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.listener.OnRowClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.MyRV)RecyclerView rv;
    RecyclerViewAdapter adapter;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        user = com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences.getUser(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        adapter = new RecyclerViewAdapter(this, new OnRowClickListener() {
            @Override
            public void onRowClick(Zborovi model, int position) {
                if (model.bukvi.size()>1){
                    Intent intent1 = new Intent(Home.this, FragmentActivity.class);
                    intent1.putExtra("EXTRA",model);
                    intent1.putExtra("POSITION", position);
                    intent1.putExtra("FLAG", "FLAG");
                    startActivity(intent1);


                }else {

                    Intent intent = new Intent(Home.this, FragmentActivity.class);
                    intent.putExtra("EXTRA",model);
                    intent.putExtra("POSITION", position);
                    startActivity(intent);}
            }
        });




        adapter.setItems(user.zborovi);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

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
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.learn_to_sign) {
            // Handle the camera action
        } else if (id == R.id.about) {

        }

//        else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
