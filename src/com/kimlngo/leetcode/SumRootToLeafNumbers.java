package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.List;
import java.util.Stack;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        var root = new TreeNode(4);
        var nine = new TreeNode(9);
        var five = new TreeNode(5);
        var one = new TreeNode(1);
        var zero = new TreeNode(0);

        root.left = nine;
        root.right = zero;

        nine.left = five;
        nine.right = one;

        System.out.println(sumNumbers(root));
    }

    private static int sumNumbers(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        SumHolder sumHolder = new SumHolder();
        traverse(root, stack, sumHolder);
        return sumHolder.getSum();
    }

    private static void traverse(TreeNode node, Stack<TreeNode> stack, SumHolder sumHolder) {
        if (node.left == null && node.right == null) {
            //reach the leaf node, calculate the sum of the path
            stack.push(node);
            int sum = sum(stack);
            sumHolder.setSum(sumHolder.getSum() + sum);

            stack.pop();
            return;
        }

        stack.push(node);
        if(node.left != null) traverse(node.left, stack, sumHolder);
        if(node.right != null) traverse(node.right, stack, sumHolder);
        stack.pop();
    }


    private static int sum(Stack<TreeNode> stack) {
        List<Integer> list = stack.stream()
                                  .map(node -> node.val)
                                  .toList();

        int sum = 0;
        int base, power;
        for (int i = 0; i < list.size(); i++) {
            base = list.get(i);
            power = (int) Math.pow(10, list.size() - i - 1);

            sum += base * power;
        }
        return sum;
    }

}

class SumHolder {
    private int sum;

    public SumHolder() {
        sum = 0;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
