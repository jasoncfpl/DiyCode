package com.lynn.sdk.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by lijia
 * date 16/11/9.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getContentViewId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        ButterKnife.bind(this);

        initView(savedInstanceState);
    }

    public abstract void initView(Bundle savedInstanceState);
}
