package com.mkdingo.goran.signlangugage.fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.mkdingo.goran.signlangugage.FragmentActivity;
import com.mkdingo.goran.signlangugage.R;
import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.shareOnFBActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Goran on 1/19/2018.
 */

public class FragmentSlika extends Fragment {
   public @BindView(R.id.img)
    VideoView pic;
    private Unbinder mUnbind;
    Sliki zborovi = new Sliki();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slika, null);
        mUnbind = ButterKnife.bind(this, view);

        zborovi.slika = getArguments().getInt("sliki");
        zborovi.tag = getArguments().getString("tag");

        if (((FragmentActivity)getActivity()).zborovi.bukvi.size() > 1){
            for (int i = 0; i < ((FragmentActivity)getActivity()).myTextViews.size(); i++) {
                if (i == ((FragmentActivity)getActivity()).pozicijaBukva){
                    ((FragmentActivity)getActivity()).myTextViews.get(i).setTextColor(getResources().getColor(android.R.color.white));
                    ((FragmentActivity)getActivity()).myTextViews.get(i).setTextSize(50);

                }else {
                    ((FragmentActivity)getActivity()).myTextViews.get(i).setTextColor(getResources().getColor(R.color.grey_700));
                    ((FragmentActivity)getActivity()).myTextViews.get(i).setTextSize(30);

                }
            }
        }


        String path = "android.resource://" + getActivity().getPackageName() + "/" + zborovi.slika;
        pic.setVideoPath(path);

        if (((FragmentActivity)getActivity()).start.equals("start")){
            pic.start();
            ((FragmentActivity)getActivity()).start = "";
        }

        ((FragmentActivity)getActivity()).nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pic.start();
                ((FragmentActivity)getActivity()).pozicijaBukva++;
                ((FragmentActivity)getActivity()).viewPager.setCurrentItem(((FragmentActivity)getActivity()).pozicijaBukva);
                for (int i = 0; i < ((FragmentActivity)getActivity()).myTextViews.size(); i++) {

                    if (i == ((FragmentActivity)getActivity()).pozicijaBukva){

                        ((FragmentActivity)getActivity()).myTextViews.get(i).setTextColor(getResources().getColor(android.R.color.white));
                        ((FragmentActivity)getActivity()).myTextViews.get(i).setTextSize(50);
                    }else {
                        ((FragmentActivity)getActivity()).myTextViews.get(i).setTextColor(getResources().getColor(R.color.grey_700));
                        ((FragmentActivity)getActivity()).myTextViews.get(i).setTextSize(30);
                    }
                }

                if (((FragmentActivity)getActivity()).pozicijaBukva == ((FragmentActivity)getActivity()).myTextViews.size()){
                    Intent intent1 = new Intent(getActivity(),shareOnFBActivity.class);
                    startActivity(intent1);
                    getActivity().finish();
                }
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }
    public boolean IsInView(Fragment fragment){

        boolean isInView = true;

        if (fragment.isInLayout()){

            isInView = true;

        }
        return isInView;
    }
}

