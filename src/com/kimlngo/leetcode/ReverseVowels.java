package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseVowels {
    public static void main(String[] args) {
        String s = "IceCreAm";

        System.out.println(reverseVowels(s));
    }

    private static String reverseVowels(String s) {
        final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Integer> vowelIndex = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (VOWELS.contains(Character.toLowerCase(s.charAt(i)))) {
                vowelIndex.add(i);
            }
        }
        System.out.println(vowelIndex);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(vowelIndex.contains(i)) {
                int leftIndex = vowelIndex.indexOf(i);
                int rightIndex = vowelIndex.get(vowelIndex.size() - 1 - leftIndex);

                sb.append(s.charAt(rightIndex));
            } else sb.append(s.charAt(i));

        }
        return sb.toString();
    }
}
