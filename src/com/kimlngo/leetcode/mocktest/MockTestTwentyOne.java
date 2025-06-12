package com.kimlngo.leetcode.mocktest;

import java.util.*;

public class MockTestTwentyOne {

    public static void main(String[] args) {
        var sol = new MockTestTwentyOne();

        System.out.println(sol.romanToInt("III")); //3
        System.out.println(sol.romanToInt("LVIII")); //58
        System.out.println(sol.romanToInt("MCMXCIV")); //1994

    }

    private int romanToInt(String s) {
        int value = 0, i = 0;
        Map<String, Integer> valMap = createValMap();

        String cur, next;
        var splits = s.split("");

        while (i < s.length() - 1) {
            cur = splits[i];
            next = splits[i + 1];

            String twoChars = cur + next;
            if (valMap.get(twoChars) == null) {
                value += valMap.get(cur);
            } else {
                value += valMap.get(twoChars);
                i++;
            }

            i++;
        }

        if (i == s.length() - 1) {
            //handle the last character
            value += valMap.get(splits[i]);
        }
        return value;
    }

    private Map<String, Integer> createValMap() {
        Map<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        //special case
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        return map;
    }
}
