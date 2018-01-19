package com.mkdingo.goran.signlangugage.klasi;

import java.util.ArrayList;

/**
 * Created by Oliver on 1/19/2018.
 */

public class Zborovi {
  public ArrayList<Content> contents;
  public String text;
  public ArrayList<Simboli> bukvi;

    public ArrayList<Content> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Content> contents) {
        this.contents = contents;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Simboli> getBukvi() {
        return bukvi;
    }

    public void setBukvi(ArrayList<Simboli> bukvi) {
        this.bukvi = bukvi;
    }
}
