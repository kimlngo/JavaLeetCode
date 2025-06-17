package com.kimlngo.leetcode.mocktest;

public class MockTestTwentyFour {
    public static void main(String[] args) {
        var sol = new MockTestTwentyFour();
        System.out.println(sol.removeKdigits("33526221184202197273", 19));
    }

    public String removeKdigits(String num, int k) {
        int len = num.length();

        if (k == len) return "0";

        //remove first k digits as the first starting number
        String min = removeLeadingZeros(num.substring(k));
        System.out.println("min: " + min);

        String candidate;
        for (int i = 1; i <= len - k; i++) {
            //get a new number from num by removing k digit starting from i
            candidate = removeLeadingZeros(removeKDigits(num, i, k));
            System.out.printf("i: %d, candidate: %s, min: %s\n", i, candidate, min);
            if (getSmallerNumber(candidate, min)) {
                min = candidate;
            }
        }

        return min;
    }

    private String removeKDigits(String num, int i, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(num.substring(0, i));
        sb.append(num.substring(i + k));
        return sb.toString();
    }

    //n1 & n2 have the same length, we iterate backward to find out
    //if n1 is smaller than n2, if so return true, else return false;
    private boolean getSmallerNumber(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 < len2) return true;
        else if (len1 > len2) return false;

        //same length
        int n1, n2;
        for (int i = 0; i < len1; i++) {
            n1 = getNumber(num1.charAt(i));
            n2 = getNumber(num2.charAt(i));

            if (n1 < n2) return true;
            else if (n1 > n2) return false;

        }

        return true;
    }

    private int getNumber(char c) {
        return c - '0';
    }

    private String removeLeadingZeros(String num) {
        if (!num.startsWith("0"))
            return num;

        //find the index which is not zero
        int i = 1;
        while (i < num.length()) {
            if (getNumber(num.charAt(i)) != 0)
                return num.substring(i);

            i++;
        }
        return "0";
    }
}