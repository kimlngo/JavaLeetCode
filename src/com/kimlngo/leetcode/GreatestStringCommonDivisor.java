package com.kimlngo.leetcode;

public class GreatestStringCommonDivisor {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisorString("ABCDEF", "ABC"));
        System.out.println(greatestCommonDivisorString("ABABAB", "ABAB"));
        System.out.println(greatestCommonDivisorString("LEET", "CODE"));
    }

    private static String greatestCommonDivisorString(String str1, String str2) {
        int i = 0, j = 0;
        int len1 = str1.length(), len2 = str2.length();
        int greatestCommonLen = greatestCommonDivisor(len1, len2);

        StringBuilder sb = new StringBuilder();

        while (i < len1 && j < len2
                && sb.length() < greatestCommonLen &&
                str1.charAt(i) == str2.charAt(j)) {
            sb.append(str1.charAt(i));
            i++;
            j++;
        }

        if(!sb.isEmpty() && isDividable(str1, sb.toString()) && isDividable(str2, sb.toString()))
            return sb.toString();
        else
            return "";
    }

    private static int greatestCommonDivisor(int len1, int len2) {
        int minLength = Math.min(len1, len2);
        int common = 1;

        for (int i = 2; i <= minLength; i++) {
            if (len1 % i == 0 && len2 % i == 0)
                common = i;
        }

        return common;
    }

    private static boolean isDividable(String str, String x) {
        int multiple = str.length() / x.length();
        StringBuilder sb = new StringBuilder();

        sb.append(x.repeat(multiple));

        return str.contentEquals(sb);
    }
}
