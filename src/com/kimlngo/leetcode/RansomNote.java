package com.kimlngo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
//        System.out.println(canConstruct("a", "b"));
//        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("aab", "aa"));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomFreqMap = createFreqCounterMap(ransomNote);
        Map<Character, Integer> magFreqMap = createFreqCounterMap(magazine);

        for (Character key : ransomFreqMap.keySet()) {
            if (magFreqMap.get(key) == null ||
                    magFreqMap.get(key)
                              .compareTo(ransomFreqMap.get(key)) < 0) return false;
        }
        return true;
    }

    private static Map<Character, Integer> createFreqCounterMap(String input) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            Character key = Character.valueOf(c);
            if (freqMap.get(key) == null) {
                freqMap.put(key, 0);
            }

            freqMap.put(key, freqMap.get(key) + 1);
        }

        return freqMap;
    }
}
