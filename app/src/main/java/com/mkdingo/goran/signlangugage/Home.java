package com.mkdingo.goran.signlangugage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
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
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mkdingo.goran.signlangugage.adapter.HomePagerAdapter;
import com.mkdingo.goran.signlangugage.adapter.RecyclerViewAdapter;
import com.mkdingo.goran.signlangugage.adapter.VPagerAdapter;
import com.mkdingo.goran.signlangugage.fragment.Azbuka;
import com.mkdingo.goran.signlangugage.fragment.LearnToSign;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.listener.OnRowClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public @BindView(R.id.vp)ViewPager vPage;
    @BindView(R.id.tablayout)TabLayout tabs;
    public User user;
    public int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ButterKnife.bind(this);


        user = com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences.getUser(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        setUpViewPager(vPage);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
            {

            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Излез").setMessage("Дали сакате да излезете од апликацијата")
                    .setPositiveButton("ДА", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("НЕ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        builder.create().show();
        }

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.logout) {
//            com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences.removeFavorites(this);
//           Intent intent = new Intent(Home.this,Najava.class);
//           startActivity(intent);
//           finish();
//
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.learn_to_sign) {
           vPage.setCurrentItem(0);
        }else if (id == R.id.azbuka) {
            vPage.setCurrentItem(1);
        } else if (id==R.id.promenaIme){
            Intent intent2 = new Intent(Home.this,Najava.class);
            startActivity(intent2);
            finish();
        }
        else if (id == R.id.about) {

            Intent intent = new Intent(Home.this,ZaNasActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick(R.id.brainster)
     public void Klik(View view){
               Intent i = new Intent();
                i.putExtra(Intent.EXTRA_TEXT, "");
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://brainster.co/"));
                startActivity(i);
    }


    private void setUpViewPager(ViewPager mojpager) {

        HomePagerAdapter adapter = new HomePagerAdapter(this.getSupportFragmentManager());
        adapter.dodadiFragment(new LearnToSign(),"Говори со знаци");
        adapter.dodadiFragment(new Azbuka(),"Азбука");
        mojpager.setAdapter(adapter);
    }


}
