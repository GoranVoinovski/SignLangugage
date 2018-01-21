package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mkdingo.goran.signlangugage.adapter.VPagerAdapter;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.vPager)ViewPager viewPager;
    VPagerAdapter adapter;
    User user;
    Zborovi zborovi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ButterKnife.bind(this);
        user = SharedPreferences.getUser(this);
        adapter = new VPagerAdapter(this.getSupportFragmentManager());
        Intent intent = getIntent();
        zborovi = (Zborovi) intent.getSerializableExtra("EXTRA");


        adapter.addSliki(zborovi.contents);
        viewPager.setAdapter(adapter);


    }
}
