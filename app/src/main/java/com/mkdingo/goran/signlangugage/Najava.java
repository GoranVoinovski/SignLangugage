package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.klasi.StaticniSliki;
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
    StaticniSliki sliki;


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
        zbor1.contents = PovleciSlikiZaZbor(PopolniLista(user.name),slikiAzbuka());
        zbor1.text = "I am " + user.name;
        zbor1.bukvi = PopolniLista(user.name);

        Zborovi zbor2 = new Zborovi();
        zbor2.contents = new ArrayList<>();
        zbor2.text = "Thank you";
        zbor2.bukvi = PopolniLista("");
        Sliki slikaZbor2 = new Sliki();
        slikaZbor2.slika = R.raw.thankyoublue;
        slikaZbor2.tag = "gif";
        zbor2.contents.add(slikaZbor2);

        Zborovi zbor3 = new Zborovi();
        zbor3.contents = new ArrayList<>();
        zbor3.text = "Turn left";
        zbor3.bukvi = PopolniLista("");
        Sliki slikaZbor3 = new Sliki();
        slikaZbor3.tag = "gif";
        slikaZbor3.slika = R.raw.turnleftred;
        zbor3.contents.add(slikaZbor3);

        Zborovi zbor4 = new Zborovi();
        zbor4.contents = new ArrayList<>();
        zbor4.text = "Turn right";
        zbor4.bukvi = PopolniLista("");
        Sliki slikaZbor4 = new Sliki();
        slikaZbor4.tag = "gif";
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

    public ArrayList PovleciSlikiZaZbor(ArrayList<Character>charlist,ArrayList<StaticniSliki>listaSliki){
        ArrayList<Sliki> slikiOdZbor = new ArrayList<>();
        for (Character c:charlist){
            for (StaticniSliki sliki : listaSliki) {
                if (c == sliki.bukva){
                    slikiOdZbor.add(sliki.Slika);
                }}
        }
        return slikiOdZbor;
    }

   public ArrayList<StaticniSliki>slikiAzbuka (){
        ArrayList<StaticniSliki>slikiArrayList = new ArrayList<>();
        Sliki slika_a = new Sliki();
        slika_a.slika = R.raw.lettera;
        slika_a.tag = "jpg";
        StaticniSliki slikaA = new StaticniSliki(slika_a,'A');
        slikiArrayList.add(slikaA);
        Sliki slika_b = new Sliki();
        slika_b.slika = R.raw.letterb;
        slika_b.tag = "jpg";
        StaticniSliki slikaB = new StaticniSliki(slika_b,'B');
        slikiArrayList.add(slikaB);
        Sliki slika_c = new Sliki();
        slika_c.slika = R.raw.letterc;
        slika_c.tag = "jpg";
        StaticniSliki slikaC = new StaticniSliki(slika_c,'C');
        slikiArrayList.add(slikaC);
        Sliki slika_d = new Sliki();
        slika_d.slika = R.raw.letterd;
        slika_d.tag = "jpg";
        StaticniSliki slikaD = new StaticniSliki(slika_d,'D');
        slikiArrayList.add(slikaD);


        return slikiArrayList;
    }
}
