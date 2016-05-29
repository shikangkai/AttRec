package com.holobor.attrec.activity.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Holobor on 2016/5/28.
 */
public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());

        initVar(savedInstanceState);
        initView(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract int getLayoutID();
    protected abstract void initVar(Bundle savedInstanceState);
    protected abstract void initView(Bundle savedInstanceState);
}
