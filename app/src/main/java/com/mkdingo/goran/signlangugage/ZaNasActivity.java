package com.mkdingo.goran.signlangugage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZaNasActivity extends AppCompatActivity {
    @BindView(R.id.progrmer1)RelativeLayout programerInfo1;
    @BindView(R.id.progrmer2)RelativeLayout programerInfo2;
    @BindView(R.id.progrmer3)RelativeLayout programerInfo3;
    @BindView(R.id.progrmer4)RelativeLayout programerInfo4;
    @BindView(R.id.slika1)ImageView programerSlika1;
    @BindView(R.id.slika2)ImageView programerSlika2;
    @BindView(R.id.slika3)ImageView ProgramerSlika3;
    @BindView(R.id.slika4)ImageView ProgramerSlika4;
    @BindView(R.id.mail1)TextView programerMail1;
    @BindView(R.id.mail2)TextView programerMail2;
    @BindView(R.id.mail3)TextView ProgramerMail3;
    @BindView(R.id.mail4)TextView ProgramerMail4;
    @BindView(R.id.linked1)TextView programerLinked1;
    @BindView(R.id.linked2)TextView programerLinked2;
    @BindView(R.id.linked3)TextView ProgramerLinked3;
    @BindView(R.id.linked4)TextView ProgramerLinked4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_za_nas);
        ButterKnife.bind(this);

    }
}
