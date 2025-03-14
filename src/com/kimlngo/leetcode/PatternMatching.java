package com.kimlngo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("jquery", "jquery"));
    }

    private static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            Character p = Character.valueOf(pattern.charAt(i));
            String word = words[i];

            if (charMap.get(p) == null) charMap.put(p, word);
            else {
                if (!charMap.get(p)
                            .equals(word)) return false;
            }

            if (wordMap.get(word) == null) wordMap.put(word, p);
            else {
                if (!wordMap.get(word)
                            .equals(p)) return false;
            }
        }

        return true;
    }
}
