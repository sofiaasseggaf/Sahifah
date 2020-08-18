package com.project.sahifah.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtils {

    public PreferenceUtils() {
    }

    public static boolean saveUsername(String username, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_USERNAME, username);
        prefsEditor.apply();
        return true;
    }

    public static String getUsername(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_USERNAME, null);
    }

    public static boolean savePassword(String password, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_PASSWORD, password);
        prefsEditor.apply();
        return true;
    }

    public static String getPassword(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_PASSWORD, null);
    }

    public static boolean saveName(String name, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_NAME, name);
        prefsEditor.apply();
        return true;
    }

    public static String getName(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_NAME, null);
    }

    public static boolean saveAlarmSubuh(String subuh, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.ALARM_SUBUH, subuh);
        prefsEditor.apply();
        return true;
    }

    public static String getAlarmSubuh(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.ALARM_SUBUH, null);
    }

    public static boolean saveAlarmZuhur(String zuhur, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.ALARM_ZUHUR, zuhur);
        prefsEditor.apply();
        return true;
    }

    public static String getAlarmZuhur(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.ALARM_ZUHUR, null);
    }

    public static boolean saveAlarmAshar(String ashar, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.ALARM_ASHAR, ashar);
        prefsEditor.apply();
        return true;
    }

    public static String getAlarmAshar(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.ALARM_ASHAR, null);
    }

    public static boolean saveAlarmMagrib(String magrib, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.ALARM_MAGHRIB, magrib);
        prefsEditor.apply();
        return true;
    }

    public static String getAlarmMagrib(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.ALARM_MAGHRIB, null);
    }

    public static boolean saveAlarmIsya(String isya, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.ALARM_ISYA, isya);
        prefsEditor.apply();
        return true;
    }

    public static String getAlarmIsya(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.ALARM_ISYA, null);
    }

    public static boolean saveAlarmCoba(String coba, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.ALARM_COBA, coba);
        prefsEditor.apply();
        return true;
    }

    public static String getAlarmCoba(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.ALARM_COBA, null);
    }

    public static boolean saveUkuranFont(int i, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt(Constants.UKURAN_FONT, i);
        prefsEditor.apply();
        return true;
    }

    public static int getUkuranFont(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(Constants.UKURAN_FONT, 16);
    }

    public static boolean saveUkuranFontArab(int x, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt(Constants.UKURAN_FONT_ARAB, x);
        prefsEditor.apply();
        return true;
    }

    public static int getUkuranFontArab(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(Constants.UKURAN_FONT_ARAB, 30);
    }

}
