package com.mkdingo.goran.signlangugage.klasi;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oliver on 1/19/2018.
 */

public class Zborovi implements Serializable{
  public ArrayList<Sliki> contents;
  public String text;
  public ArrayList<Character> bukvi;


    public ArrayList<Sliki> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Sliki> contents) {
        this.contents = contents;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Character> getBukvi() {
        return bukvi;
    }

    public void setBukvi(ArrayList<Character> bukvi) {
        this.bukvi = bukvi;
    }
}
