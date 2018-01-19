package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mkdingo.goran.signlangugage.adapter.VPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.vPager)ViewPager viewPager;
    VPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ButterKnife.bind(this);
        adapter = new VPagerAdapter(this.getSupportFragmentManager());




        viewPager.setAdapter(adapter);


    }
}
