package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.*;

public class MockTestFour {
    private final List<Character> VOWELS_LOWER_CASE = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private final List<Character> VOWELS_UPPER_CASE = Arrays.asList('A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) {
        var test = new MockTestFour();

        System.out.println(test.reverseVowels("IceCream"));
        System.out.println(test.reverseVowels("leetcode"));
    }

    //Question 1
    /*
    Given a string s, reverse only all the vowels in the string and return it.
    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
     */
    private String reverseVowels(String s) {
        char[] charArr = s.toCharArray();

        int left = 0, right = charArr.length - 1;
        char leftChar, rightChar;

        while (left < right) {
            leftChar = charArr[left];
            rightChar = charArr[right];

            if (isVowel(leftChar) && isVowel(rightChar)) {
                //swap
                char tmp = leftChar;
                charArr[left] = charArr[right];
                charArr[right] = tmp;

                left++;
                right--;
            } else if (isVowel(leftChar)) {
                //move right pointer
                right--;

            } else if (isVowel(rightChar)) {
                //move left pointer
                left++;

            } else {
                //move both pointer
                left++;
                right--;
            }
        }

        return new String(charArr);
    }

    private boolean isVowel(char c) {
        return VOWELS_LOWER_CASE.contains(c) || VOWELS_UPPER_CASE.contains(c);
    }

    //Question 2
    /*
    Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
     */
    public List<Integer> largestValues(TreeNode root) {
        //corner case
        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int qLength = queue.size();
            List<TreeNode> sameLevel = new ArrayList<>();

            for(int i = 0; i < qLength; i++) {
                TreeNode node = queue.remove();
                sameLevel.add(node);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            result.add(findMaxValue(sameLevel));
        }

        return result;
    }

    private Integer findMaxValue(List<TreeNode> sameLevel) {
        int maxVal = -2147483648;

        for(var node : sameLevel) {
            if(node.val > maxVal) {
                maxVal = node.val;
            }
        }
        return maxVal;
    }
}
