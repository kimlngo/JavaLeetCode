package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;
import com.kimlngo.leetcode.data.TreeNode;

import java.util.Stack;

public class MockTestSeventeen {
    public static void main(String[] args) {
        /*var sol = new MTSevenTeenNoReverse();


        ListNode l1 = NodeUtil.createLinkedList(new int[]{0});
        ListNode l2 = NodeUtil.createLinkedList(new int[]{0});

        NodeUtil.printList(l1);
        NodeUtil.printList(l2);

        ListNode sum = sol.addTwoNumbers(l1, l2);
        NodeUtil.printList(sum);*/


        var root = new TreeNode(3);
        var zero = new TreeNode(0);
        var four = new TreeNode(4);

        var two = new TreeNode(2);
        var one = new TreeNode(1);

        root.left = zero;
        root.right = four;

        zero.right = two;
        two.left = one;

        var sol = new TrimBinaryTree();
        TreeNode treeNode = sol.trimBST(root, 1, 3);
        System.out.println(treeNode);
    }
}

class TrimBinaryTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if (root.val > high) {
            return root.left;
        }

        if (root.val < low) {
            return root.right;
        }

        return root;
    }
}

class MTSevenTeenNoReverse {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String flatValue1 = flattenList(l1);
        String flatValue2 = flattenList(l2);

        String sumStr = sumTwoStrings(flatValue1, flatValue2);

        ListNode head = new ListNode(convertCharToInt(sumStr.charAt(0)));
        var tmp = head;

        for (int i = 1; i < sumStr.length(); i++) {
            tmp.next = new ListNode(convertCharToInt(sumStr.charAt(i)));
            tmp = tmp.next;
        }

        return head;
    }

    private String flattenList(ListNode l) {
        StringBuilder sb = new StringBuilder();

        ListNode tmp = l;
        while (tmp != null) {
            sb.append(tmp.val);
            tmp = tmp.next;
        }
        return sb.toString();
    }

    private String sumTwoStrings(String s1, String s2) {
        int idx1 = s1.length() - 1;
        int idx2 = s2.length() - 1;
        int carryOver = 0;

        StringBuilder sb = new StringBuilder();
        int sum;

        while (idx1 >= 0 && idx2 >= 0) {
            int v1 = convertCharToInt(s1.charAt(idx1));
            int v2 = convertCharToInt(s2.charAt(idx2));
            sum = (v1 + v2 + carryOver) % 10;
            carryOver = (v1 + v2 + carryOver) / 10;

            sb.append(sum);
            idx1--;
            idx2--;
        }

        if (idx1 < 0 && idx2 < 0) {
            if (carryOver != 0)
                sb.append(carryOver);
        } else if (idx1 < 0) {
            var sb1 = new StringBuilder(sumTwoStrings(s2.substring(0, idx2 + 1), String.valueOf(carryOver)));
            sb.append(sb1.reverse());
        } else {
            var sb2 = new StringBuilder(sumTwoStrings(s1.substring(0, idx1 + 1), String.valueOf(carryOver)));
            sb.append(sb2.reverse());
        }

        return sb.reverse()
                 .toString();
    }

    private int convertCharToInt(char c) {
        return switch (c) {
            case '0' -> 0;
            case '1' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            default -> throw new IllegalArgumentException();
        };
    }
}

class MTSevenTeenWithReverse {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1) reverse 2 lists first
        var reverse1 = reverseList(l1);
        var reverse2 = reverseList(l2);

        //2) sum two lists
        var sumReverse = sumTwoLists(reverse1, reverse2);

        //3) reverse the sum then return
        return reverseList(sumReverse);
    }

    private ListNode reverseList(ListNode l) {
        if (l.next == null) return l;

        Stack<ListNode> stack = new Stack<>();

        ListNode tmp = l;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        var newHead = stack.pop();
        tmp = newHead;
        while (!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;
        }

        tmp.next = null;
        return newHead;
    }

    private ListNode sumTwoLists(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;
        ListNode newHead = new ListNode((l1.val + l2.val) % 10);
        boolean carryOver = (l1.val + l2.val) >= 10;

        var tmp = newHead;
        t1 = t1.next;
        t2 = t2.next;

        while (t1 != null && t2 != null) {
            int v1 = t1.val;
            int v2 = t2.val;
            int coVal = carryOver ? 1 : 0;

            int sum = (v1 + v2 + coVal) % 10;
            carryOver = (v1 + v2 + coVal) >= 10;

            tmp.next = new ListNode(sum);
            tmp = tmp.next;
            t1 = t1.next;
            t2 = t2.next;
        }

        if (t1 == null && t2 == null && carryOver) {
            //both have the same length, check the carry over
            tmp.next = new ListNode(1);
        } else if (t1 == null) {
            tmp.next = carryOver ? sumTwoLists(t2, new ListNode(1)) : t2;
        } else {
            tmp.next = carryOver ? sumTwoLists(t1, new ListNode(1)) : t1;
        }

        return newHead;
    }
}
