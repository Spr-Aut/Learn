package com.example.learn.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.learn.R;

@SuppressLint("AppCompatCustomView")
public class CustomButton extends Button {
    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        this(context,attrs,R.style.CommonButton);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, 0, R.style.CommonButton);
    }

    @SuppressLint("NewApi")
    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
