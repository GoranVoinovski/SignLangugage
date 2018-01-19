package com.mkdingo.goran.signlangugage.sharedPreferences;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;
import com.mkdingo.goran.signlangugage.klasi.User;

/**
 * Created by Oliver on 1/19/2018.
 */

public class SharedPreferences {

    private static final String addUser = "name";
    private static android.content.SharedPreferences getPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences("MySharedPreffsFile", Activity.MODE_PRIVATE);
    }

    public static void addUser (User user, Context context){
        Gson gson = new Gson();
        String mapString = gson.toJson(user);
        getPreferences(context).edit().putString("USER",mapString).apply();
    }

    public static String getAddUser() {
        return addUser;
    }
}
