package edu.anu.retrogame2018s2_frogger;

import android.app.Application;
import android.content.Context;

/*
    Author: Danny Feng
 */

//this class is for getting current Context anywhere anytime
//just call MyApplication.getContext();
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
