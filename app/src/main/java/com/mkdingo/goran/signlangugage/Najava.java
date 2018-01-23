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
import java.util.List;

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



    }


    @OnClick(R.id.save)
    public void SaveUser(){
        User user = new User();
        user.name = userName.getText().toString();
        FillClasses(user);
        SharedPreferences.addUser(user,Najava.this);
        Intent intent = new Intent(Najava.this, Home.class);
        startActivity(intent);

    }

    public void FillClasses(User user){
        user.zborovi = new ArrayList<>();
        Zborovi zbor1 = new Zborovi();
        zbor1.contents = new ArrayList<>();
        zbor1.text = "I am " + user.name;
        zbor1.bukvi = PopolniLista(user.name);
        Sliki slikaZbor1 = new Sliki();
        Sliki slikaZbor1_2 = new Sliki();
        slikaZbor1.tag = "jpg";
        slikaZbor1_2.tag = "jpg";
        slikaZbor1.slika = R.raw.lettera;
        slikaZbor1_2.slika = R.raw.lettera;
        zbor1.contents.add(slikaZbor1);
        zbor1.contents.add(slikaZbor1_2);

        Zborovi zbor2 = new Zborovi();
        zbor2.contents = new ArrayList<>();
        zbor2.text = "Thank you";
        Sliki slikaZbor2 = new Sliki();
        slikaZbor2.slika = R.raw.gif1;
        slikaZbor2.tag = "gif";
        zbor2.contents.add(slikaZbor2);

        Zborovi zbor3 = new Zborovi();
        zbor3.contents = new ArrayList<>();
        zbor3.text = "Turn left";
        Sliki slikaZbor3 = new Sliki();
        slikaZbor3.tag = "jpg";
        slikaZbor3.slika = R.raw.turnleftred;
        zbor3.contents.add(slikaZbor3);

        Zborovi zbor4 = new Zborovi();
        zbor4.contents = new ArrayList<>();
        zbor4.text = "Turn right";
        Sliki slikaZbor4 = new Sliki();
        slikaZbor4.tag = "jpg";
        slikaZbor4.slika = R.raw.turnrightblue;
        zbor4.contents.add(slikaZbor4);

        user.zborovi.add(zbor1);
        user.zborovi.add(zbor2);
        user.zborovi.add(zbor3);
        user.zborovi.add(zbor4);




    }

    public ArrayList PopolniLista(String word){

        ArrayList<Character> charList = new ArrayList<Character>();

        for (char c : word.toCharArray()) {
            charList.add(c);
        }
     return charList;
    }
}
