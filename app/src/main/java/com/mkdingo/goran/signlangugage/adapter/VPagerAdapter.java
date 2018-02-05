package com.mkdingo.goran.signlangugage.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mkdingo.goran.signlangugage.fragment.FragmentSlika;
import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;

import java.util.ArrayList;

/**
 * Created by Goran on 1/19/2018.
 */

public class VPagerAdapter extends FragmentPagerAdapter{
    Zborovi zborovi = new Zborovi();

    public void addSliki(ArrayList<Sliki> content){zborovi.contents = content;}


    public VPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putSerializable("sliki", zborovi.contents.get(position).slika);
        args.putSerializable("tag", zborovi.contents.get(position).tag);
        args.putInt("pozicija",position);
        FragmentSlika fragment = new FragmentSlika();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {return zborovi.contents.size();}

    
}


