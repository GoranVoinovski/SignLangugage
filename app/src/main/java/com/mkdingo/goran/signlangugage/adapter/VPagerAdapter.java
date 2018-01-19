package com.mkdingo.goran.signlangugage.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mkdingo.goran.signlangugage.fragment.FragmentSlika;
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
        Bundle args = new Bundle();
        args.putString("zbor", zborovi.get(position).getText());
        args.putSerializable("sliki", zborovi.get(position).getContents());
        args.putSerializable("bukci", zborovi.get(position).getBukvi());
        args.putInt("pozicija",position);
        FragmentSlika fragment = new FragmentSlika();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return zborovi.size();
    }
}
