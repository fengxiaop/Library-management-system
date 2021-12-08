package com.javaclimb.drug.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理日期相关的操作
 */
public class DateUtil {

    /**
     * 把日期格式转换成年月日(yyyy-MM-dd)的字符串
     */
    public static String dateConvert(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.dateConvert(new Date()));
    }
}
