package com.kimlngo.leetcode.mocktest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MockTestThirtyFour {
    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public static void main(String[] args) {
        MockTestThirtyFour sol = new MockTestThirtyFour();
        System.out.println(sol.generateParenthesis(4));
    }

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * Example 1:
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     *
     * Example 2:
     * Input: n = 1
     * Output: ["()"]
     *
     * Constraints:
     *     1 <= n <= 8
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        Node34 root = new Node34(String.valueOf(OPEN));

        Queue<Node34> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            var node = queue.poll();
            expandLeftRight(node, n);

            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        List<String> result = new ArrayList<>();
        getLeafNodes(root, result);

        return result;
    }

    private void getLeafNodes(Node34 node, List<String> result) {
        if(node.left == null && node.right == null)
            result.add(node.val);

        if(node.left != null) getLeafNodes(node.left, result);
        if(node.right != null) getLeafNodes(node.right, result);
    }

    private void expandLeftRight(Node34 node, int n) {
        if (node == null)
            return;

        ParenthesesCount count = countParentheses(node.val);
        int openCount = count.openCount;
        int closeCount = count.closeCount;

        if (openCount == n && closeCount == n)
            return;

        if (openCount < n) {
            node.left = new Node34(node.val + OPEN);
        }

        if (closeCount < n && closeCount < openCount) {
            node.right = new Node34(node.val + CLOSE);
        }
    }

    private ParenthesesCount countParentheses(String s) {
        ParenthesesCount count = new ParenthesesCount();

        for(char c : s.toCharArray()) {
            if(c == OPEN)
                count.addOneOpenCount();
            else
                count.addOneCloseCount();
        }

        return count;
    }

}

class Node34 {
    String val;
    Node34 left, right;

    public Node34(String val) {
        this.val = val;
    }
}

class ParenthesesCount {
    int openCount;
    int closeCount;

    public ParenthesesCount() {
        this.openCount = 0;
        this.closeCount = 0;
    }

    public void addOneOpenCount() {
        this.openCount++;
    }

    public void addOneCloseCount() {
        this.closeCount++;
    }
}