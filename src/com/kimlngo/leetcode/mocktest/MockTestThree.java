package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

public class MockTestThree {
    public static void main(String[] args) {
        var head = NodeUtil.createLinkedList(new int[]{4, 5, 1, 9});
        var five = head.next;
        var one = five.next;

        NodeUtil.printList(head);
        deleteNode(one);
        NodeUtil.printList(head);

        System.out.println("Question 2");
        System.out.println(numberOf1Bits(11));
        System.out.println(numberOf1Bits(128));
        System.out.println(numberOf1Bits(2147483645));

    }

    public static void deleteNode(ListNode node) {
        ListNode cur = node, pre = cur;

        while (cur.next != null) {
            cur.val = cur.next.val;
            pre = cur;
            cur = cur.next;
        }

        pre.next = null;
    }

    private static int numberOf1Bits(int n) {
        String binaryStr = Integer.toBinaryString(n);

        int bitCount = 0;

        for(char c : binaryStr.toCharArray()) {
            if(c == '1') bitCount++;
        }

        return bitCount;
    }
}
