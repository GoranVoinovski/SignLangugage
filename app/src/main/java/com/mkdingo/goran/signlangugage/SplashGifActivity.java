package com.mkdingo.goran.signlangugage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashGifActivity extends AppCompatActivity {

    @BindView(R.id.splashGif)VideoView gif;
    @BindView(R.id.textNazbor)TextView tekst;
    @BindView(R.id.next)Button prodolzi;
//    @BindView(R.id.rel_oli)RelativeLayout relativeLayout;
//    @BindView(R.id.text_learn_to_sign) TextView learn_to_sign;
//    @BindView(R.id.image_ime)TextView imageView;
//    @BindView(R.id.change_name)TextView change_name;
//    @BindView(R.id.button_continue)Button continue_button;
    User user;
    int position = 0;
    Zborovi zbor;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_gif);
        ButterKnife.bind(this);
        context = this;

//        change_name.setPaintFlags(change_name.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG   );
//
            Intent intent = getIntent();
            if (intent.hasExtra("POSITION")){
                zbor = (Zborovi) intent.getSerializableExtra("EXTRA");
                position = intent.getIntExtra("POSITION",0);}
//
//                relativeLayout.setVisibility(View.VISIBLE);
//                user = new User();
//                user = SharedPreferences.getUser(context);
//                imageView.setText("ЗДРАВО, ЈАС СУМ " + "\n" + user.name);
//                change_name.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent1 = new Intent(SplashGifActivity.this,Najava.class);
//                        startActivity(intent1);
//                    }
//                });
//                continue_button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        relativeLayout.setVisibility(View.INVISIBLE);
//                        prodolzi.setVisibility(View.VISIBLE);
//                        int Slika = R.raw.iamblue;
//                        Glide.with(SplashGifActivity.this).load(Slika).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).crossFade().into(gif);
//                        tekst.setText("ЈАС СУМ");
//                    }
//                });
//
//
//            }
//
       gif.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
           @Override
           public void onCompletion(MediaPlayer mp) {
               Intent intent = new Intent(SplashGifActivity.this,FragmentActivity.class);
               intent.putExtra("EXTRA",zbor);
               intent.putExtra("POSITION", position);
               intent.putExtra("Start","Start");
               startActivity(intent);
               finish();
           }
       });

        String path = "android.resource://" + this.getPackageName() + "/" + R.raw.jas_se_vikam;
        gif.setVideoPath(path);
        gif.start();
        tekst.setText("Јас се викам");
    }

    @OnClick(R.id.next)
    public void Prodolzi(){
        recreate();
    }
}
