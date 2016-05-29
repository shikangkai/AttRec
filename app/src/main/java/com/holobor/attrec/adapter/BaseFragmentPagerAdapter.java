package com.holobor.attrec.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于ViewPager加载Fragment的适配器的基类
 */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        if (null == fragments) {
            throw new IllegalArgumentException("can not be null 'fragments'");
        }

        this.fragments = new ArrayList<>();
        for (Fragment fragment : fragments) {
            this.fragments.add(fragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (null == fragments || position >= fragments.size()) {
            return null;
        }
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if (null == fragments) {
            return 0;
        }
        return fragments.size();
    }
}
