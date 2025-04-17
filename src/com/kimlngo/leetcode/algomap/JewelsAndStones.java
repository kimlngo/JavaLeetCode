package com.kimlngo.leetcode.algomap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    private static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Long> stoneMap = stones.chars()
                .mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        Set<Character> jewelSet = jewels.chars()
                .mapToObj(a -> (char) a)
                .collect(Collectors.toSet());

        int jewelCount = 0;
        for (Character c : stoneMap.keySet()) {
            if (jewelSet.contains(c)) {
                jewelCount += stoneMap.get(c);
            }
        }

        return jewelCount;
    }
}
