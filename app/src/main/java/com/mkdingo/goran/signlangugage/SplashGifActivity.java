package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashGifActivity extends AppCompatActivity {

    @BindView(R.id.splashGif)ImageView gif;
    @BindView(R.id.textNazbor)TextView tekst;
    @BindView(R.id.next)Button prodolzi;
    int position = 0;
    Zborovi zbor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_gif);
        ButterKnife.bind(this);

            Intent intent = getIntent();
            if (intent.hasExtra("POSITION")){
                zbor = (Zborovi) intent.getSerializableExtra("EXTRA");
                position = intent.getIntExtra("POSITION",0);

                int Slika = R.raw.iam;
                Glide.with(this).load(Slika).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).crossFade().into(gif);
                tekst.setText("I AM");
            }

    }

    @OnClick(R.id.next)
    public void Prodolzi(){

      Intent intent = new Intent(SplashGifActivity.this,FragmentActivity.class);
      intent.putExtra("EXTRA",zbor);
      intent.putExtra("POSITION", position);
      startActivity(intent);
      finish();


    }
}
