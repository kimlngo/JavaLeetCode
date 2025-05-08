package com.kimlngo.leetcode.algomap.stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));

    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer n1, n2;

        for (var s : tokens) {
            switch (s) {
                case "+" -> {
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 + n1);
                }

                case "-" -> {
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 - n1);
                }

                case "*" -> {
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 * n1);
                }

                case "/" -> {
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 / n1);
                }

                default -> stack.push(Integer.parseInt(s));

            }
        }
        return stack.pop();
    }
}
