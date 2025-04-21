package com.kimlngo.leetcode.algomap;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    private static int majorityElement(int[] nums) {
        //1) construct the frequency counter map
        // Map<Integer, Long>
        Map<Integer, Long> freqMap = Arrays.stream(nums)
                                           .boxed()
                                           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqMap);
        //2) calculate the threshold to be considered as majority
        int majThreshold = nums.length / 2;
        System.out.println(majThreshold);

        //3) find the majority element by comparing each frequency with the threshold
        Integer i = freqMap.entrySet()
                           .stream()
                           .filter(entry -> entry.getValue() > majThreshold)
                           .findFirst()
                           .map(Map.Entry::getKey)
                           .orElse(null);

        assert i != null;
        return i;
    }
}
