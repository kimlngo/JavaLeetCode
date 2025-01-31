package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        System.out.println(findKidsWithGreatestCandies_Iterative(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(findKidsWithGreatestCandies_Iterative(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(findKidsWithGreatestCandies_Iterative(new int[]{12, 1, 12}, 10));

    }

    private static List<Boolean> findKidsWithGreatestCandies_Iterative(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int c : candies)
            if (c > maxCandies) maxCandies = c;

        List<Boolean> result = new ArrayList<>();
        for (int c : candies)
            result.add(c + extraCandies >= maxCandies ? Boolean.TRUE : Boolean.FALSE);

        return result;
    }

    private static List<Boolean> findKidsWithGreatestCandies(int[] candies, int extraCandies) {
        int maxCandies = Arrays.stream(candies)
                               .max()
                               .getAsInt();

        return Arrays.stream(candies)
                     .map(candy -> candy + extraCandies)
                     .boxed()
                     .map(candy -> candy >= maxCandies)
                     .toList();

    }
}
