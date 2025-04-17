package com.kimlngo.leetcode.algomap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxNoOfBalloon {
    private static final List<Character> BALLOON_CHARS = Arrays.asList('b', 'a', 'l', 'o', 'n');

    public static void main(String[] args) {
        System.out.println(maxNoOfBalloons("nlaeboklo"));
        System.out.println(maxNoOfBalloons("loonbalxballpoon"));
        System.out.println(maxNoOfBalloons("leetcode"));
    }

    private static int maxNoOfBalloons(String text) {
        var freqCounter = createFreqCounterMap(text);

        for (Character c : BALLOON_CHARS) {
            if (freqCounter.get(c) == null) return 0;
        }

        freqCounter.put('l', freqCounter.get('l') / 2);
        freqCounter.put('o', freqCounter.get('o') / 2);

        List<Long> charCount = freqCounter.entrySet()
                                          .stream()
                                          .filter(entry -> BALLOON_CHARS.contains(entry.getKey()))
                                          .map(Map.Entry::getValue)
                                          .toList();

        return (int) charCount.stream()
                              .mapToLong(Long::longValue)
                              .min()
                              .orElse(0);

    }

    private static Map<Character, Long> createFreqCounterMap(String text) {
        return text.chars()
                   .mapToObj(c -> (char) c)
                   .collect(
                           Collectors.groupingBy(Function.identity(), Collectors.counting())
                   );
    }
}
