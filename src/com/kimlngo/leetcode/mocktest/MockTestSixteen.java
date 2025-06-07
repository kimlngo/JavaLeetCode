package com.kimlngo.leetcode.mocktest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MockTestSixteen {
    public static void main(String[] args) {
        var sol = new MockTestSixteen();
        System.out.println(sol.removeOuterParentheses("(()())(())"));
        System.out.println(sol.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(sol.removeOuterParentheses("()()"));
    }

    public String removeOuterParentheses(String s) {
        //1) split s into individual valid parentheses
        var parts = splitByParentheses(s);

        //2) remove the () of each individual
        //3) join the contents
        return parts.stream()
                    .map(p -> p.substring(1, p.length() - 1))
                    .collect(Collectors.joining());
    }

    private List<String> splitByParentheses(String s) {
        var stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        var list = new ArrayList<String>();

        for (var c : s.toCharArray()) {
            sb.append(c);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return list;
    }
}
