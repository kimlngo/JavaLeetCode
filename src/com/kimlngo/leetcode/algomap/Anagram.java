package com.kimlngo.leetcode.algomap;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        var sCharMap = createCharMap(s);
        var tCharMap = createCharMap(t);

        return isTwoMapSame(sCharMap, tCharMap) && isTwoMapSame(tCharMap, sCharMap);
    }

    private static Map<Character, Long> createCharMap(String word) {
        return word.chars()
                   .mapToObj(a -> (char) a)
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static boolean isTwoMapSame(Map<Character, Long> m1, Map<Character, Long> m2) {
        for (var c : m1.keySet()) {
            if (!m2.containsKey(c) || !m1.get(c)
                                         .equals(m2.get(c))) {
                return false;
            }
        }

        return true;
    }
}
