package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static void print2DArray(int[][] array) {
        String sb = "[\n\t" +
                Arrays.stream(array)
                      .map(Arrays::toString)
                      .collect(Collectors.joining(",\n\t")) +
                "\n]";
        System.out.println(sb);
    }

    /**
     * convert [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * to an array {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}}
     *
     * @param inputStr
     * @return
     */
    public static int[][] readInput2DArray(String inputStr) {
        String[] splits = inputStr.substring(2, inputStr.length() - 2)
                                  .split("],\\[");
        int rowCount = splits.length;
        int colCount = splits[0].split(",").length;

        int[][] result = new int[rowCount][colCount];

        for (int row = 0; row < rowCount; row++) {
            String[] numbers = splits[row].split(",");
            for (int col = 0; col < colCount; col++) {
                result[row][col] = Integer.parseInt(numbers[col]);
            }
        }
        return result;
    }

    /**
     * convert "[1,2,3]" into an int[] {1,2,3}
     *
     * @param input
     * @return
     */
    public static int[] readInput1DArray(String input) {
        return Arrays.stream(input.substring(1, input.length() - 1)
                                  .split(","))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }


    public static TreeNode constructTree(List<Integer> input) {
        //construct all tree nodes first
        List<TreeNode> treeNodeList = input.stream()
                                           .map(i -> {
                                               if (i == null) return null;
                                               return new TreeNode(i);
                                           })
                                           .toList();

        //create the edges
        TreeNode root = treeNodeList.getFirst();
        int maxIndex = (int) Math.floor(((double) treeNodeList.size() - 1) / 2);

        for (int i = 0; i <= maxIndex; i++) {
            TreeNode node = treeNodeList.get(i);
            if (node != null) {
                int leftChildIdx = 2 * i + 1;
                int rightChildIdx = 2 * i + 2;

                if (leftChildIdx >= treeNodeList.size()) node.left = null;
                else node.left = treeNodeList.get(leftChildIdx);

                if (rightChildIdx >= treeNodeList.size()) node.right = null;
                else node.right = treeNodeList.get(rightChildIdx);
            }
        }

        return root;
    }
}
