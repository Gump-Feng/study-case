package com.ertu.spider.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxf
 * @date 2019/9/22 18:02
 *
 * 一些对字符串的常用操作，比如正则，截取等等
 */
public class StringUtil {

    public static String getResultByReg(String str, String reg){
        String result = "";
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(reg);
        if (matcher.find()){
            result = matcher.group(0);
        }
        return result;
    }
}
