package com.kimlngo.leetcode;

import java.util.Arrays;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappyNumber(2));
    }

    private static boolean isHappyNumber(int n) {
        int[] digits = spreadNumber(n);
        int loopCount = 100;
        int sum = 0;
        while(loopCount > 0) {
            for(int i : digits) {
                sum += i * i;
            }

            if(sum == 1) return true;
            digits = spreadNumber(sum);
            sum = 0;
            loopCount--;
        }
        return false;
    }

    private static int[] spreadNumber(int n) {
        int noOfDigit = String.valueOf(n)
                              .length();
        int[] digits = new int[noOfDigit];

        for (int i = noOfDigit - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n = n / 10;
        }

        return digits;
    }
}
