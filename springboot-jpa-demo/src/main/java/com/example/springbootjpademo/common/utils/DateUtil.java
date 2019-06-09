package com.example.springbootjpademo.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sh on 2019/6/8 5:46
 * @version ideaIU-2018.2.3.win_home
 */
public class DateUtil {

    public static String getNowDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }
}
