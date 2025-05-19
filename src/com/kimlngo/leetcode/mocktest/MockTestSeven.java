package com.kimlngo.leetcode.mocktest;

import java.util.ArrayList;
import java.util.List;

public class MockTestSeven {
    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));

        System.out.println(largestTimeFromDigits(new int[]{5, 5, 5, 5}));
    }

    private static String largestTimeFromDigits(int[] arr) {
        List<String> all = generateAllStrings(arr);

        List<String> filtered = filterInvalidEntries(all);
        if (filtered.isEmpty()) return "";

        List<String> sorted = sortHourMinute(filtered);
        String largest = sorted.getFirst();

        return largest.substring(0, 2) + ":" + largest.substring(2);
    }

    private static List<String> sortHourMinute(List<String> all) {
        return all.stream()
                  .sorted((t1, t2) -> {
                      int h1 = extractHour(t1);
                      int m1 = extractMinute(t1);

                      int h2 = extractHour(t2);
                      int m2 = extractMinute(t2);

                      if (h1 != h2)
                          return h2 - h1;
                      else
                          return m2 - m1;
                  })
                  .toList();
    }

    private static int extractHour(String time) {
        return Integer.parseInt(time.substring(0, 2));
    }

    private static int extractMinute(String time) {
        return Integer.parseInt(time.substring(2));
    }

    private static List<String> filterInvalidEntries(List<String> all) {
        return all.stream()
                  .filter(time -> {
                      int hour = extractHour(time);
                      int minute = extractMinute(time);

                      return hour <= 23 && minute <= 59;
                  })
                  .toList();
    }

    private static List<String> generateAllCombinations(int[] arr) {
        List<String> all = new ArrayList<>();

        all.add(String.format("%d%d%d%d", arr[0], arr[1], arr[2], arr[3]));
        all.add(String.format("%d%d%d%d", arr[0], arr[1], arr[3], arr[2]));

        all.add(String.format("%d%d%d%d", arr[0], arr[2], arr[1], arr[3]));
        all.add(String.format("%d%d%d%d", arr[0], arr[2], arr[3], arr[1]));

        all.add(String.format("%d%d%d%d", arr[0], arr[3], arr[1], arr[2]));
        all.add(String.format("%d%d%d%d", arr[0], arr[3], arr[2], arr[1]));

        all.add(String.format("%d%d%d%d", arr[1], arr[0], arr[2], arr[3]));
        all.add(String.format("%d%d%d%d", arr[1], arr[0], arr[3], arr[2]));

        all.add(String.format("%d%d%d%d", arr[1], arr[2], arr[0], arr[3]));
        all.add(String.format("%d%d%d%d", arr[1], arr[2], arr[3], arr[0]));

        all.add(String.format("%d%d%d%d", arr[1], arr[3], arr[0], arr[2]));
        all.add(String.format("%d%d%d%d", arr[1], arr[3], arr[2], arr[0]));

        all.add(String.format("%d%d%d%d", arr[2], arr[0], arr[1], arr[3]));
        all.add(String.format("%d%d%d%d", arr[2], arr[0], arr[3], arr[1]));

        all.add(String.format("%d%d%d%d", arr[2], arr[1], arr[0], arr[3]));
        all.add(String.format("%d%d%d%d", arr[2], arr[1], arr[3], arr[0]));

        all.add(String.format("%d%d%d%d", arr[2], arr[3], arr[0], arr[1]));
        all.add(String.format("%d%d%d%d", arr[2], arr[3], arr[1], arr[0]));

        all.add(String.format("%d%d%d%d", arr[3], arr[0], arr[1], arr[2]));
        all.add(String.format("%d%d%d%d", arr[3], arr[0], arr[2], arr[1]));

        all.add(String.format("%d%d%d%d", arr[3], arr[1], arr[0], arr[2]));
        all.add(String.format("%d%d%d%d", arr[3], arr[1], arr[2], arr[0]));

        all.add(String.format("%d%d%d%d", arr[3], arr[2], arr[0], arr[1]));
        all.add(String.format("%d%d%d%d", arr[3], arr[2], arr[1], arr[0]));

        return all;
    }

    private static List<String> generateAllStrings(int[] arr) {
        int len = arr.length;
        List<String> result = new ArrayList<>();

        for (int a = 0; a < len; a++) {
            for (int b = 0; b < len; b++) {
                if (b == a) continue;

                for (int c = 0; c < len; c++) {
                    if (c == b || c == a) continue;

                    for (int d = 0; d < len; d++) {
                        if (d == a || d == b || d == c) continue;

                        result.add(String.format("%d%d%d%d", arr[a], arr[b], arr[c], arr[d]));
                    }
                }
            }
        }

        return result;
    }
}
