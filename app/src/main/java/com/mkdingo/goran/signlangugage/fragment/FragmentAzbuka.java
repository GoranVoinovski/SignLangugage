package com.mkdingo.goran.signlangugage.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
    VideoView pic1;
    private Unbinder mUnbind;
    StaticniSliki sliki;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_azbuka, null);
        mUnbind = ButterKnife.bind(this, view);

        sliki = (StaticniSliki) getArguments().getSerializable("Slika");
        bukvaPrikaz.setText(sliki.bukva + "");
        pic1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        String path = "android.resource://" + getActivity().getPackageName() + "/" + sliki.Slika.slika;
        pic1.setVideoPath(path);
        if (((FragmentActivity)getActivity()).start.equals("")){
            pic1.start();
            ((FragmentActivity)getActivity()).start = "new";
        }
        ((FragmentActivity)getActivity()).viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
              pic1.start();

                return false;
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

