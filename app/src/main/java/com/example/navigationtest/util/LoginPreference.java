package com.example.navigationtest.util;

import android.content.Context;
import android.content.SharedPreferences;

public class LoginPreference {

    public static final String SHARED_PREF_NAME = "tech";
    //public static final String EMAIL_SHARED_PREF="email";
    public static final String USERNAME_SHARED_PREF = "username";
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";

    Context context;

    public LoginPreference(Context context) {
        this.context = context;
    }

    public void putLoginPref(String username){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LOGGEDIN_SHARED_PREF, true);
        editor.putString(USERNAME_SHARED_PREF, username);

        editor.commit();
    }

    public boolean isLogin(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        boolean isLogin = sharedPreferences.getBoolean(LOGGEDIN_SHARED_PREF, false);
        return isLogin;
    }
}
