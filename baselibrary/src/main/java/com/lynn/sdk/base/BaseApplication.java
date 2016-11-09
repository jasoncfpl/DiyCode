package com.lynn.sdk.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by lijia on 16/6/28.
 */
public class BaseApplication extends MultiDexApplication {

    private static BaseApplication app;

    public static BaseApplication getApplicationInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}