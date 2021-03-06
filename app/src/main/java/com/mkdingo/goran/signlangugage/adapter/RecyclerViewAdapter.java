package com.mkdingo.goran.signlangugage.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.mkdingo.goran.signlangugage.Home;
import com.mkdingo.goran.signlangugage.R;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.listener.OnRowClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by markodonovski on 1/19/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    Context context;
    User user;
    List<Zborovi> listazborovi = new ArrayList<>();
    LayoutInflater inflater;

    OnRowClickListener _OnRowClickListener;


    public RecyclerViewAdapter (Context context, OnRowClickListener _OnRowClickListener) {
        this.context = context;
        this._OnRowClickListener = _OnRowClickListener;
    }

    public void setItems(List<Zborovi> zborovi){

        this.listazborovi = zborovi;
    }




    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        inflater = LayoutInflater.from(context);
        ViewHolder view = new ViewHolder (inflater.inflate(R.layout.zbor_layout3,parent,false));;

        return view;
    }


    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {

        final Zborovi model = listazborovi.get(position);

        holder.text.setText((CharSequence)model.getText());
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _OnRowClickListener.onRowClick(model,position);

            }
        });

       }

    @Override
    public int getItemCount() {
        return listazborovi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text)
        TextView text;
        @BindView(R.id.layout3)
        RelativeLayout relative;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }






}
