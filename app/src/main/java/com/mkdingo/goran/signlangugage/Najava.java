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
import android.widget.Toast;

import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.klasi.SlikiAzbuka;
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
    SlikiAzbuka sliki = new SlikiAzbuka();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_najava);
        ButterKnife.bind(this);

        sliki.slikiBukvi = slikiAzbuka();
        SharedPreferences.addAzbuka(sliki,this);

    }


    @OnClick(R.id.save)
    public void SaveUser(){
        User user = new User();
        user.name = userName.getText().toString();
        FillClasses(user);
        SharedPreferences.addUser(user,Najava.this);
        Intent intent = new Intent(Najava.this, Home.class);
        startActivity(intent);
        Toast.makeText(this, "Успешно се регистриравте", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void FillClasses(User user){
        user.zborovi = new ArrayList<>();
        Zborovi zbor1 = new Zborovi();
        zbor1.contents = PovleciSlikiZaZbor(PopolniLista(user.name),slikiAzbuka());
        zbor1.text = "Јас сум " + user.name;
        zbor1.bukvi = PopolniLista(user.name);

        Zborovi zbor2 = new Zborovi();
        zbor2.contents = new ArrayList<>();
        zbor2.text = "Благодарам";
        zbor2.bukvi = PopolniLista("");
        Sliki slikaZbor2 = new Sliki();
        slikaZbor2.slika = R.raw.thankyoublue;
        slikaZbor2.tag = "gif";
        zbor2.contents.add(slikaZbor2);

        Zborovi zbor3 = new Zborovi();
        zbor3.contents = new ArrayList<>();
        zbor3.text = "Заврти лево";
        zbor3.bukvi = PopolniLista("");
        Sliki slikaZbor3 = new Sliki();
        slikaZbor3.tag = "gif";
        slikaZbor3.slika = R.raw.turnleftred;
        zbor3.contents.add(slikaZbor3);

        Zborovi zbor4 = new Zborovi();
        zbor4.contents = new ArrayList<>();
        zbor4.text = "Заврти десно";
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
        StaticniSliki slikaA = new StaticniSliki(slika_a,'А');
        slikiArrayList.add(slikaA);
        Sliki slika_б = new Sliki();
        slika_б.slika = R.raw.letterb;
        slika_б.tag = "jpg";
        StaticniSliki slikaБ = new StaticniSliki(slika_б,'Б');
        slikiArrayList.add(slikaБ);
        Sliki slika_в = new Sliki();
        slika_в.slika = R.raw.letterb;
        slika_в.tag = "jpg";
        StaticniSliki slikaВ = new StaticniSliki(slika_в,'В');
        slikiArrayList.add(slikaВ);
        Sliki slika_г = new Sliki();
        slika_г.slika = R.raw.letterb;
        slika_г.tag = "jpg";
        StaticniSliki slikaГ = new StaticniSliki(slika_г,'Г');
        slikiArrayList.add(slikaГ);
       Sliki slika_д = new Sliki();
       slika_д.slika = R.raw.letterb;
       slika_д.tag = "jpg";
       StaticniSliki slikaД = new StaticniSliki(slika_д,'Д');
       slikiArrayList.add(slikaД);
       Sliki slika_ѓ = new Sliki();
       slika_ѓ.slika = R.raw.letterb;
       slika_ѓ.tag = "jpg";
       StaticniSliki slikaЃ = new StaticniSliki(slika_ѓ,'Ѓ');
       slikiArrayList.add(slikaЃ);
       Sliki slika_е = new Sliki();
       slika_е.slika = R.raw.letterb;
       slika_е.tag = "jpg";
       StaticniSliki slikaЕ = new StaticniSliki(slika_е,'Е');
       slikiArrayList.add(slikaЕ);
       Sliki slika_ж = new Sliki();
       slika_ж.slika = R.raw.letterb;
       slika_ж.tag = "jpg";
       StaticniSliki slikaЖ = new StaticniSliki(slika_ж,'Ж');
       slikiArrayList.add(slikaЖ);
       Sliki slika_з = new Sliki();
       slika_з.slika = R.raw.letterb;
       slika_з.tag = "jpg";
       StaticniSliki slikaЗ = new StaticniSliki(slika_з,'З');
       slikiArrayList.add(slikaЗ);
       Sliki slika_ѕ = new Sliki();
       slika_ѕ.slika = R.raw.letterb;
       slika_ѕ.tag = "jpg";
       StaticniSliki slikaЅ = new StaticniSliki(slika_ѕ,'Ѕ');
       slikiArrayList.add(slikaЅ);
       Sliki slika_и = new Sliki();
       slika_и.slika = R.raw.letterb;
       slika_и.tag = "jpg";
       StaticniSliki slikaИ = new StaticniSliki(slika_и,'И');
       slikiArrayList.add(slikaИ);
       Sliki slika_ј = new Sliki();
       slika_ј.slika = R.raw.letterb;
       slika_ј.tag = "jpg";
       StaticniSliki slikaЈ = new StaticniSliki(slika_ј,'Ј');
       slikiArrayList.add(slikaЈ);
       Sliki slika_к = new Sliki();
       slika_к.slika = R.raw.letterb;
       slika_к.tag = "jpg";
       StaticniSliki slikaК = new StaticniSliki(slika_к,'К');
       slikiArrayList.add(slikaК);
       Sliki slika_л = new Sliki();
       slika_л.slika = R.raw.letterb;
       slika_л.tag = "jpg";
       StaticniSliki slikaЛ = new StaticniSliki(slika_л,'Л');
       slikiArrayList.add(slikaЛ);
       Sliki slika_љ = new Sliki();
       slika_љ.slika = R.raw.letterb;
       slika_љ.tag = "jpg";
       StaticniSliki slikaЉ = new StaticniSliki(slika_љ,'Љ');
       slikiArrayList.add(slikaЉ);
       Sliki slika_м = new Sliki();
       slika_м.slika = R.raw.letterb;
       slika_м.tag = "jpg";
       StaticniSliki slikaМ = new StaticniSliki(slika_м,'М');
       slikiArrayList.add(slikaМ);
       Sliki slika_н = new Sliki();
       slika_н.slika = R.raw.letterb;
       slika_н.tag = "jpg";
       StaticniSliki slikaН = new StaticniSliki(slika_н,'Н');
       slikiArrayList.add(slikaН);
       Sliki slika_њ = new Sliki();
       slika_њ.slika = R.raw.letterb;
       slika_њ.tag = "jpg";
       StaticniSliki slikaЊ = new StaticniSliki(slika_њ,'Њ');
       slikiArrayList.add(slikaЊ);
       Sliki slika_о = new Sliki();
       slika_о.slika = R.raw.letterb;
       slika_о.tag = "jpg";
       StaticniSliki slikaО = new StaticniSliki(slika_о,'О');
       slikiArrayList.add(slikaО);
       Sliki slika_п = new Sliki();
       slika_п.slika = R.raw.letterb;
       slika_п.tag = "jpg";
       StaticniSliki slikaП = new StaticniSliki(slika_п,'П');
       slikiArrayList.add(slikaП);
       Sliki slika_р = new Sliki();
       slika_р.slika = R.raw.letterb;
       slika_р.tag = "jpg";
       StaticniSliki slikaР = new StaticniSliki(slika_р,'Р');
       slikiArrayList.add(slikaР);
       Sliki slika_с = new Sliki();
       slika_с.slika = R.raw.letterb;
       slika_с.tag = "jpg";
       StaticniSliki slikaС = new StaticniSliki(slika_с,'С');
       slikiArrayList.add(slikaС);
       Sliki slika_т = new Sliki();
       slika_т.slika = R.raw.letterb;
       slika_т.tag = "jpg";
       StaticniSliki slikaТ = new StaticniSliki(slika_т,'Т');
       slikiArrayList.add(slikaТ);
       Sliki slika_ќ = new Sliki();
       slika_ќ.slika = R.raw.letterb;
       slika_ќ.tag = "jpg";
       StaticniSliki slikaЌ = new StaticniSliki(slika_ќ,'Ќ');
       slikiArrayList.add(slikaЌ);
       Sliki slika_у = new Sliki();
       slika_у.slika = R.raw.letterb;
       slika_у.tag = "jpg";
       StaticniSliki slikaУ = new StaticniSliki(slika_у,'У');
       slikiArrayList.add(slikaУ);
       Sliki slika_ф = new Sliki();
       slika_ф.slika = R.raw.letterb;
       slika_ф.tag = "jpg";
       StaticniSliki slikaФ = new StaticniSliki(slika_ф,'Ф');
       slikiArrayList.add(slikaФ);
       Sliki slika_х = new Sliki();
       slika_х.slika = R.raw.letterb;
       slika_х.tag = "jpg";
       StaticniSliki slikaХ = new StaticniSliki(slika_х,'Х');
       slikiArrayList.add(slikaХ);
       Sliki slika_ц = new Sliki();
       slika_ц.slika = R.raw.letterb;
       slika_ц.tag = "jpg";
       StaticniSliki slikaЦ = new StaticniSliki(slika_ц,'Ц');
       slikiArrayList.add(slikaЦ);
       Sliki slika_ч = new Sliki();
       slika_ч.slika = R.raw.letterb;
       slika_ч.tag = "jpg";
       StaticniSliki slikaЧ = new StaticniSliki(slika_ч,'Ч');
       slikiArrayList.add(slikaЧ);
       Sliki slika_џ = new Sliki();
       slika_џ.slika = R.raw.letterb;
       slika_џ.tag = "jpg";
       StaticniSliki slikaЏ = new StaticniSliki(slika_џ,'Џ');
       slikiArrayList.add(slikaЏ);
       Sliki slika_ш = new Sliki();
       slika_ш.slika = R.raw.letterb;
       slika_ш.tag = "jpg";
       StaticniSliki slikaШ = new StaticniSliki(slika_ш,'Ш');
       slikiArrayList.add(slikaШ);



        return slikiArrayList;
    }
}
