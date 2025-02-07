package com.kimlngo.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueNumberOccurrence {
    public static void main(String[] args) {
        System.out.println(isUniqueOccurred(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(isUniqueOccurred(new int[]{1, 2}));
        System.out.println(isUniqueOccurred(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));

    }

    private static boolean isUniqueOccurred(int[] arr) {
        Map<Integer, Long> freqCounter = Arrays.stream(arr)
                                               .boxed()
                                               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Long, List<Integer>> occurrence = new HashMap<>();
        freqCounter.forEach((key, value) -> {
            if (!occurrence.containsKey(value)) {
                occurrence.put(value, new ArrayList<>());
            }

            occurrence.get(value)
                      .add(key);
        });

        return occurrence.values()
                         .stream()
                         .noneMatch(list -> list.size() > 1);
    }
}
