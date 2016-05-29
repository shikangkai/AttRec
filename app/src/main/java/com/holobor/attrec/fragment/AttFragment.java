package com.holobor.attrec.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.holobor.attrec.R;
import com.holobor.attrec.fragment.base.BaseFragment;

/**
 * Created by Holobor on 2016/5/28.
 */
public class AttFragment extends BaseFragment {

    BroadcastReceiver timeChangedReceiver;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_att;
    }

    @Override
    protected void initVar(Bundle savedInstanceState) {
        timeChangedReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //改变显示时间
            }
        };

        getContext().registerReceiver(timeChangedReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/baiduan_number.ttf");
        ((TextView) rootView.findViewById(R.id.txt_today_att_hour)).setTypeface(typeface);
        ((TextView) rootView.findViewById(R.id.txt_today_att_min)).setTypeface(typeface);
        ((TextView) rootView.findViewById(R.id.txt_month_hour)).setTypeface(typeface, Typeface.BOLD);
        ((TextView) rootView.findViewById(R.id.txt_month_day)).setTypeface(typeface, Typeface.BOLD);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(timeChangedReceiver);
    }
}
