package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;

import java.util.Stack;

public class MaxTwinSum {
    public static void main(String[] args) {
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(3);

        one.next = two;
        two.next = three;
        three.next = four;

        System.out.println(maxTwinSum(one));
    }

    private static int maxTwinSum(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        int count = 0;
        int maxSum = 0;

        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
            count++;
        }

        int middleIdx = count/2;
        cur = head;
        for (int i = 0; i < middleIdx; i++) {
            ListNode pop = stack.pop();
            int sum = cur.val + pop.val;
            if(maxSum < sum) maxSum = sum;

            cur = cur.next;
        }

        return maxSum;
    }
}
