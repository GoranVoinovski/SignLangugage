package com.mkdingo.goran.signlangugage.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mkdingo.goran.signlangugage.fragment.FragmentAzbuka;
import com.mkdingo.goran.signlangugage.klasi.SlikiAzbuka;
import com.mkdingo.goran.signlangugage.klasi.StaticniSliki;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 * Created by Goran on 2/3/2018.
 */


public class VPagerAdapterAzbuka extends FragmentPagerAdapter {
    SlikiAzbuka azbuka = new SlikiAzbuka();


    public void addSliki(ArrayList<StaticniSliki> content){azbuka.slikiBukvi = content;}


    public VPagerAdapterAzbuka(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putSerializable("Slika", azbuka.slikiBukvi.get(position));
        args.putSerializable("Bukva", azbuka.slikiBukvi.get(position).bukva);
        args.putInt("pozicija",position);
        FragmentAzbuka fragment = new FragmentAzbuka();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {return azbuka.slikiBukvi.size();}
}
