package com.kimlngo.leetcode.mocktest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MockTestFifteen {
    public static void main(String[] args) {
        MockTestFifteen sol = new MockTestFifteen();

        System.out.println(sol.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(sol.countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }

    /**
     * You are given an array of strings words and a string chars.
     * <p>
     * A string is good if it can be formed by characters from chars (each character can only be used once for each word in words).
     * <p>
     * Return the sum of lengths of all good strings in words.
     * <p>
     * Example 1:
     * <p>
     * Input: words = ["cat","bt","hat","tree"], chars = "atach"
     * Output: 6
     * Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
     * <p>
     * Example 2:
     * <p>
     * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
     * Output: 10
     * Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10
     *
     * @param words
     * @param chars
     * @return character count of all good words
     */
    private int countCharacters(String[] words, String chars) {
        //1) build freq map for chars
        var inventoryChars = buildFreqMap(chars);

        //2) build freq map for each word in words
        List<String> goodWords = new ArrayList<>();

        //3) iterate through words, and compare characters in word with char in chars
        //if chars contains more chars than word requires -> word is good, otherwise continue
        for (var word : words) {
            var wordMap = buildFreqMap(word);
            boolean isGoodWord = true;

            for (var c : wordMap.keySet()) {
                if (inventoryChars.get(c) == null ||
                        wordMap.get(c) > inventoryChars.get(c)) {
                    isGoodWord = false;
                    break;
                }
            }

            if (isGoodWord)
                goodWords.add(word);
        }

        //4) map each word into length and then return the total sum
        return goodWords.stream()
                        .mapToInt(String::length)
                        .sum();
    }

    private Map<Character, Long> buildFreqMap(String s) {
        return s.chars()
                .mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
