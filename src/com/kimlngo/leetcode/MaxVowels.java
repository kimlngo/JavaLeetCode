package com.kimlngo.leetcode;

public class MaxVowels {

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    private static int maxVowels(String s, int k) {
        int maxCount = 0;

        //initial window
        for (int i = 0; i < k; i++) {
            System.out.println(s.charAt(i));
            if(isVowel(s.charAt(i))) maxCount++;
        }

        int count = maxCount;
        for(int i = 1; i <= s.length() - k; i++) {
            System.out.println("remove: " + s.charAt(i - 1) + " | added: " + s.charAt(i + k - 1));

            if(isVowel(s.charAt(i - 1))) count--;
            if(isVowel(s.charAt(i + k - 1))) count++;

            if(count > maxCount) maxCount = count;
        }

        return maxCount;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
