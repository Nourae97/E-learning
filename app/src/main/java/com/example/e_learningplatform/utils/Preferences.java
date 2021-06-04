package com.example.e_learningplatform.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.e_learningplatform.BuildConfig;

//SharedPreferences custom class
public class Preferences {
    private static Preferences instance = null;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    private static Context context;

    private static final String TOKEN = "com.DatabaseUtils.TOKEN";
    public static final String PUBLIC_TOKEN = "LoFWPO93nTKSt";



    public Preferences() {
    }

    public static Preferences getInstance(Context mContext){
        if (instance == null) {
            context = mContext;
            instance = new Preferences();
            preferences = mContext.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
        return instance;
    }

    public static String getToken  ( final Context context ) {
        SharedPreferences language = context.getSharedPreferences ( TOKEN , Context.MODE_PRIVATE );
        return language.getString ( TOKEN , PUBLIC_TOKEN );
    }

    public static void setToken ( final Context context , final String reg ) {
        SharedPreferences sharedPref = context.getSharedPreferences ( TOKEN , Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPref.edit ();
        editor.putString ( TOKEN , reg );
        editor.apply ();
    }
}
