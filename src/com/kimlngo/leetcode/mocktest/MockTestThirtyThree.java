package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MockTestThirtyThree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        var three = new TreeNode(3);
        var six = new TreeNode(6);
        var two = new TreeNode(2);
        var four = new TreeNode(4);
        var seven = new TreeNode(7);

        root.left = three;
        root.right = six;

        three.left = two;
        three.right = four;

        six.right = seven;

        var sol = new MockTestThirtyThree();

        System.out.println("==== Test 1 ====");
        System.out.println(sol.findTarget(root, 9));
        System.out.println(sol.findTarget(root, 28));

        System.out.println("==== Test 2 ====");
        System.out.println(sol.gcdOfStrings("ABCABC", "ABC")); //ABC
        System.out.println(sol.gcdOfStrings("ABABAB", "ABAB")); //AB
        System.out.println(sol.gcdOfStrings("BABABA", "ABAB")); //AB
        System.out.println(sol.gcdOfStrings("LEET", "CODE")); //Empty String
    }

    /**
     * Given the root of a binary search tree and an integer k,
     * return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
     * <p>
     * Example:
     * Input: root = [5,3,6,2,4,null,7], k = 9
     * Output: true
     * <p>
     * Input: root = [5,3,6,2,4,null,7], k = 28
     * Output: false
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inOrderTraverse = new ArrayList<>();

        inOrderTraverse(root, inOrderTraverse);

        return findPair(inOrderTraverse, k);
    }

    private boolean findPair(List<Integer> list, int target) {
        int size = list.size();

        if (size == 1) return false;
        else if (size == 2) {
            return target == (list.getFirst() + list.getLast());
        }

        int min = list.get(0) + list.get(1);
        int max = list.get(size - 2) + list.getLast();

        // validation check
        if (target < min || target > max) return false;

        // two-pointer approach
        int left = 0, right = size - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) return true;
            else if (sum > target) right--;
            else left++;
        }

        return false;
    }

    //In-Order traverse to get the sorted list
    private void inOrderTraverse(TreeNode node, List<Integer> traverseList) {
        if (node == null)
            return;

        inOrderTraverse(node.left, traverseList);
        traverseList.add(node.val);
        inOrderTraverse(node.right, traverseList);
    }


    /**
     * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
     * <p>
     * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
     * <p>
     * Example 1:
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     * <p>
     * Example 2:
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     * <p>
     * Example 3:
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        String longStr, shortStr;

        //1) find the longer string and shorter string
        if (str1.length() >= str2.length()) {
            longStr = str1;
            shortStr = str2;
        } else {
            longStr = str2;
            shortStr = str1;
        }

        int longLen = longStr.length();
        int shortLen = shortStr.length();

        //2) special case where longStr is multiple of shortStr
        if (longLen % shortLen == 0 && shortStr.repeat(longLen / shortLen)
                                               .equals(longStr)) {
            return shortStr;
        }

        //3) not multiple
        String divideStr = "";
        for (int i = 1; i < shortLen; i++) {
            if (longLen % i == 0 && shortLen % i == 0) {
                String longSub = longStr.substring(0, i);
                String shortSub = shortStr.substring(0, i);

                if (longSub.equals(shortSub)
                        && longSub.repeat(longLen / i)
                                  .equals(longStr)
                        && shortSub.repeat(shortLen / i)
                                   .equals(shortStr))
                    divideStr = longSub;
            }
        }

        return divideStr;
    }

}
