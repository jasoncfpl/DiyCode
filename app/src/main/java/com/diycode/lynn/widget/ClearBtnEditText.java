package com.diycode.lynn.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.diycode.lynn.R;
import com.lynn.sdk.utils.StringUtil;

/**
 * 带删除按钮的输入框
 * Created by lijia
 * date 16/11/9.
 */

public class ClearBtnEditText extends LinearLayout {

    EditText mEditText;
    ImageView mImageView;

    public ClearBtnEditText(Context context) {
        this(context, null);
    }

    public ClearBtnEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClearBtnEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ClearBtnEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        View rootView = LayoutInflater.from(context).inflate(R.layout.custom_edittext_clearbtn, this);
        mEditText = (EditText) rootView.findViewById(R.id.custom_clear_edit);
        mImageView = (ImageView) rootView.findViewById(R.id.custom_clear_imv);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null) {
                    String str = s.toString().trim();
                    if(StringUtil.isEmpty(str)){
                        mImageView.setVisibility(GONE);
                    }else {
                        mImageView.setVisibility(VISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


}
