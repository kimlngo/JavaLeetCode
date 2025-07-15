package com.kimlngo.leetcode.mocktest;

import java.util.*;

public class MockTestThirtySeven {
    public static void main(String[] args) {
        var sol = new MockTestThirtySeven();

        System.out.println(sol.letterCombinations("5486"));
    }

    private static final Map<Integer, List<String>> DIGIT_MAP = new HashMap<>();

    static {
        DIGIT_MAP.put(2, Arrays.asList("a", "b", "c"));
        DIGIT_MAP.put(3, Arrays.asList("d", "e", "f"));
        DIGIT_MAP.put(4, Arrays.asList("g", "h", "i"));
        DIGIT_MAP.put(5, Arrays.asList("j", "k", "l"));
        DIGIT_MAP.put(6, Arrays.asList("m", "n", "o"));
        DIGIT_MAP.put(7, Arrays.asList("p", "q", "r", "s"));
        DIGIT_MAP.put(8, Arrays.asList("t", "u", "v"));
        DIGIT_MAP.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.isEmpty())
            return result;

        if (digits.length() == 1)
            return mapDigitToChar(getNumber(digits.charAt(0)));
        else
            return generateCombinations(digits);
    }

    private List<String> generateCombinations(String s) {
        List<String> result = new ArrayList<>();

        //len: 2, 3, 4
        for (char c : s.toCharArray()) {
            int d = getNumber(c);

            if (result.isEmpty()) {
                result.addAll(mapDigitToChar(d));
            } else {
                List<String> tmp = new ArrayList<>();
                for (String r : result) {
                    for (String combination : mapDigitToChar(d)) {
                        tmp.add(r + combination);
                    }
                }
                result = tmp;
            }
        }

        return result;
    }

    private int getNumber(char c) {
        return c - '0';
    }

    private static List<String> mapDigitToChar(int d) {
        if (d < 2 || d > 9) return new ArrayList<>();

        return DIGIT_MAP.get(d);
    }
}

