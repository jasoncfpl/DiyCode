package com.lynn.sdk.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijia
 * date 16/11/9.
 */

public abstract class BaseFragment extends Fragment {

    public abstract int getContentViewId();

    protected View mRootView;

    protected Context mContext;

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

        mRootView = inflater.inflate(getContentViewId(),container,false);
        mUnbinder = ButterKnife.bind(this, mRootView);//绑定 fragment

        this.mContext = getActivity();

        initView(savedInstanceState);

        return mRootView;
    }

    protected abstract void initView(Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
