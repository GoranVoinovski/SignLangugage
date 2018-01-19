package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mkdingo.goran.signlangugage.klasi.Content;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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


    @OnClick(R.id.save)
    public void SaveUser(){
        Zborovi zbor1 = new Zborovi();
        zbor1.contents = new ArrayList<>();
        zbor1.text = "Hello";
        Content content1 = new Content();
        content1.Slika = R.raw.yellow;
        zbor1.contents.add(content1);


        User user = new User();
        user.zborovi = new ArrayList<>();
        user.zborovi.add(zbor1);
        user.name = userName.getText().toString();
        SharedPreferences.addUser(user,Najava.this);
        Intent intent = new Intent(Najava.this, Home.class);
        startActivity(intent);

    }
}
