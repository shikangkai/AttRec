package com.holobor.attrec.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.holobor.attrec.config.AttKeyName;

/**
 * Created by Holobor on 2016/6/5.
 */
public class LocalDataHelper {

    Context context;

    public LocalDataHelper(Context context) {
        if (null == context) {
            throw new IllegalArgumentException("context对象不可为null");
        }
        this.context = context;
    }

    /**
     * 获取指定时间的考勤记录
     * @param dayStamp
     * @return
     */
    public Object[] getDayStt(long dayStamp) {
        DatabaseHelper databaseHelper = new DatabaseHelper(null, AttKeyName.ATT_DB.toString(), null, 1);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        return null;

    }

    /**
     * 上班
     */
    public void doStt(int dayStamp) {

    }

    /**
     * 下班
     */
    public void doUnstt(int dayStamp) {

    }
}
