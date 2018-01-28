package com.mkdingo.goran.signlangugage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mkdingo.goran.signlangugage.FragmentActivity;
import com.mkdingo.goran.signlangugage.R;
import com.mkdingo.goran.signlangugage.adapter.RecyclerViewAdapter;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.listener.OnRowClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Goran on 1/28/2018.
 */

public class LearnToSign extends Fragment{

    private Unbinder mUnbind;
    @BindView(R.id.MyRV)RecyclerView rv;
    RecyclerViewAdapter adapter;
    User user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_learntosign,null);
        mUnbind  =  ButterKnife.bind(this, view);

        user = com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences.getUser(getActivity());

        adapter = new RecyclerViewAdapter(getActivity(), new OnRowClickListener() {
            @Override
            public void onRowClick(Zborovi model, int position) {
                if (model.bukvi.size()>1){
                    Intent intent1 = new Intent(getActivity(), FragmentActivity.class);
                    intent1.putExtra("EXTRA",model);
                    intent1.putExtra("POSITION", position);
                    intent1.putExtra("FLAG", "FLAG");
                    startActivity(intent1);


                }else {

                    Intent intent = new Intent(getActivity(), FragmentActivity.class);
                    intent.putExtra("EXTRA",model);
                    intent.putExtra("POSITION", position);
                    startActivity(intent);}
            }
        });




        adapter.setItems(user.zborovi);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);


        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }
}
