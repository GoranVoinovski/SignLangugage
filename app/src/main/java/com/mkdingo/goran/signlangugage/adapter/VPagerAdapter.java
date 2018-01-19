package com.mkdingo.goran.signlangugage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mkdingo.goran.signlangugage.klasi.Zborovi;

import java.util.ArrayList;

/**
 * Created by Goran on 1/19/2018.
 */

public class VPagerAdapter extends FragmentPagerAdapter{

    ArrayList<Zborovi> zborovi;

    public void addSliki(ArrayList<Zborovi> zbor){zborovi = zbor;}


    public VPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
