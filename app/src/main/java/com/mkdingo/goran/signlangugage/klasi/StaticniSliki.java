package com.mkdingo.goran.signlangugage.klasi;

import com.mkdingo.goran.signlangugage.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Goran on 1/25/2018.
 */

public class StaticniSliki implements Serializable{

   public Sliki Slika;
   public char bukva;

    public StaticniSliki() {
    }

    public StaticniSliki(Sliki slika, char bukva) {
        Slika = slika;
        this.bukva = bukva;
    }

    @Override
    public String toString() {



       return String.valueOf(bukva);
    }

}

