package com.kimlngo.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class MockTestTwentyEight {

    public static void main(String[] args) {
        MockTestTwentyEight sol = new MockTestTwentyEight();

        System.out.println("===== Q1 =====");
        System.out.println(sol.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(sol.commonChars(new String[]{"cool", "lock", "cook"}));

        System.out.println("===== Q2 =====");
        System.out.println("RLRRLLRLRL" + " balance subString count: " + sol.balancedStringSplit("RLRRLLRLRL")); //4
        System.out.println("RLRRRLLRLL" + " balance subString count: " + sol.balancedStringSplit("RLRRRLLRLL")); //2
        System.out.println("LLLLRRRR" + " balance subString count: " + sol.balancedStringSplit("LLLLRRRR"));     //1
    }

    /**
     * Question 1
     * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
     * Example 1:
     *
     * Input: words = ["bella","label","roller"]
     * Output: ["e","l","l"]
     *
     * Example 2:
     *
     * Input: words = ["cool","lock","cook"]
     * Output: ["c","o"]
     * @param words
     * @return
     */
    public List<String> commonChars(String[] words) {
        //1) Generate freq counter map for each word and add it into a List
        List<Map<Character, Long>> listMap = Arrays.stream(words)
                                                   .map(this::createFreqCounterMap)
                                                   .toList();

        //2) Get the set of characters in all the keys
        Set<Character> allChars = getAllUniqueChars(listMap);

        //3) Among these chars, find out the chars that appear in all words
        Set<Character> commonChars = allChars.stream()
                                             .filter(c -> this.containsInAllMaps(c, listMap))
                                             .collect(Collectors.toSet());

        Map<Character, Long> commonCharsFreq = new HashMap<>();

        //4) Find out the minimum appearance of each common character in the List<Map<Character, Long>>
        for (Character c : commonChars) {
            commonCharsFreq.put(c,
                    listMap.stream()
                           .mapToLong(m -> m.get(c))
                           .min()
                           .orElse(-1));
        }

        //5) Regenerate the List<String> (by repeating the Character) and return the result
        List<String> result = new ArrayList<>();

        commonCharsFreq.forEach((key, value)
                -> LongStream.range(0, value)
                             .forEach((i) -> result.add(key.toString())));

        return result;
    }

    private boolean containsInAllMaps(Character c, List<Map<Character, Long>> listMap) {
        return listMap.stream()
                      .map(Map::keySet)
                      .allMatch(set -> set.contains(c));
    }

    private Map<Character, Long> createFreqCounterMap(String word) {
        return
                word.chars()
                    .mapToObj(a -> (char) a)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Set<Character> getAllUniqueChars(List<Map<Character, Long>> listMap) {
        return listMap.stream()
                      .map(Map::keySet)
                      .flatMap(Set::stream)
                      .collect(Collectors.toSet());
    }

    /**
     * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
     *
     * Given a balanced string s, split it into some number of substrings such that:
     *
     * Each substring is balanced.
     *
     * Return the maximum number of balanced strings you can obtain
     *
     * Example 1:
     *
     * Input: s = "RLRRLLRLRL"
     * Output: 4
     * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
     *
     * Example 2:
     *
     * Input: s = "RLRRRLLRLL"
     * Output: 2
     * Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
     * Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
     *
     * Example 3:
     *
     * Input: s = "LLLLRRRR"
     * Output: 1
     * Explanation: s can be split into "LLLLRRRR".
     *
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int leftCount = 0, rightCount = 0;
        int balancedCount = 0;

        for(char c : s.toCharArray()) {
            if(c == 'L') {
                leftCount++;
            } else
                rightCount++;

            if(leftCount == rightCount) {
                //found the substring
                balancedCount++;
                leftCount = 0;
                rightCount = 0;
            }
        }
        return balancedCount;
    }
}
