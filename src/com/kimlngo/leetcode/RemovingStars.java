package com.kimlngo.leetcode;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemovingStars {
    public static void main(String[] args) {
        String input = "leet**cod*e";
        System.out.println(removeStars(input));
    }

    private static String removeStars(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c != '*') stack.push(Character.valueOf(c));
            else stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack)
            sb.append(c.toString());
        return sb.toString();
    }
}
