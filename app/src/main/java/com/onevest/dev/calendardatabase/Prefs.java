package com.onevest.dev.calendardatabase;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    private static final String PRE_LOAD = "pre-load";
    private static final String PREFS_NAME = "com.onevest.dev.calendardatabase";
    private static Prefs instance;
    private final SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static Prefs with(Context context) {
        if (instance == null) {
            instance = new Prefs(context);
        }
        return instance;
    }

    public void setPreLoad(boolean time) {
        preferences.edit().putBoolean(PRE_LOAD, time).apply();
    }

    public boolean getPreLoad() {
        return preferences.getBoolean(PRE_LOAD, false);
    }
}
