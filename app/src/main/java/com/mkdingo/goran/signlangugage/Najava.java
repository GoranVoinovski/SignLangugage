package com.mkdingo.goran.signlangugage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mkdingo.goran.signlangugage.klasi.Sliki;
import com.mkdingo.goran.signlangugage.klasi.SlikiAzbuka;
import com.mkdingo.goran.signlangugage.klasi.StaticniSliki;
import com.mkdingo.goran.signlangugage.klasi.User;
import com.mkdingo.goran.signlangugage.klasi.Zborovi;
import com.mkdingo.goran.signlangugage.sharedPreferences.SharedPreferences;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Najava extends AppCompatActivity {
    @BindView(R.id.edtname)
    EditText userName;
    @BindView(R.id.save)
    Button saveUser;
    @BindView(R.id.textView)
    TextView textView;
    SlikiAzbuka sliki = new SlikiAzbuka();
    String dodadiBukva = " ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_najava);
        ButterKnife.bind(this);



        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager)
                        Najava.this.getSystemService(Najava.this.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(Najava.this.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);


            }
        });

        sliki.slikiBukvi = slikiAzbuka();
        SharedPreferences.addAzbuka(sliki, this);

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @OnClick(R.id.save)
    public void SaveUser() {
        User user = new User();
        user.name = userName.getText().toString();
        FillClasses(user);
        SharedPreferences.addUser(user, Najava.this);
        Intent intent = new Intent(Najava.this, Home.class);
        startActivity(intent);
        finish();
    }



    public void FillClasses(User user) {
        user.zborovi = new ArrayList<>();
        Zborovi zbor1 = new Zborovi();
        zbor1.contents = PovleciSlikiZaZbor(PopolniLista(user.name), slikiAzbuka());
        zbor1.text = "Јас се викам " + user.name;
        zbor1.bukvi = PopolniLista(user.name);

        Zborovi zbor2 = new Zborovi();
        zbor2.contents = new ArrayList<>();
        zbor2.text = "Здраво";
        zbor2.bukvi = PopolniLista("");
        Sliki slikaZbor2 = new Sliki();
        slikaZbor2.slika = R.raw.zdravo;
        slikaZbor2.tag = "gif";
        zbor2.contents.add(slikaZbor2);

        Zborovi zbor3 = new Zborovi();
        zbor3.contents = new ArrayList<>();
        zbor3.text = "Извинете јас не слушам";
        zbor3.bukvi = PopolniLista("");
        Sliki slikaZbor3 = new Sliki();
        slikaZbor3.tag = "gif";
        slikaZbor3.slika = R.raw.izvinete_jas_ne_slusam;
        zbor3.contents.add(slikaZbor3);

        Zborovi zbor4 = new Zborovi();
        zbor4.contents = new ArrayList<>();
        zbor4.text = "Вие";
        zbor4.bukvi = PopolniLista("");
        Sliki slikaZbor4 = new Sliki();
        slikaZbor4.tag = "gif";
        slikaZbor4.slika = R.raw.vie;
        zbor4.contents.add(slikaZbor4);

        Zborovi zbor5 = new Zborovi();
        zbor5.contents = new ArrayList<>();
        zbor5.text = "Дај ми";
        zbor5.bukvi = PopolniLista("");
        Sliki slikaZbor5 = new Sliki();
        slikaZbor5.tag = "gif";
        slikaZbor5.slika = R.raw.daj_mi;
        zbor5.contents.add(slikaZbor5);


        Zborovi zbor6 = new Zborovi();
        zbor6.contents = new ArrayList<>();
        zbor6.text = "Има";
        zbor6.bukvi = PopolniLista("");
        Sliki slikaZbor6 = new Sliki();
        slikaZbor6.tag = "gif";
        slikaZbor6.slika = R.raw.ima;
        zbor6.contents.add(slikaZbor6);

        Zborovi zbor7 = new Zborovi();
        zbor7.contents = new ArrayList<>();
        zbor7.text = "Извини";
        zbor7.bukvi = PopolniLista("");
        Sliki slikaZbor7 = new Sliki();
        slikaZbor7.tag = "gif";
        slikaZbor7.slika = R.raw.izvinete_jas_ne_slusam;
        zbor7.contents.add(slikaZbor7);

        Zborovi zbor8 = new Zborovi();
        zbor8.contents = new ArrayList<>();
        zbor8.text = "Јас сум глува";
        zbor8.bukvi = PopolniLista("");
        Sliki slikaZbor8 = new Sliki();
        slikaZbor8.tag = "gif";
        slikaZbor8.slika = R.raw.jas_sum_gluva;
        zbor8.contents.add(slikaZbor8);

        Zborovi zbor9 = new Zborovi();
        zbor9.contents = new ArrayList<>();
        zbor9.text = "Јас живеам";
        zbor9.bukvi = PopolniLista("");
        Sliki slikaZbor9 = new Sliki();
        slikaZbor9.tag = "gif";
        slikaZbor9.slika = R.raw.jas_ziveam;
        zbor9.contents.add(slikaZbor9);

        Zborovi zbor10 = new Zborovi();
        zbor10.contents = new ArrayList<>();
        zbor10.text = "Каде живееш ти";
        zbor10.bukvi = PopolniLista("");
        Sliki slikaZbor10 = new Sliki();
        slikaZbor10.tag = "gif";
        slikaZbor10.slika = R.raw.kade_zivees_ti;
        zbor10.contents.add(slikaZbor10);

        Zborovi zbor11 = new Zborovi();
        zbor11.contents = new ArrayList<>();
        zbor11.text = "Како се викаш ти";
        zbor11.bukvi = PopolniLista("");
        Sliki slikaZbor11 = new Sliki();
        slikaZbor11.tag = "gif";
        slikaZbor11.slika = R.raw.kako_se_vikas_ti;
        zbor11.contents.add(slikaZbor11);

        Zborovi zbor12 = new Zborovi();
        zbor12.contents = new ArrayList<>();
        zbor12.text = "Ке ти дадам";
        zbor12.bukvi = PopolniLista("");
        Sliki slikaZbor12 = new Sliki();
        slikaZbor11.tag = "gif";
        slikaZbor11.slika = R.raw.ke_ti_dadam;
        zbor12.contents.add(slikaZbor11);

        Zborovi zbor13 = new Zborovi();
        zbor13.contents = new ArrayList<>();
        zbor13.text = "Колку години имаш ти";
        zbor13.bukvi = PopolniLista("");
        Sliki slikaZbor13 = new Sliki();
        slikaZbor13.tag = "gif";
        slikaZbor13.slika = R.raw.kolku_godini_imas_ti;
        zbor13.contents.add(slikaZbor13);

        Zborovi zbor14 = new Zborovi();
        zbor14.contents = new ArrayList<>();
        zbor14.text = "Колку пари";
        zbor14.bukvi = PopolniLista("");
        Sliki slikaZbor14 = new Sliki();
        slikaZbor14.tag = "gif";
        slikaZbor14.slika = R.raw.kolku_pari;
        zbor14.contents.add(slikaZbor14);

        Zborovi zbor15 = new Zborovi();
        zbor15.contents = new ArrayList<>();
        zbor15.text = "Мило ми е што се запознавме";
        zbor15.bukvi = PopolniLista("");
        Sliki slikaZbor15 = new Sliki();
        slikaZbor15.tag = "gif";
        slikaZbor15.slika = R.raw.milo_mi_e_sto_se_zapoznavme;
        zbor15.contents.add(slikaZbor15);

        Zborovi zbor16 = new Zborovi();
        zbor16.contents = new ArrayList<>();
        zbor16.text = "Може ли да ми го дадеш твојот телефонски број";
        zbor16.bukvi = PopolniLista("");
        Sliki slikaZbor16 = new Sliki();
        slikaZbor16.tag = "gif";
        slikaZbor16.slika = R.raw.moze_li_da_mi_go_dades_tvojot_telefonski_broj;
        zbor16.contents.add(slikaZbor16);

        Zborovi zbor17 = new Zborovi();
        zbor17.contents = new ArrayList<>();
        zbor17.text = "Не сакам";
        zbor17.bukvi = PopolniLista("");
        Sliki slikaZbor17 = new Sliki();
        slikaZbor17.tag = "gif";
        slikaZbor17.slika = R.raw.ne_sakam;
        zbor17.contents.add(slikaZbor17);

        Zborovi zbor18 = new Zborovi();
        zbor18.contents = new ArrayList<>();
        zbor18.text = "Не те разбрав повторно кажи ми";
        zbor18.bukvi = PopolniLista("");
        Sliki slikaZbor18 = new Sliki();
        slikaZbor18.tag = "gif";
        slikaZbor18.slika = R.raw.ne_te_razbrav_povtorno_kazimi;
        zbor18.contents.add(slikaZbor18);

        Zborovi zbor19 = new Zborovi();
        zbor19.contents = new ArrayList<>();
        zbor19.text = "Нема";
        zbor19.bukvi = PopolniLista("");
        Sliki slikaZbor19 = new Sliki();
        slikaZbor19.tag = "gif";
        slikaZbor19.slika = R.raw.nema;
        zbor19.contents.add(slikaZbor19);

        Zborovi zbor20 = new Zborovi();
        zbor20.contents = new ArrayList<>();
        zbor20.text = "Неможе";
        zbor20.bukvi = PopolniLista("");
        Sliki slikaZbor20 = new Sliki();
        slikaZbor20.tag = "gif";
        slikaZbor20.slika = R.raw.nemoze;
        zbor20.contents.add(slikaZbor20);

        Zborovi zbor21 = new Zborovi();
        zbor21.contents = new ArrayList<>();
        zbor21.text = "Нетреба";
        zbor21.bukvi = PopolniLista("");
        Sliki slikaZbor21 = new Sliki();
        slikaZbor21.tag = "gif";
        slikaZbor21.slika = R.raw.netreba;
        zbor21.contents.add(slikaZbor21);

        Zborovi zbor22 = new Zborovi();
        zbor22.contents = new ArrayList<>();
        zbor22.text = "Незнае";
        zbor22.bukvi = PopolniLista("");
        Sliki slikaZbor22 = new Sliki();
        slikaZbor22.tag = "gif";
        slikaZbor22.slika = R.raw.neznae;
        zbor22.contents.add(slikaZbor22);

        Zborovi zbor23 = new Zborovi();
        zbor23.contents = new ArrayList<>();
        zbor23.text = "Ние";
        zbor23.bukvi = PopolniLista("");
        Sliki slikaZbor23 = new Sliki();
        slikaZbor23.tag = "gif";
        slikaZbor23.slika = R.raw.nie;
        zbor23.contents.add(slikaZbor23);

        Zborovi zbor24 = new Zborovi();
        zbor24.contents = new ArrayList<>();
        zbor24.text = "Сакам";
        zbor24.bukvi = PopolniLista("");
        Sliki slikaZbor24 = new Sliki();
        slikaZbor24.tag = "gif";
        slikaZbor24.slika = R.raw.sakam;
        zbor24.contents.add(slikaZbor24);

        Zborovi zbor25 = new Zborovi();
        zbor25.contents = new ArrayList<>();
        zbor25.text = "Што работиш ти";
        zbor25.bukvi = PopolniLista("");
        Sliki slikaZbor25 = new Sliki();
        slikaZbor25.tag = "gif";
        slikaZbor25.slika = R.raw.sto_rabotis_ti;
        zbor25.contents.add(slikaZbor25);

        Zborovi zbor26 = new Zborovi();
        zbor26.contents = new ArrayList<>();
        zbor26.text = "Таа";
        zbor26.bukvi = PopolniLista("");
        Sliki slikaZbor26 = new Sliki();
        slikaZbor26.tag = "gif";
        slikaZbor26.slika = R.raw.taa;
        zbor26.contents.add(slikaZbor26);

        Zborovi zbor27 = new Zborovi();
        zbor27.contents = new ArrayList<>();
        zbor27.text = "Ти";
        zbor27.bukvi = PopolniLista("");
        Sliki slikaZbor27 = new Sliki();
        slikaZbor27.tag = "gif";
        slikaZbor27.slika = R.raw.ti;
        zbor27.contents.add(slikaZbor27);

        Zborovi zbor28 = new Zborovi();
        zbor28.contents = new ArrayList<>();
        zbor28.text = "Ти слушаш ?";
        zbor28.bukvi = PopolniLista("");
        Sliki slikaZbor28 = new Sliki();
        slikaZbor28.tag = "gif";
        slikaZbor28.slika = R.raw.ti_slusas_pr;
        zbor28.contents.add(slikaZbor28);

        Zborovi zbor29 = new Zborovi();
        zbor29.contents = new ArrayList<>();
        zbor29.text = "Ти треба ли помош";
        zbor29.bukvi = PopolniLista("");
        Sliki slikaZbor29 = new Sliki();
        slikaZbor29.tag = "gif";
        slikaZbor29.slika = R.raw.ti_treba_li_pomos;
        zbor29.contents.add(slikaZbor29);

        Zborovi zbor30 = new Zborovi();
        zbor30.contents = new ArrayList<>();
        zbor30.text = "Тие";
        zbor30.bukvi = PopolniLista("");
        Sliki slikaZbor30 = new Sliki();
        slikaZbor30.tag = "gif";
        slikaZbor30.slika = R.raw.tie;
        zbor30.contents.add(slikaZbor30);

        Zborovi zbor31 = new Zborovi();
        zbor31.contents = new ArrayList<>();
        zbor31.text = "Треба";
        zbor31.bukvi = PopolniLista("");
        Sliki slikaZbor31 = new Sliki();
        slikaZbor31.tag = "gif";
        slikaZbor31.slika = R.raw.treba;
        zbor31.contents.add(slikaZbor31);

        Zborovi zbor32 = new Zborovi();
        zbor32.contents = new ArrayList<>();
        zbor32.text = "Улица или адреса";
        zbor32.bukvi = PopolniLista("");
        Sliki slikaZbor32 = new Sliki();
        slikaZbor32.tag = "gif";
        slikaZbor32.slika = R.raw.ulica_ili_adresa;
        zbor32.contents.add(slikaZbor30);

        Zborovi zbor33 = new Zborovi();
        zbor33.contents = new ArrayList<>();
        zbor33.text = "Зошто";
        zbor33.bukvi = PopolniLista("");
        Sliki slikaZbor33 = new Sliki();
        slikaZbor33.tag = "gif";
        slikaZbor33.slika = R.raw.zosto;
        zbor33.contents.add(slikaZbor33);

        Zborovi zbor34 = new Zborovi();
        zbor34.contents = new ArrayList<>();
        zbor34.text = "Јас сум добра";
        zbor34.bukvi = PopolniLista("");
        Sliki slikaZbor34 = new Sliki();
        slikaZbor34.tag = "gif";
        slikaZbor34.slika = R.raw.jas_sum_dobra;
        zbor34.contents.add(slikaZbor34);
        Zborovi zbor35 = new Zborovi();
        zbor35.contents = new ArrayList<>();
        zbor35.text = "Јас знам добро знаковен јазик";
        zbor35.bukvi = PopolniLista("");
        Sliki slikaZbor35 = new Sliki();
        slikaZbor35.tag = "gif";
        slikaZbor35.slika = R.raw.jas_znam_dobro_znakoven_jazik;
        zbor35.contents.add(slikaZbor35);
        Zborovi zbor36 = new Zborovi();
        zbor36.contents = new ArrayList<>();
        zbor36.text = "Јас знам малку знаковен јазик";
        zbor36.bukvi = PopolniLista("");
        Sliki slikaZbor36 = new Sliki();
        slikaZbor36.tag = "gif";
        slikaZbor36.slika = R.raw.jas_znam_malku_znakoven_jazik;
        zbor36.contents.add(slikaZbor36);
        Zborovi zbor37 = new Zborovi();
        zbor37.contents = new ArrayList<>();
        zbor37.text = "Кои";
        zbor37.bukvi = PopolniLista("");
        Sliki slikaZbor37 = new Sliki();
        slikaZbor37.tag = "gif";
        slikaZbor37.slika = R.raw.koi;
        zbor37.contents.add(slikaZbor37);
        Zborovi zbor38 = new Zborovi();
        zbor38.contents = new ArrayList<>();
        zbor38.text = "Не давам";
        zbor38.bukvi = PopolniLista("");
        Sliki slikaZbor38 = new Sliki();
        slikaZbor38.tag = "gif";
        slikaZbor38.slika = R.raw.ne_davam;
        zbor38.contents.add(slikaZbor38);
        Zborovi zbor39 = new Zborovi();
        zbor39.contents = new ArrayList<>();
        zbor39.text = "Не знам знаковен јазик";
        zbor39.bukvi = PopolniLista("");
        Sliki slikaZbor39 = new Sliki();
        slikaZbor39.tag = "gif";
        slikaZbor39.slika = R.raw.ne_znam_znakoven_jazik;
        zbor39.contents.add(slikaZbor39);
        Zborovi zbor40 = new Zborovi();
        zbor40.contents = new ArrayList<>();
        zbor40.text = "Ти дали си глув";
        zbor40.bukvi = PopolniLista("");
        Sliki slikaZbor40 = new Sliki();
        slikaZbor40.tag = "gif";
        slikaZbor40.slika = R.raw.ti_dali_si_gluv;
        zbor40.contents.add(slikaZbor40);
        Zborovi zbor41 = new Zborovi();
        zbor41.contents = new ArrayList<>();
        zbor41.text = "Ти како се викаш";
        zbor41.bukvi = PopolniLista("");
        Sliki slikaZbor41 = new Sliki();
        slikaZbor41.tag = "gif";
        slikaZbor41.slika = R.raw.ti_kako_se_vikas;
        zbor41.contents.add(slikaZbor41);
        Zborovi zbor42 = new Zborovi();
        zbor42.contents = new ArrayList<>();
        zbor42.text = "Ве молам";
        zbor42.bukvi = PopolniLista("");
        Sliki slikaZbor42 = new Sliki();
        slikaZbor42.tag = "gif";
        slikaZbor42.slika = R.raw.vemolam;
        zbor42.contents.add(slikaZbor42);
        Zborovi zbor43 = new Zborovi();
        zbor43.contents = new ArrayList<>();
        zbor43.text = "Ве молам запишете";
        zbor43.bukvi = PopolniLista("");
        Sliki slikaZbor43 = new Sliki();
        slikaZbor43.tag = "gif";
        slikaZbor43.slika = R.raw.vemolamzapisete;
        zbor43.contents.add(slikaZbor43);



        user.zborovi.add(zbor1);
        user.zborovi.add(zbor2);
        user.zborovi.add(zbor3);
        user.zborovi.add(zbor4);
        user.zborovi.add(zbor5);
        user.zborovi.add(zbor6);
        user.zborovi.add(zbor7);
        user.zborovi.add(zbor8);
        user.zborovi.add(zbor9);
        user.zborovi.add(zbor10);
        user.zborovi.add(zbor11);
        user.zborovi.add(zbor12);
        user.zborovi.add(zbor13);
        user.zborovi.add(zbor14);
        user.zborovi.add(zbor15);
        user.zborovi.add(zbor16);
        user.zborovi.add(zbor17);
        user.zborovi.add(zbor18);
        user.zborovi.add(zbor19);
        user.zborovi.add(zbor20);
        user.zborovi.add(zbor21);
        user.zborovi.add(zbor22);
        user.zborovi.add(zbor23);
        user.zborovi.add(zbor24);
        user.zborovi.add(zbor25);
        user.zborovi.add(zbor26);
        user.zborovi.add(zbor27);
        user.zborovi.add(zbor28);
        user.zborovi.add(zbor29);
        user.zborovi.add(zbor30);
        user.zborovi.add(zbor31);
        user.zborovi.add(zbor32);
        user.zborovi.add(zbor33);
        user.zborovi.add(zbor34);
        user.zborovi.add(zbor35);
        user.zborovi.add(zbor36);
        user.zborovi.add(zbor37);
        user.zborovi.add(zbor38);
        user.zborovi.add(zbor39);
        user.zborovi.add(zbor40);
        user.zborovi.add(zbor41);
        user.zborovi.add(zbor42);
        user.zborovi.add(zbor43);

    }

    public ArrayList PopolniLista(String word) {

        ArrayList<Character> charList = new ArrayList<Character>();

        for (char c : word.toCharArray()) {
            charList.add(c);
        }
        return charList;
    }

    public ArrayList PovleciSlikiZaZbor(ArrayList<Character> charlist, ArrayList<StaticniSliki> listaSliki) {
        ArrayList<Sliki> slikiOdZbor = new ArrayList<>();
        for (Character c : charlist) {
            for (StaticniSliki sliki : listaSliki) {
                if (c == sliki.bukva) {
                    slikiOdZbor.add(sliki.Slika);
                }
            }
        }
        return slikiOdZbor;
    }

    public ArrayList<StaticniSliki> slikiAzbuka() {
        ArrayList<StaticniSliki> slikiArrayList = new ArrayList<>();
        Sliki slika_a = new Sliki();
        slika_a.slika = R.raw.test2;
        slika_a.tag = "jpg";
        StaticniSliki slikaA = new StaticniSliki(slika_a, 'А');
        slikiArrayList.add(slikaA);

        Sliki slika_б = new Sliki();
        slika_б.slika = R.raw.test2;
        slika_б.tag = "jpg";
        StaticniSliki slikaБ = new StaticniSliki(slika_б, 'Б');
        slikiArrayList.add(slikaБ);

        Sliki slika_в = new Sliki();
        slika_в.slika = R.raw.v;
        slika_в.tag = "jpg";
        StaticniSliki slikaВ = new StaticniSliki(slika_в, 'В');
        slikiArrayList.add(slikaВ);

        Sliki slika_г = new Sliki();
        slika_г.slika = R.raw.g;
        slika_г.tag = "jpg";
        StaticniSliki slikaГ = new StaticniSliki(slika_г, 'Г');
        slikiArrayList.add(slikaГ);

        Sliki slika_д = new Sliki();
        slika_д.slika = R.raw.d;
        slika_д.tag = "jpg";
        StaticniSliki slikaД = new StaticniSliki(slika_д, 'Д');
        slikiArrayList.add(slikaД);

        Sliki slika_ѓ = new Sliki();
        slika_ѓ.slika = R.raw.gj;
        slika_ѓ.tag = "jpg";
        StaticniSliki slikaЃ = new StaticniSliki(slika_ѓ, 'Ѓ');
        slikiArrayList.add(slikaЃ);

        Sliki slika_е = new Sliki();
        slika_е.slika = R.raw.e;
        slika_е.tag = "jpg";
        StaticniSliki slikaЕ = new StaticniSliki(slika_е, 'Е');
        slikiArrayList.add(slikaЕ);

        Sliki slika_ж = new Sliki();
        slika_ж.slika = R.raw.zh;
        slika_ж.tag = "jpg";
        StaticniSliki slikaЖ = new StaticniSliki(slika_ж, 'Ж');
        slikiArrayList.add(slikaЖ);

        Sliki slika_з = new Sliki();
        slika_з.slika = R.raw.z;
        slika_з.tag = "jpg";
        StaticniSliki slikaЗ = new StaticniSliki(slika_з, 'З');
        slikiArrayList.add(slikaЗ);

        Sliki slika_ѕ = new Sliki();
        slika_ѕ.slika = R.raw.dz;
        slika_ѕ.tag = "jpg";
        StaticniSliki slikaЅ = new StaticniSliki(slika_ѕ, 'Ѕ');
        slikiArrayList.add(slikaЅ);

        Sliki slika_и = new Sliki();
        slika_и.slika = R.raw.i;
        slika_и.tag = "jpg";
        StaticniSliki slikaИ = new StaticniSliki(slika_и, 'И');
        slikiArrayList.add(slikaИ);

        Sliki slika_ј = new Sliki();
        slika_ј.slika = R.raw.j;
        slika_ј.tag = "jpg";
        StaticniSliki slikaЈ = new StaticniSliki(slika_ј, 'Ј');
        slikiArrayList.add(slikaЈ);

        Sliki slika_к = new Sliki();
        slika_к.slika = R.raw.k;
        slika_к.tag = "jpg";
        StaticniSliki slikaК = new StaticniSliki(slika_к, 'К');
        slikiArrayList.add(slikaК);

        Sliki slika_л = new Sliki();
        slika_л.slika = R.raw.l;
        slika_л.tag = "jpg";
        StaticniSliki slikaЛ = new StaticniSliki(slika_л, 'Л');
        slikiArrayList.add(slikaЛ);

        Sliki slika_љ = new Sliki();
        slika_љ.slika = R.raw.lj;
        slika_љ.tag = "jpg";
        StaticniSliki slikaЉ = new StaticniSliki(slika_љ, 'Љ');
        slikiArrayList.add(slikaЉ);

        Sliki slika_м = new Sliki();
        slika_м.slika = R.raw.m;
        slika_м.tag = "jpg";
        StaticniSliki slikaМ = new StaticniSliki(slika_м, 'М');
        slikiArrayList.add(slikaМ);

        Sliki slika_н = new Sliki();
        slika_н.slika = R.raw.n;
        slika_н.tag = "jpg";
        StaticniSliki slikaН = new StaticniSliki(slika_н, 'Н');
        slikiArrayList.add(slikaН);

        Sliki slika_њ = new Sliki();
        slika_њ.slika = R.raw.nj;
        slika_њ.tag = "jpg";
        StaticniSliki slikaЊ = new StaticniSliki(slika_њ, 'Њ');
        slikiArrayList.add(slikaЊ);

        Sliki slika_о = new Sliki();
        slika_о.slika = R.raw.o;
        slika_о.tag = "jpg";
        StaticniSliki slikaО = new StaticniSliki(slika_о, 'О');
        slikiArrayList.add(slikaО);

        Sliki slika_п = new Sliki();
        slika_п.slika = R.raw.p;
        slika_п.tag = "jpg";
        StaticniSliki slikaП = new StaticniSliki(slika_п, 'П');
        slikiArrayList.add(slikaП);

        Sliki slika_р = new Sliki();
        slika_р.slika = R.raw.r;
        slika_р.tag = "jpg";
        StaticniSliki slikaР = new StaticniSliki(slika_р, 'Р');
        slikiArrayList.add(slikaР);

        Sliki slika_с = new Sliki();
        slika_с.slika = R.raw.s;
        slika_с.tag = "jpg";
        StaticniSliki slikaС = new StaticniSliki(slika_с, 'С');
        slikiArrayList.add(slikaС);

        Sliki slika_т = new Sliki();
        slika_т.slika = R.raw.t;
        slika_т.tag = "jpg";
        StaticniSliki slikaТ = new StaticniSliki(slika_т, 'Т');
        slikiArrayList.add(slikaТ);

        Sliki slika_ќ = new Sliki();
        slika_ќ.slika = R.raw.kj;
        slika_ќ.tag = "jpg";
        StaticniSliki slikaЌ = new StaticniSliki(slika_ќ, 'Ќ');
        slikiArrayList.add(slikaЌ);

        Sliki slika_у = new Sliki();
        slika_у.slika = R.raw.u;
        slika_у.tag = "jpg";
        StaticniSliki slikaУ = new StaticniSliki(slika_у, 'У');
        slikiArrayList.add(slikaУ);

        Sliki slika_ф = new Sliki();
        slika_ф.slika = R.raw.f;
        slika_ф.tag = "jpg";
        StaticniSliki slikaФ = new StaticniSliki(slika_ф, 'Ф');
        slikiArrayList.add(slikaФ);

        Sliki slika_х = new Sliki();
        slika_х.slika = R.raw.h;
        slika_х.tag = "jpg";
        StaticniSliki slikaХ = new StaticniSliki(slika_х, 'Х');
        slikiArrayList.add(slikaХ);

        Sliki slika_ц = new Sliki();
        slika_ц.slika = R.raw.c;
        slika_ц.tag = "jpg";
        StaticniSliki slikaЦ = new StaticniSliki(slika_ц, 'Ц');
        slikiArrayList.add(slikaЦ);

        Sliki slika_ч = new Sliki();
        slika_ч.slika = R.raw.ch;
        slika_ч.tag = "jpg";
        StaticniSliki slikaЧ = new StaticniSliki(slika_ч, 'Ч');
        slikiArrayList.add(slikaЧ);

        Sliki slika_џ = new Sliki();
        slika_џ.slika = R.raw.x;
        slika_џ.tag = "jpg";
        StaticniSliki slikaЏ = new StaticniSliki(slika_џ, 'Џ');
        slikiArrayList.add(slikaЏ);

        Sliki slika_ш = new Sliki();
        slika_ш.slika = R.raw.sh;
        slika_ш.tag = "jpg";
        StaticniSliki slikaШ = new StaticniSliki(slika_ш, 'Ш');
        slikiArrayList.add(slikaШ);


        return slikiArrayList;
    }

    @OnClick(R.id.њ)
    public void klik1(View v) {

        dodadiBukva = "Њ";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());

    }

    @OnClick(R.id.љ)
    public void klik2(View v) {

        dodadiBukva = "Љ";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }


    @OnClick(R.id.е)
    public void klik3(View v) {

        dodadiBukva = "Е";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.р)
    public void klik4(View v) {

        dodadiBukva = "Р";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.т)
    public void klik5(View v) {

        dodadiBukva = "Т";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.ѕ)
    public void klik6(View v) {

        dodadiBukva = "Ѕ";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.у)
    public void klik7(View v) {

        dodadiBukva = "У";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.и)
    public void klik8(View v) {

        dodadiBukva = "И";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.о)
    public void klik9(View v) {

        dodadiBukva = "О";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.п)
    public void klik10(View v) {

        dodadiBukva = "П";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.ш)
    public void klik11(View v) {

        dodadiBukva = "Ш";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.а)
    public void klik12(View v) {

        dodadiBukva = "А";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.с)
    public void klik13(View v) {

        dodadiBukva = "С";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.д)
    public void klik14(View v) {

        dodadiBukva = "Д";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.ф)
    public void klik15(View v) {

        dodadiBukva = "Ф";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.г)
    public void klik16(View v) {

        dodadiBukva = "Г";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.х)
    public void klik17(View v) {

        dodadiBukva = "Х";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.ј)
    public void klik18(View v) {

        dodadiBukva = "Ј";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.к)
    public void klik19(View v) {

        dodadiBukva = "К";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.л)
    public void klik20(View v) {

        dodadiBukva = "Л";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.ч)
    public void klik21(View v) {

        dodadiBukva = "Ч";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.ќ)
    public void klik22(View v) {

        dodadiBukva = "Ќ";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.з)
    public void klik23(View v) {

        dodadiBukva = "З";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.џ)
    public void klik24(View v) {

        dodadiBukva = "Џ";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.ц)
    public void klik25(View v) {

        dodadiBukva = "Ц";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.в)
    public void klik26(View v) {

        dodadiBukva = "В";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.б)
    public void klik27(View v) {

        dodadiBukva = "Б";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.н)
    public void klik28(View v) {

        dodadiBukva = "Н";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.м)
    public void klik29(View v) {

        dodadiBukva = "М";
        userName.setText( userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.ѓ)
    public void klik30(View v) {

        dodadiBukva = "Ѓ";
        userName.setText(userName.getText()+  dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }
    @OnClick(R.id.ж)
    public void klik31(View v) {

        dodadiBukva = "Ж";
        userName.setText(userName.getText() + dodadiBukva.toString());
        userName.setSelection(userName.getText().length());
    }

    @OnClick(R.id.del)
    public void klik32(View v) {

        if (dodadiBukva != null && dodadiBukva.length() > 0){

            String kratenka = userName.getText().toString();
            dodadiBukva = kratenka.substring(0,kratenka.length() - 1);
            userName.setText(dodadiBukva);
            userName.setSelection(userName.getText().length());
        }



    }






}

