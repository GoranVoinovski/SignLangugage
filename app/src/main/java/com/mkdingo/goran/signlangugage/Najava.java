package com.mkdingo.goran.signlangugage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Najava extends AppCompatActivity {
    @BindView(R.id.edtname)EditText userName;
    @BindView(R.id.save)Button saveUser;
    @BindView(R.id.textView)TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_najava);
        ButterKnife.bind(this);

    }
}
