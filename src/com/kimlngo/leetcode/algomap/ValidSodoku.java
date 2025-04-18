package com.kimlngo.leetcode.algomap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSodoku {
    private static final int SIZE = 9;

    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '6', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board) {
        // check for all the rows
        System.out.println("check for all the rows");
        for (int row = 0; row < SIZE; row++) {
            System.out.println(Arrays.toString(board[row]));
            if (containsDuplicate(board[row]))
                return false;
        }

        //check for all the columns
        System.out.println("\ncheck for all the columns");
        for (int col = 0; col < SIZE; col++) {
            char[] columnChars = new char[SIZE];
            for (int row = 0; row < SIZE; row++) {
                columnChars[row] = board[row][col];
            }

            System.out.println(Arrays.toString(columnChars));
            if (containsDuplicate(columnChars))
                return false;
        }

        //check all the boxes
        System.out.println("\ncheck for all the boxes");
        for (int row = 0; row <= 2; row++) {
            for(int col = 0; col <= 2; col++) {
                System.out.println(Arrays.toString(extractSubBox(row, col, board)));
                if(containsDuplicate(extractSubBox(row, col, board)))
                    return false;
            }
        }

        return true;
    }

    //row: 0 -> 2, col 0 -> 2
    private static char[] extractSubBox(int row, int col, char[][] board) {
        char[] box = new char[SIZE];
        int index = 0;
        for (int r = 3 * row; r <= 3 * row + 2; r++) {
            for (int c = 3 * col; c <= 3 * col + 2; c++) {
                box[index++] = board[r][c];
            }
        }
        return box;
    }

    //return true if contains duplicate, otherwise false
    private static boolean containsDuplicate(char[] array) {
        Set<Character> charSet = new HashSet<>();

        for (char c : array) {
            if (c != '.') {
                if (!charSet.contains(c))
                    charSet.add(c);
                else return true;
            }
        }

        return false;
    }
}
