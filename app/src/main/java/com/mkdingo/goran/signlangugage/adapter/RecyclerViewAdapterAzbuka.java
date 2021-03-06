package com.mkdingo.goran.signlangugage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mkdingo.goran.signlangugage.R;
import com.mkdingo.goran.signlangugage.klasi.SlikiAzbuka;
import com.mkdingo.goran.signlangugage.klasi.StaticniSliki;
import com.mkdingo.goran.signlangugage.listener.OnRowBuvkaClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Goran on 2/3/2018.
 */

public class RecyclerViewAdapterAzbuka extends RecyclerView.Adapter<RecyclerViewAdapterAzbuka.ViewHolder>{

    Context context;
    SlikiAzbuka azbuka = new SlikiAzbuka();

    OnRowBuvkaClickListener _OnRowClickListener;


    public RecyclerViewAdapterAzbuka(Context context, OnRowBuvkaClickListener _OnRowClickListener) {
        this.context = context;
        this._OnRowClickListener = _OnRowClickListener;
    }

    public void setItems(ArrayList<StaticniSliki> zborovi){

        this.azbuka.slikiBukvi = zborovi;
    }




    @Override
    public RecyclerViewAdapterAzbuka.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.zbor_layout3,parent,false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;



    }


    @Override
    public void onBindViewHolder(RecyclerViewAdapterAzbuka.ViewHolder holder, final int position) {

        final StaticniSliki model = azbuka.slikiBukvi.get(position);
        holder.text.setText(model.bukva + "");
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _OnRowClickListener.onRowClick(model,position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return azbuka.slikiBukvi.size();
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
