package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mkdingo.goran.signlangugage.klasi.Sliki;
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
        Sliki slikaZbor1 = new Sliki();
        slikaZbor1.slika = String.valueOf(R.raw.lettera);
        zbor1.contents.add(slikaZbor1);

        Zborovi zbor2 = new Zborovi();
        zbor2.contents = new ArrayList<>();
        zbor2.bukvi = new ArrayList<>();
        zbor2.text = "Thank you";
        Sliki slikaZbor2 = new Sliki();
        slikaZbor2.slika = String.valueOf(R.raw.gif1);
        zbor2.contents.add(slikaZbor2);

        Zborovi zbor3 = new Zborovi();
        zbor3.contents = new ArrayList<>();
        zbor3.bukvi = new ArrayList<>();
        zbor3.text = "Turn left";
        Sliki slikaZbor3 = new Sliki();
        slikaZbor3.slika = String.valueOf(R.raw.turnleftred);
        zbor3.contents.add(slikaZbor3);

        Zborovi zbor4 = new Zborovi();
        zbor4.contents = new ArrayList<>();
        zbor4.bukvi = new ArrayList<>();
        zbor4.text = "Turn right";
        Sliki slikaZbor4 = new Sliki();
        slikaZbor4.slika = String.valueOf(R.raw.turnrightblue);
        zbor4.contents.add(slikaZbor4);

        user.zborovi.add(zbor1);
        user.zborovi.add(zbor2);
        user.zborovi.add(zbor3);
        user.zborovi.add(zbor4);



        return user;
    }
}
