package com.kimlngo.leetcode.mocktest;

import java.util.*;

public class MockTestTwentyOne {
    private static final Map<String, Integer> VAL_MAP;

    static {
        VAL_MAP = new HashMap<>();

        VAL_MAP.put("I", 1);
        VAL_MAP.put("V", 5);
        VAL_MAP.put("X", 10);
        VAL_MAP.put("L", 50);
        VAL_MAP.put("C", 100);
        VAL_MAP.put("D", 500);
        VAL_MAP.put("M", 1000);

        //special case
        VAL_MAP.put("IV", 4);
        VAL_MAP.put("IX", 9);
        VAL_MAP.put("XL", 40);
        VAL_MAP.put("XC", 90);
        VAL_MAP.put("CD", 400);
        VAL_MAP.put("CM", 900);
    }
    public static void main(String[] args) {
        var sol = new MockTestTwentyOne();

        System.out.println(sol.romanToInt("III")); //3
        System.out.println(sol.romanToInt("LVIII")); //58
        System.out.println(sol.romanToInt("MCMXCIV")); //1994
    }

    private int romanToInt(String s) {
        int value = 0, i = 0;

        String cur, next;

        while (i < s.length() - 1) {
            cur = String.valueOf(s.charAt(i));
            next = String.valueOf(s.charAt(i + 1));

            String twoChars = cur + next;
            if (VAL_MAP.get(twoChars) == null) {
                value += VAL_MAP.get(cur);
            } else {
                value += VAL_MAP.get(twoChars);
                i++;
            }

            i++;
        }

        if (i == s.length() - 1) {
            //handle the last character
            value += VAL_MAP.get(String.valueOf(s.charAt(i)));
        }
        return value;
    }
}
