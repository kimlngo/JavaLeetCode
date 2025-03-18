package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = NodeUtil.createLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = NodeUtil.createLinkedList(new int[]{9, 9, 9, 9});

        NodeUtil.printList(addTwoNumbers(l1, l2));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // declare two iterating var
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode head = new ListNode((c1.val + c2.val) % 10);
        ListNode cur = head;
        int carryOver = (c1.val + c2.val) / 10;

        c1 = c1.next;
        c2 = c2.next;
        // looping through the two lists l1, l2
        while (c1 != null && c2 != null) {
            // perform addition with carry-over variable
            int sum = c1.val + c2.val + carryOver;
            cur.next = new ListNode(sum % 10);
            carryOver = sum / 10;

            cur = cur.next;
            c1 = c1.next;
            c2 = c2.next;
        }

        if (c1 == null && c2 == null) {
            if (carryOver != 0) {
                cur.next = new ListNode(carryOver);
            }
        } else {
            portRemainingList(cur, c1 != null ? c1 : c2, carryOver);
        }
        //return the result's head
        return head;
    }

    private static void portRemainingList(ListNode cur, ListNode c, int carryOver) {
        if (carryOver == 0) cur.next = c;
        else cur.next = addTwoNumbers(new ListNode(carryOver), c);
    }
}
