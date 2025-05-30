package com.kimlngo.leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Util {

    public static int[] readWaterTxt()
            throws IOException {
        String file = "src/com/kimlngo/leetcode/text/water.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();

        String[] splits = currentLine.split(",");
        int[] result = new int[splits.length];

        int min = Integer.parseInt(splits[0]);
        int max = min;
        for (int i = 0; i < splits.length; i++) {
            int cur = Integer.parseInt(splits[i]);
            if (cur < min) min = cur;
            if (cur > max) max = cur;

            result[i] = cur;
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        return result;
    }

    public static int[] readBinaryArray() throws IOException {
        String file = "src/com/kimlngo/leetcode/text/BinaryArray.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();

        String[] split = currentLine.split(",");
        return Arrays.stream(split)
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    public static String[] readAnagrams() throws IOException {
        String file = "src/com/kimlngo/leetcode/text/anagrams.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();

        String[] split = currentLine.substring(1, currentLine.length() - 1)
                                    .split(",");
        return split;
    }

    public static int[] readGas() throws IOException {
        return readIntArray("src/com/kimlngo/leetcode/text/gas.txt");
    }

    public static int[] readCost() throws IOException {
        return readIntArray("src/com/kimlngo/leetcode/text/cost.txt");
    }

    private static int[] readIntArray(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String currentLine = reader.readLine();
        reader.close();

        return Arrays.stream(currentLine.split(","))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    public static int[] readFruit() throws IOException {
        return readIntArray("src/com/kimlngo/leetcode/text/fruit.txt");
    }
}
