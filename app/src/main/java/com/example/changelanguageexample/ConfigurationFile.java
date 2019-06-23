package com.example.changelanguageexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;


public class ConfigurationFile {
    private static final String LANGUAGE_KEY = "langkey2";

    private static SharedPreferences configFile;

    public static String getCurrentLanguage(Context context) {
        configFile = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return configFile.getString(LANGUAGE_KEY, "en");
    }

    public static void setCurrentLanguage(Context context, String language) {
        try {
            Locale locale = new Locale(language);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            context.getApplicationContext().getResources().updateConfiguration(config, null);
        } catch (NullPointerException a) {
            a.printStackTrace();
        } catch (RuntimeException a) {
            a.printStackTrace();
        }
        configFile = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = configFile.edit();
        editor.putString(LANGUAGE_KEY, language);
        editor.apply();
    }

}
