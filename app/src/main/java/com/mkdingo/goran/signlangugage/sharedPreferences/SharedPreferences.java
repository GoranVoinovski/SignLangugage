package com.mkdingo.goran.signlangugage.sharedPreferences;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Oliver on 1/19/2018.
 */

public class SharedPreferences {
    private static android.content.SharedPreferences getPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences("MySharedPreffsFile", Activity.MODE_PRIVATE);
    }
    String addUser;
}
