package com.diycode.lynn;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.lynn.sdk.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.title_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.login_sign_in_btn)
    Button singInBtn;//登录
    @BindView(R.id.login_sign_up_btn)
    Button singUpBtn;//注册

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mToolbar.setTitle(getString(R.string.str_login_title));
        Log.i("TAG", "initView: ");
    }


    @OnClick({R.id.login_sign_in_btn,R.id.login_sign_up_btn})
    public void onClickListener(Button doorView){
        doorView.hasp
    }

}

