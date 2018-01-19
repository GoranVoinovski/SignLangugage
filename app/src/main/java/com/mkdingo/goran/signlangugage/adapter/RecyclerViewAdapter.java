package com.mkdingo.goran.signlangugage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.mkdingo.goran.signlangugage.R;
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
    List<Zborovi> listazborovi = new ArrayList<>();

    OnRowClickListener _OnRowClickListener;

    public void set_OnRowClickListener(OnRowClickListener _OnRowClickListener){
        this._OnRowClickListener = _OnRowClickListener;
    }





    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.zbor_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;



    }
    public RecyclerViewAdapter (Context context) {
        this.context = context;
    }

    public void setItems(List<Zborovi> zborovi){

        this.listazborovi = zborovi;
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
        @BindView(R.id.relative)
        RelativeLayout relative;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }






}
