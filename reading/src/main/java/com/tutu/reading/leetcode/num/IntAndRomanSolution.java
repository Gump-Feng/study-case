package com.tutu.reading.leetcode.num;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2022-04-05
 */
public class IntAndRomanSolution {

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
//        int num = 3994;
//        String roman = intToRoman(num);
//        System.out.println(roman);

        String s = "MCMXCIV";
        int i = romanToInt(s);
        System.out.println(i);
    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num = num - value;
                result.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }

        return result.toString();
    }

    public static int romanToInt(String s) {
        int length = s.length();
        int index = 0;
        int result = 0;
        while (index < length) {
            int cur = strToInt(s.charAt(index));
            if (index + 1 < length) {
                int next = strToInt(s.charAt(index + 1));
                if (cur < next) {
                    cur = next - cur;
                    index = index + 2;
                } else {
                    index++;
                }
            } else {
                index++;
            }
            result = result + cur;
        }
        return result;
    }

    /**
     * 自己解法的优化版，参考官方写法
     *
     * 按照题目的描述，可以总结如下规则：
     *
     * 罗马数字由 I,V,X,L,C,D,M 构成；
     * 当小值在大值的左边，则减小值，如 IV=5-1=4；
     * 当小值在大值的右边，则加小值，如 VI=5+1=6；
     * 由上可知，右值永远为正，因此最后一位必然为正。
     */
    public static int romanToInt2(String s) {
        int length = s.length();
        int index = 0;
        int result = 0;
        while (index < length) {
            int cur = strToInt(s.charAt(index));
            if (index + 1 < length && cur < strToInt(s.charAt(index + 1))) {
                cur = strToInt(s.charAt(index + 1)) - cur;
                index = index + 2;
            } else {
                index++;
            }
            result = result + cur;
        }
        return result;
    }
    /**
     * 官方解法
     */
    public static int romanToInt1(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }


    static Map<Character, Integer> symbolValues = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int strToInt(char str) {
        switch (str) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


}
