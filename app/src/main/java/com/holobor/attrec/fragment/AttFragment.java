package com.holobor.attrec.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.holobor.attrec.R;
import com.holobor.attrec.fragment.base.BaseFragment;

/**
 * Created by Holobor on 2016/5/28.
 */
public class AttFragment extends BaseFragment {

    Typeface typeface;
    TextView txtDayHour, txtDayMin;
    TextView txtMonthDay, txtMonthHour;
    TextView txtAttState;
    ImageButton btnAtt;
    AttState attState = AttState.UN_ATT;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_att;
    }

    @Override
    protected void initVar(Bundle savedInstanceState) {
        typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/baiduan_number.ttf");
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

        /**
         * 设置显示的时间
         */
        txtDayHour = (TextView) rootView.findViewById(R.id.txt_today_att_hour);
        txtDayHour.setTypeface(typeface);
        txtDayMin = (TextView) rootView.findViewById(R.id.txt_today_att_min);
        txtDayMin.setTypeface(typeface);
        txtMonthDay = (TextView) rootView.findViewById(R.id.txt_month_day);
        txtMonthDay.setTypeface(typeface, Typeface.BOLD);
        txtMonthHour = (TextView) rootView.findViewById(R.id.txt_month_hour);
        txtMonthHour.setTypeface(typeface, Typeface.BOLD);

        btnAtt = (ImageButton) rootView.findViewById(R.id.btn_att);
        btnAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (attState) {
                    case UN_ATT:
                        attState = AttState.DOING_WORK;
                        break;

                    case DOING_WORK:
                        attState = AttState.DONE_WORK;
                        break;

                    case DONE_WORK:
                        attState = AttState.DOING_WORK;
                        break;
                }

                updateData();
            }
        });

        txtAttState = (TextView) rootView.findViewById(R.id.txt_att_state);
    }

    /**
     * 更新显示数据
     */
    private void updateData() {
        // 计算当天工作时间
        // 计算当月工作时间
        // 设置当前打卡状态

        switch (attState) {
            case UN_ATT:
                txtAttState.setText(R.string.un_att);
                txtAttState.setBackgroundResource(R.drawable.bg_att_state_un_att);
                break;

            case DOING_WORK:
                txtAttState.setText(R.string.doing_work);
                txtAttState.setBackgroundResource(R.drawable.bg_att_state_doing_work);
                break;

            case DONE_WORK:
                txtAttState.setText(R.string.done_work);
                txtAttState.setBackgroundResource(R.drawable.bg_att_state_done_work);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //刷新显示数据
        updateData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 打卡状态
     */
    public enum AttState {
        UN_ATT,         //未打卡
        DOING_WORK,     //正在上班
        DONE_WORK       //已经下班
    }
}
