package com.mkdingo.goran.signlangugage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Goran on 1/28/2018.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmenti = new ArrayList<Fragment>();
    ArrayList<String> titles = new ArrayList<String>();


    public void dodadiFragment (Fragment fragment, String title){
        titles.add(title);
        fragmenti.add(fragment);

    }

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmenti.get(position);
    }

    @Override
    public int getCount() {
        return fragmenti.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {return titles.get(position);}
}
