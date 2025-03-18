package com.kimlngo.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String input = "){";
        System.out.println(input + " is valid parentheses? - " + isValid(input) );
    }

    private static boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;

        final List<Character> OPEN_CHAR = Arrays.asList('(', '{', '[');
        final List<Character> CLOSE_CHAR = Arrays.asList(')', '}', ']');
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(OPEN_CHAR.contains(c)) stack.push(c);
            else if(stack.isEmpty() && CLOSE_CHAR.contains(c)) return false;
            else {
                Character pop = stack.pop();
                if(pop.equals('(') && !c.equals(')')) return false;
                else if(pop.equals('{') && !c.equals('}')) return false;
                else if(pop.equals('[') && !c.equals(']')) return false;
            }
        }

        return stack.isEmpty();
    }
}
