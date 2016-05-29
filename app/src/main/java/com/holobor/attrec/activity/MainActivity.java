package com.holobor.attrec.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.holobor.attrec.R;
import com.holobor.attrec.activity.base.BaseActivity;
import com.holobor.attrec.fragment.AttFragment;
import com.holobor.attrec.fragment.RecFragment;
import com.holobor.attrec.fragment.SetFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    View btnAtt, btnRec, btnSet;
    ViewPager contentPager;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVar(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        btnAtt = findViewById(R.id.btn_att);
        btnRec = findViewById(R.id.btn_rec);
        btnSet = findViewById(R.id.btn_set);

        btnAtt.setSelected(true);

        final List<Fragment> list = new ArrayList<>();
        list.add(new AttFragment());
        list.add(new RecFragment());
        list.add(new SetFragment());

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }
        };

        contentPager = (ViewPager) findViewById(R.id.pager);
        contentPager.setAdapter(fragmentPagerAdapter);
    }

    /**
     * 导航栏点击事件
     *
     * @param view 点击的控件
     */
    public void onNavClick(View view) {

        btnAtt.setSelected(false);
        btnRec.setSelected(false);
        btnSet.setSelected(false);

        switch (view.getId()) {
            case R.id.btn_att:
                btnAtt.setSelected(true);
                contentPager.setCurrentItem(0);
                break;

            case R.id.btn_rec:
                btnRec.setSelected(true);
                contentPager.setCurrentItem(1);
                break;

            case R.id.btn_set:
                btnSet.setSelected(true);
                contentPager.setCurrentItem(2);
                break;
        }
    }
}
