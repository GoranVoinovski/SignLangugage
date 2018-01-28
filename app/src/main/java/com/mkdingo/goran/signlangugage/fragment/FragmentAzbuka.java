package com.mkdingo.goran.signlangugage.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.mkdingo.goran.signlangugage.FragmentActivity;
import com.mkdingo.goran.signlangugage.R;
import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.klasi.SlikiAzbuka;
import com.mkdingo.goran.signlangugage.klasi.StaticniSliki;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Goran on 1/19/2018.
 */

public class FragmentAzbuka extends Fragment {
    @BindView(R.id.bukva)
    TextView bukvaPrikaz;
    @BindView(R.id.img1)
    ImageView pic1;
    private Unbinder mUnbind;
    StaticniSliki sliki;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_azbuka, null);
        mUnbind = ButterKnife.bind(this, view);

        sliki = (StaticniSliki) getArguments().getSerializable("Slika");
        bukvaPrikaz.setText(sliki.bukva + "");
        Picasso.with(getActivity()).load(sliki.Slika.slika).centerInside().fit().into(pic1);

        return view;
    }

}

