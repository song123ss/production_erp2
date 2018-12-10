package com.nosuchteam.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * yuexia
 * 2018/12/6
 * 21:54
 */
public class MyDateConverter implements Converter<String,Date > {

    public Date convert(String source) {
        try {
        //进行日期转换
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
        }
}
