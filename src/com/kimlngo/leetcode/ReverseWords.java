package com.kimlngo.leetcode;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

    private static String reverseWords(String words) {
        String[] splits = words.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i = splits.length - 1; i >= 0; i--) {
            sb.append(splits[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
