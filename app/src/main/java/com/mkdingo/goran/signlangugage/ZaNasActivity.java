package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


import butterknife.OnClick;

public class ZaNasActivity extends AppCompatActivity {
    @BindView(R.id.progrmerb)RelativeLayout programerInfob;
    @BindView(R.id.progrmer1)RelativeLayout programerInfo1;
    @BindView(R.id.progrmer2)RelativeLayout programerInfo2;
    @BindView(R.id.progrmer3)RelativeLayout programerInfo3;
    @BindView(R.id.progrmer4)RelativeLayout programerInfo4;

    @BindView(R.id.slikab)ImageView programerSlikab;
    @BindView(R.id.slika1)ImageView programerSlika1;
    @BindView(R.id.slika2)ImageView programerSlika2;
    @BindView(R.id.slika3)ImageView ProgramerSlika3;
    @BindView(R.id.slika4)ImageView ProgramerSlika4;

    @BindView(R.id.textb)TextView ProgramerTextb;
    @BindView(R.id.text1)TextView ProgramerText1;
    @BindView(R.id.text2)TextView ProgramerText2;
    @BindView(R.id.text3)TextView ProgramerText3;
    @BindView(R.id.text4)TextView ProgramerText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_za_nas);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.textb)
    public void ClickB (View view){

        Intent i = new Intent();
        i.putExtra(Intent.EXTRA_TEXT, "");
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://brainster.co/"));
        startActivity(i);
        Toast.makeText(this, "dasdas", Toast.LENGTH_LONG).show();
    }
    @OnClick(R.id.text1)
    public void Click1 (View view){

        Intent i = new Intent();
        i.putExtra(Intent.EXTRA_TEXT, "");
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.linkedin.com/in/oliver-bozinovski"));
        startActivity(i);
        Toast.makeText(this, "dasdas", Toast.LENGTH_LONG).show();
    }
    @OnClick(R.id.text2)
    public void Click2 (View view){

        Intent i = new Intent();
        i.putExtra(Intent.EXTRA_TEXT, "");
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.linkedin.com/"));
        startActivity(i);
        Toast.makeText(this, "dasdas", Toast.LENGTH_LONG).show();
    }
    @OnClick(R.id.text3)
    public void Click3 (View view){

        Intent i = new Intent();
        i.putExtra(Intent.EXTRA_TEXT, "");
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.linkedin.com/"));
        startActivity(i);
        Toast.makeText(this, "dasdas", Toast.LENGTH_LONG).show();
    }
    @OnClick(R.id.text4)
    public void Click4 (View view){


        Intent i = new Intent();
        i.putExtra(Intent.EXTRA_TEXT, "");
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.linkedin.com/"));
        startActivity(i);
        Toast.makeText(this, "dasdas", Toast.LENGTH_LONG).show();
    }
}
