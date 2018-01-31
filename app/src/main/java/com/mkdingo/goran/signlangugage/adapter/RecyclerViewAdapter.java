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
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.zbor_layout3,parent,false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;



    }


    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {

        final Zborovi model = listazborovi.get(position);
            if(position == 0)
            {
                //holder.relative.setBackgroundColor(Color.parseColor("#01579B"));
                holder.text.setTextColor(Color.parseColor("#01579B"));
                holder.linija.setBackgroundColor(Color.parseColor("#01579B"));
    }
            else if (position == 1)
            {
                //holder.relative.setBackgroundColor(Color.parseColor("#1B5E20"));
                holder.text.setTextColor(Color.parseColor("#1B5E20"));
                holder.linija.setBackgroundColor(Color.parseColor("#1B5E20"));
            } else if (position == 2)
            {
                //holder.relative.setBackgroundColor(Color.parseColor("#F57F17"));
                holder.text.setTextColor(Color.parseColor("#F57F17"));
                holder.linija.setBackgroundColor(Color.parseColor("#F57F17"));

            }else if (position == 3)
            {
                //holder.relative.setBackgroundColor(Color.parseColor("#455A64"));
                holder.text.setTextColor(Color.parseColor("#455A64"));
                holder.linija.setBackgroundColor(Color.parseColor("#455A64"));
            }
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
        @BindView(R.id.crta)
        View linija;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }






}
