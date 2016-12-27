package com.holobor.attrec.util;

import android.provider.CalendarContract;
import android.text.format.DateFormat;
import android.text.style.TtsSpan;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by Holobor on 2016/6/5.
 */
public class TimeUtil {

    private static Calendar calendar = Calendar.getInstance();
    private static long dayStampBase;

    static {
        calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        dayStampBase = calendar.getTimeInMillis() / 1000;
    }

    /**
     * 获取当前天数戳，以2000-01-01为0
     * @param timeStamp 当前时间戳，单位秒
     * @return 天数戳
     */
    public static int getDayStamp(long timeStamp) {

        calendar.setTimeInMillis(timeStamp * 1000);
        return (int) ((calendar.getTimeInMillis() / 1000 - dayStampBase) / (24 * 3600));
    }
}
