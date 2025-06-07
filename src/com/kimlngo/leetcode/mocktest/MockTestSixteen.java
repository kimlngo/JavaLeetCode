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
        //1) split s into individual valid parenthese
        var parts = splitByParenthese(s);

        //2) remove the () of each individual
        //3) join the contents
        return parts.stream()
                    .map(p -> p.substring(1, p.length() - 1))
                    .collect(Collectors.joining());
    }

    private List<String> splitByParenthese(String s) {
        var stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        var list = new ArrayList<String>();

        for (var c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                sb.append(c);
            } else {
                stack.pop();
                sb.append(c);

                if (stack.isEmpty()) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return list;
    }
}
