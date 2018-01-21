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
    Zborovi zboroviModel = new Zborovi();
    ArrayList<Zborovi> zborovi = new ArrayList<>();

    public void addSliki(ArrayList<Integer> content){zboroviModel.contents = content;}


    public VPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putString("zbor", zborovi.get(position).text);
        args.putSerializable("sliki", zborovi.get(position).contents);
        args.putSerializable("bukci", zborovi.get(position).bukvi);
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
