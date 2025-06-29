package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MockTestThirtyOne {
    public static void main(String[] args) {
        MockTestThirtyOne solution = new MockTestThirtyOne();

        TreeNode root = new TreeNode(1);
//        TreeNode three = new TreeNode(3);
//        TreeNode two = new TreeNode(2);
//
//        TreeNode five = new TreeNode(5);
//        TreeNode six = new TreeNode(6);
//        TreeNode nine = new TreeNode(9);
//        TreeNode seven = new TreeNode(7);
//
//        root.left = three;
//        root.right = two;
//
//        three.left = five;
//        five.left = six;
//        two.right = nine;
//        nine.left = seven;

        System.out.println(solution.widthOfBinaryTree(root));
    }

    public int widthOfBinaryTree(TreeNode root) {
        List<List<TreeNode>> allLevels = bfsByLevels(root);

        return allLevels.stream()
                        .mapToInt(this::matchWidth)
                        .max()
                        .orElse(-1);
    }

    private List<List<TreeNode>> bfsByLevels(TreeNode node) {
        List<List<TreeNode>> allLevels = new ArrayList<>();

        CustomQueue<TreeNode> queue = new CustomQueue<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();

            int queueSize = queue.size();
            //number of dequeue by level
            for (int i = 0; i < queueSize; i++) {
                TreeNode n = queue.remove();
                level.add(n);

                if (n != null) {
                    queue.add(n.left);
                    queue.add(n.right);
                } else {
                    queue.add(null);
                    queue.add(null);
                }
            }

            allLevels.add(level);
        }
        return allLevels;
    }

    private int matchWidth(List<TreeNode> list) {
        int start = 0, end = 0, count = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != null) {
                count++;
                if(start == 0)
                    start = i + 1;
                else
                    end = i + 1;
            }
        }
        if(count == 1) return count;

        return end - start + 1;
    }
}

class CustomQueue<E> {
    private List<E> elements;

    public CustomQueue() {
        elements = new ArrayList<>();
    }

    public int size() {
        return this.elements.size();
    }

    public void add(E e) {
        this.elements.add(e);
    }

    public E remove() {
        E poll = elements.getFirst();
        elements = elements.subList(1, elements.size());
        return poll;
    }

    public boolean isEmpty() {
        return this.elements.isEmpty() || this.elements.stream().allMatch(Objects::isNull);
    }

    @Override
    public String toString() {
        return "CustomQueue{" +
                "elements=" + elements +
                '}';
    }
}
