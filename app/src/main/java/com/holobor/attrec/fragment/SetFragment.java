package com.holobor.attrec.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.holobor.attrec.R;
import com.holobor.attrec.fragment.base.BaseFragment;

/**
 * 应用设置界面
 */
public class SetFragment extends BaseFragment {

    ListView settingList;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_set;
    }

    @Override
    protected void initVar(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        settingList = (ListView) rootView.findViewById(R.id.list);
    }
}
