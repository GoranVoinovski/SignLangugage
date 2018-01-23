package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mkdingo.goran.signlangugage.adapter.VPagerAdapter;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.vPager)ViewPager viewPager;
    VPagerAdapter adapter;
    @BindView(R.id.textNazbor)
    TextView tekstodzbor;
    @BindView(R.id.prevbtn)
    Button previousbtn;
    @BindView(R.id.nextbtn)
    Button nextbutton;
    @BindView(R.id.llBukvi)
    LinearLayout bukviLayout;
    public int pozicijaBukva = 0;
    TextView textView;
    int i = 0;
    ArrayList<TextView>myTextViews;

    User user;
    public Zborovi zborovi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ButterKnife.bind(this);
        user = SharedPreferences.getUser(this);
        adapter = new VPagerAdapter(this.getSupportFragmentManager());
        Intent intent = getIntent();
        zborovi = (Zborovi) intent.getSerializableExtra("EXTRA");
        viewPager.setCurrentItem(pozicijaBukva);

        if (zborovi.bukvi != null) {

            myTextViews = new ArrayList<>();
            tekstodzbor.setVisibility(View.INVISIBLE);
            for (Character c : zborovi.bukvi) {

                textView = new TextView(this);
                textView.setText(c + "");
                textView.setId(i);
                textView.setHeight(150);
                textView.setWidth(150);
                textView.setTextSize(40);
                bukviLayout.addView(textView);
                myTextViews.add(textView);
                i++;

            }
        } else {
            tekstodzbor.setText(zborovi.text);

        }

        for (int i = 0; i < myTextViews.size(); i++) {

            if (i == pozicijaBukva){
                myTextViews.get(i).setTextColor(getResources().getColor(android.R.color.white));
            }else {
                myTextViews.get(i).setTextColor(getResources().getColor(android.R.color.black));
            }
        }

        adapter.addSliki(zborovi.contents);
        viewPager.setAdapter(adapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            pozicijaBukva++;
            viewPager.setCurrentItem(pozicijaBukva);
                for (int i = 0; i < myTextViews.size(); i++) {

                    if (i == pozicijaBukva){
                        myTextViews.get(i).setTextColor(getResources().getColor(android.R.color.white));
                    }else {
                        myTextViews.get(i).setTextColor(getResources().getColor(android.R.color.black));
                    }
                }
            }
        });


    }
}
