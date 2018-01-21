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
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_najava);
        ButterKnife.bind(this);
        user = FillClasses();


    }


    @OnClick(R.id.save)
    public void SaveUser(){

        user.name = userName.getText().toString();
        SharedPreferences.addUser(user,Najava.this);
        Intent intent = new Intent(Najava.this, Home.class);
        startActivity(intent);

    }

    public User FillClasses(){

        User user = new User();
        user.zborovi = new ArrayList<>();


        Zborovi zbor1 = new Zborovi();
        zbor1.contents = new ArrayList<>();
        zbor1.bukvi = new ArrayList<>();
        zbor1.text = "Hello";
        Content content1 = new Content();
        content1.Slika = R.raw.yellow;
        zbor1.contents.add(content1);

        Zborovi zbor2 = new Zborovi();
        zbor2.contents = new ArrayList<>();
        zbor2.bukvi = new ArrayList<>();
        zbor2.text = "Thank you";
        Content content2 = new Content();
        content2.Slika = R.raw.thankyoublue;
        zbor1.contents.add(content2);

        Zborovi zbor3 = new Zborovi();
        zbor3.contents = new ArrayList<>();
        zbor3.bukvi = new ArrayList<>();
        zbor3.text = "Turn left";
        Content content3 = new Content();
        content3.Slika = R.raw.turnleftred;
        zbor1.contents.add(content3);

        user.zborovi.add(zbor1);
        user.zborovi.add(zbor2);
        user.zborovi.add(zbor3);



        return user;
    }
}
