package com.kimlngo.leetcode.mocktest;

public class MockTestTwelve {

    public static void main(String[] args) {
        String s = "ababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaa";

        System.out.println(repeatedSubstringPattern(s));
    }

    private static boolean repeatedSubstringPattern(String s) {
        int len = s.length();

        if (len == 1) return false;
        String sub;
        for (int i = 1; i <= (int) Math.floor((double) len / 2); i++) {
            sub = s.substring(0, i);

            if (len % sub.length() == 0) {
                String reProduce = sub.repeat(len / sub.length());
                if (reProduce.equals(s)) {
                    System.out.println(sub);
                    return true;
                }
            }
        }
        return false;
    }
}
