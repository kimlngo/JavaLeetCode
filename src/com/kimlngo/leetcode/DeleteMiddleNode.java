package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        NodeUtil.printList(deleteMiddleNode(one));
    }

    private static ListNode deleteMiddleNode(ListNode head) {
        if(head == null) return head;
        if(head.next == null) {
            head = null;
            return head;
        }

        int count = 0;
        ListNode cur = head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int middleIndex = (int) Math.floor(((double) count)/2);

        cur = head;
        int index = 0;
        while(cur != null) {
            if(index == middleIndex - 1) {
                ListNode middle = cur.next;
                ListNode next = cur.next.next;
                cur.next = next;
                middle.next = null;
                break;
            }
            index++;
            cur = cur.next;
        }

        return head;
    }
}
