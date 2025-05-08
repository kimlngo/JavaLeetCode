package com.kimlngo.leetcode.algomap.stack;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(calPoints(new String[]{"1", "C"}));
    }

    private static int calPoints(String[] operations) {
        Stack<Integer> intStack = new Stack<>();

        for (String s : operations) {
            switch (s) {
                case "+" -> {
                    var score1 = intStack.pop();
                    var score2 = intStack.pop();

                    intStack.push(score2);
                    intStack.push(score1);
                    intStack.push(score1 + score2);
                }
                case "D" -> {
                    var score = intStack.peek();
                    intStack.push(score * 2);
                }
                case "C" -> intStack.pop();
                case null, default -> intStack.push(Integer.parseInt(s));
            }
        }

        return intStack.stream()
                       .mapToInt(Integer::intValue)
                       .sum();
    }
}
