package com.yiyatech.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created on 2020/6/2.
 */
public class UtilsApplication extends Application {
    private static UtilsApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static Context getUtilsApplicationContext(){
        return mApplication.getApplicationContext();
    }
}
