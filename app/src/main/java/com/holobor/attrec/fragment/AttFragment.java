package com.holobor.attrec.fragment;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.holobor.attrec.R;
import com.holobor.attrec.fragment.base.BaseFragment;

/**
 * Created by Holobor on 2016/5/28.
 */
public class AttFragment extends BaseFragment implements View.OnClickListener {

    Resources resources;
    Typeface typeface;
    TextView txtAttMonth, txtAttToday;
    TextView txtAttState;
    Button btnAtt;
    AttState attState = AttState.UN_ATT;

    String strMonthAtt;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_att;
    }

    @Override
    protected void initVar(Bundle savedInstanceState) {
        typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/baiduan_number.ttf");
        resources = getResources();

        strMonthAtt = resources.getString(R.string.month_att_hint);
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

        /**
         * 设置显示的时间
         */
        txtAttMonth = (TextView) rootView.findViewById(R.id.txt_att_month);
        txtAttToday = (TextView) rootView.findViewById(R.id.txt_att_today);

        txtAttMonth.setTypeface(typeface);
        txtAttToday.setTypeface(typeface);

        btnAtt = (Button) rootView.findViewById(R.id.btn_att);
        btnAtt.setOnClickListener(this);

        txtAttState = (TextView) rootView.findViewById(R.id.txt_att_state);

        setMonthStat(11, 123.6f);

        setTodayAtt(8, 23);
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
                txtAttState.setTextColor(getResources().getColor(R.color.holobor_orange));
                break;

            case DOING_WORK:
                txtAttState.setText(R.string.doing_work);
                txtAttState.setTextColor(getResources().getColor(R.color.holobor_red));
                break;

            case DONE_WORK:
                txtAttState.setText(R.string.done_work);
                txtAttState.setTextColor(getResources().getColor(R.color.holobor_green));
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_month_stat:
                break;

            case R.id.btn_add_txt:
                break;

            case R.id.btn_att:
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
                break;
        }
    }

    /**
     * 设置本月的出勤统计
     * @param days 总天数
     * @param hours 总小时数
     */
    public void setMonthStat(int days, float hours) {
        if (null == txtAttMonth) {
            return;
        }

        String[] monthAttStr = strMonthAtt.split("\\*");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString spannableString;

        spannableString = new SpannableString(monthAttStr[0]);
        spannableString.setSpan(new TypefaceSpan("normal"), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append(spannableString);

        spannableString = new SpannableString(String.format("%.1f", hours));
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R.color.holobor_blue)), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan((int) resources.getDimension(R.dimen.size_txt_large)), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append(spannableString);

        spannableString = new SpannableString(monthAttStr[1]);
        spannableString.setSpan(new TypefaceSpan("normal"), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append(spannableString);

        spannableString = new SpannableString("" + days);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R.color.holobor_blue)), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan((int) resources.getDimension(R.dimen.size_txt_large)), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append(spannableString);

        spannableString = new SpannableString(monthAttStr[2]);
        spannableString.setSpan(new TypefaceSpan("normal"), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append(spannableString);

        txtAttMonth.setText(spannableStringBuilder);
    }

    /**
     * 设置今天的出勤时间
     * @param hours 小时
     * @param minutes 分钟
     */
    public void setTodayAtt(int hours, int minutes) {

        if (null == txtAttToday) {
            return;
        }

        SpannableString spannableString;

        spannableString = new SpannableString((hours < 10 ? "0" + hours : "" + hours) + " " + (minutes < 10 ? "0" + minutes : minutes));
        spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R.color.holobor_blue)), 2, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan((int) resources.getDimension(R.dimen.size_txt_att_time_min)), 2, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtAttToday.setText(spannableString);
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
