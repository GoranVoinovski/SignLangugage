package com.mkdingo.goran.signlangugage.klasi;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Goran on 1/21/2018.
 */

public class Sliki implements Serializable {

    public int slika;
    public String tag;


   @Override
   public String toString() {
      return tag;
   }
}
