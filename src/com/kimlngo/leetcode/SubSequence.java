package com.kimlngo.leetcode;

public class SubSequence {
    public static void main(String[] args) {
//        System.out.println(isSubSequence("abc", "ahbgdc"));
//        System.out.println(isSubSequence("axc", "ahbgdc"));
        System.out.println(isSubSequence("b", "abc"));
    }

    private static boolean isSubSequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen == 0) return true;

        int sIdx = 0;
        int tIdx = 0;

        while (tIdx < tLen && sIdx < sLen) {
            if(s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
            }
            tIdx++;
        }

        return sIdx == sLen;
    }
}
