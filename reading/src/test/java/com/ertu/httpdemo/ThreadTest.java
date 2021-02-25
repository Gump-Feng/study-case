package com.ertu.httpdemo;


import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxf
 * @date 2019/4/16 22:55
 */
public class ThreadTest {

    public static void main(String[] args) {
        DesiredCapabilities capability = new DesiredCapabilities();

        capability.setBrowserName("chrome");

        capability.setPlatform(Platform.WINDOWS);

        try {
            WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.4:4444/wd/hub"), capability);

            driver.get("http://www.baidu.com");

            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
    }

    public void threadTest(int i) {
        System.out.println(i);
    }

    @Test
    public void test() {
        String s = "";
        String t = "";
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        //暴力破解也是特么的需要脑子的，不能瞎写
        String result = "";
        for (int i = 0; i < sChars.length; i++) {
            List<Character> tList = new ArrayList<>();
            for (Character tt : tChars) {
                tList.add(tt);
            }
            for (int j = i + 1; j < sChars.length; j++) {
                //两次遍历后，需要对从s截取出来的部分字符串判断，是否包含t的全部字符
                //此处还需要再进行嵌套遍历才可实现
                if (tList.contains(sChars[j])) {
                    tList.remove(sChars[j]);
                }
                //若tList为空，则确定s的区间字符串
                if (tList.isEmpty()) {
                    StringBuilder temp = new StringBuilder();
                    for (int k = i; k < j + 1; k++) {
                        temp.append(sChars[k]);
                    }
                    if (temp.toString().length() <= result.length()) {
                        result = temp.toString();
                    }
                }
            }
        }
        System.out.println(result);
    }

    @Test
    public void test1() {
        String s = "";
        String t = "";
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        //定义左右指针，初始值分别为0
        int left = 0;
        int right = 0;
        //定义窗口
        List<Character> window = new ArrayList<>();
        //以right指针与s字符串长度做循环结束判断
        while (right < sChars.length) {
            ++right;
            //增加right增大窗口
            for (int i = left; i < right; i++) {
                window.add(sChars[i]);
            }
            //判断窗口是否包含t的全部元素
            boolean allContain = true;
            for (Character tt : tChars) {
                if (!window.contains(tt)) {
                    allContain = false;
                    break;
                }
            }
            if (allContain) {
                //增加left缩小窗口并判断是否不满足条件
                ++left;

            }
        }
    }

    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    @Test
    public void solution() {
        




    }
















}
