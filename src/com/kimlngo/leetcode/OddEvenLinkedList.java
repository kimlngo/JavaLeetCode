package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

public class OddEvenLinkedList {

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

        NodeUtil.printList(oddEvenList(one));

    }

    private static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        //have 3 nodes and above
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = head.next;
        ListNode cur = head.next.next;
        boolean isOdd = true;

        while (cur != null) {
            if (isOdd) {
                odd.next = cur;
                odd = cur;
                isOdd = false;
            } else {
                even.next = cur;
                even = cur;
                isOdd = true;
            }
            cur = cur.next;
        }

        odd.next = evenStart;
        if(!isOdd) even.next = null;

        return head;
    }
}
