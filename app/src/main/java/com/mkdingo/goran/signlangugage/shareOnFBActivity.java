package com.mkdingo.goran.signlangugage;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class shareOnFBActivity extends AppCompatActivity {

    @BindView(R.id.textSoIme)TextView imeSoTekst;
    @BindView(R.id.slideshow)ImageView slajdSliki;
    User user;
    Timer myTimer;
    Zborovi zbor;
    Sliki slika;
    int count = 0;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_on_fb);

        ButterKnife.bind(this);
        mHandler = new Handler();
        myTimer = new Timer();

        user = SharedPreferences.getUser(this);
        zbor = user.zborovi.get(0);

        imeSoTekst.setText("I am " + user.name);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        slika = zbor.contents.get(count++);
                        slajdSliki.setImageResource(slika.slika);
                        if (count >= zbor.contents.size()){
                            count = 0;
                        }
                    }
                });
            }
        }, 0, 2000);

    }
}
