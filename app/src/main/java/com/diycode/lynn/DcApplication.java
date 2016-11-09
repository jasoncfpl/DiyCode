package com.diycode.lynn;

import android.util.Log;

import com.lynn.sdk.base.BaseApplication;

import butterknife.ButterKnife;

/**
 * Created by lijia
 * date 16/11/9.
 */

public class DcApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TAG", "DcApplication onCreate: ");
        ButterKnife.setDebug(true);
    }
}
