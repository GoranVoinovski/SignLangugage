package com.mkdingo.goran.signlangugage.sharedPreferences;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;
import com.mkdingo.goran.signlangugage.klasi.User;

/**
 * Created by Oliver on 1/19/2018.
 */

public class SharedPreferences {

    private static android.content.SharedPreferences getPreferences(Context c){
        return c.getApplicationContext().getSharedPreferences("UserPreferences", Activity.MODE_PRIVATE);
    }

    public static void addUser(User user, Context c){

        Gson gson = new Gson();
        String mapString = gson.toJson(user);
        getPreferences(c).edit().putString("User", mapString).apply();


    }

    public static User getUser(Context c){

        return new Gson().fromJson(getPreferences(c).getString("User", ""), User.class);
    }
}
