package com.tutu.reading.spider.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String getResultByReg(String body, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(body);
        String result = "";
        if (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }
}
