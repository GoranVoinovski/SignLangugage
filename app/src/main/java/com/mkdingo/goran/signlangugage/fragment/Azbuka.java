package com.mkdingo.goran.signlangugage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.mkdingo.goran.signlangugage.R;
import com.mkdingo.goran.signlangugage.klasi.SlikiAzbuka;
import com.mkdingo.goran.signlangugage.klasi.StaticniSliki;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Goran on 1/28/2018.
 */

public class Azbuka extends Fragment {


    private Unbinder mUnbind;
    @BindView(R.id.spiner)Spinner spiner;
    @BindView(R.id.img1)
    ImageView pic1;

    User user;
    StaticniSliki slika;
    SlikiAzbuka staticniSliki;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_azbuka_spiner,null);
        mUnbind  =  ButterKnife.bind(this, view);

        staticniSliki = com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences.getAzbuka(getActivity());
        if (staticniSliki == null){
            staticniSliki = new SlikiAzbuka();
            if (staticniSliki.slikiBukvi == null){
                staticniSliki.slikiBukvi = new ArrayList<>();
            }
        }

        user = com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences.getUser(getActivity());

        ArrayAdapter<StaticniSliki> bukvi = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,staticniSliki.slikiBukvi);

        spiner.setAdapter(bukvi);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    slika = staticniSliki.slikiBukvi.get(position);
                    Picasso.with(getActivity()).load(slika.Slika.slika).centerInside().fit().into(pic1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }
}
