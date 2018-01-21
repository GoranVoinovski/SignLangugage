package com.mkdingo.goran.signlangugage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mkdingo.goran.signlangugage.R;
import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Goran on 1/19/2018.
 */

public class FragmentSlika extends Fragment {
    @BindView(R.id.img)
    ImageView pic;
    private Unbinder mUnbind;
    Sliki zborovi = new Sliki();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slika, null);
        mUnbind = ButterKnife.bind(this, view);

        zborovi.slika = getArguments().getInt("sliki");
        Picasso.with(getActivity()).load(zborovi.slika).into(pic);
        return view;
    }
}
