package com.mkdingo.goran.signlangugage;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mkdingo.goran.signlangugage.adapter.VPagerAdapter;
import com.mkdingo.goran.signlangugage.adapter.VPagerAdapterAzbuka;
import com.mkdingo.goran.signlangugage.klasi.SlikiAzbuka;
import com.mkdingo.goran.signlangugage.klasi.StaticniSliki;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity {

    public @BindView(R.id.vPager)ViewPager viewPager;
    VPagerAdapter adapter;
    VPagerAdapterAzbuka adapterAzbuka;
    @BindView(R.id.textNazbor)
    TextView tekstodzbor;
    public @BindView(R.id.nextbtn)
    ImageButton nextbutton;
    @BindView(R.id.llBukvi)
    LinearLayout bukviLayout;
    public int pozicijaBukva = 0;
    TextView textView;
    int i = 0;
    int pozicijaGif = 0;
    public String start = "";
    StaticniSliki slikiAzbuka;
    SlikiAzbuka slikilista;
    public ArrayList<TextView>myTextViews;
    LinearLayout.LayoutParams params;
    User user;
    public Zborovi zborovi;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ButterKnife.bind(this);
        user = SharedPreferences.getUser(this);
        slikilista = SharedPreferences.getAzbuka(this);
        intent = getIntent();
        if (intent.hasExtra("EXTRA")){
            start = "start";
            zborovi = (Zborovi) intent.getSerializableExtra("EXTRA");
            final int pozicijaGif = intent.getIntExtra("POSITION",0);
            if (intent.hasExtra("FLAG")){
                Intent intent1 = new Intent(this,SplashGifActivity.class);
                intent1.putExtra("EXTRA",zborovi);
                intent1.putExtra("POSITION", pozicijaGif);
                startActivity(intent1);
                finish();
            }


            adapter = new VPagerAdapter(this.getSupportFragmentManager());

            viewPager.setCurrentItem(pozicijaBukva);

            if (zborovi.bukvi != null) {
                if (zborovi.bukvi.size()>1){
                    myTextViews = new ArrayList<>();
                    tekstodzbor.setVisibility(View.INVISIBLE);
                    for (Character c : zborovi.bukvi) {

                        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        textView = new TextView (this);
                        textView.setPadding(2,5,2,5);
                        textView.setLayoutParams(params);
                        textView.setText(c + "");
                        textView.setId(i);
                        bukviLayout.addView(textView);
                        myTextViews.add(textView);
                        i++;
                    }
                }else {
                    nextbutton.setVisibility(View.INVISIBLE);
                    tekstodzbor.setText(zborovi.text);
                }
            } else {
            }


            adapter.addSliki(zborovi.contents);
            viewPager.setAdapter(adapter);
            viewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {



                    return true;
                }
            });
        }else {

            adapterAzbuka = new VPagerAdapterAzbuka(getSupportFragmentManager());
            slikiAzbuka = (StaticniSliki) intent.getSerializableExtra("EXTRA2");
            int pozicijaBukva = intent.getIntExtra("POSITION2",0);
            slikiAzbuka = slikilista.slikiBukvi.get(pozicijaBukva);
            adapterAzbuka.addSliki(slikilista.slikiBukvi);
            viewPager.setAdapter(adapterAzbuka);
            viewPager.setCurrentItem(pozicijaBukva);

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent2 = new Intent(FragmentActivity.this,Home.class);
        if (intent.hasExtra("EXTRA2")){
            intent2.putExtra("Vrakanje2","Vrakanje2");
        }
        intent2.putExtra("Vrakanje","Vrakanje");
        startActivity(intent2);
        finish();
    }



}
