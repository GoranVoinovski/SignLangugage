package com.mkdingo.goran.signlangugage.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mkdingo.goran.signlangugage.R;
import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Goran on 1/19/2018.
 */

public class FragmentSlika extends Fragment {
    @BindView(R.id.img)
    VideoView pic;
    @BindView(R.id.img1)
    ImageView pic1;
    private Unbinder mUnbind;
    Sliki zborovi = new Sliki();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slika, null);
        mUnbind = ButterKnife.bind(this, view);

        zborovi.slika = getArguments().getInt("sliki");
        zborovi.tag = getArguments().getString("tag");
        pic.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

       if (zborovi.tag.equals("gif")){
           String path = "android.resource://" + getActivity().getPackageName() + "/" + zborovi.slika;
           pic.setVideoPath(path);
           pic.start();
        }

       if(zborovi.tag.equals("jpg")){
           Picasso.with(getActivity()).load(zborovi.slika).into(pic1);
           pic.setVisibility(View.GONE);
      }

        return view;
    }

}

