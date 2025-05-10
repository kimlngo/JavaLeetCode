package com.kimlngo.leetcode.algomap.linkedlist;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

public class RemoveNth {
    public static void main(String[] args) {
        ListNode head = NodeUtil.createLinkedList(new int[]{1, 2});

        NodeUtil.printList(head);

        NodeUtil.printList(removeNthNode(head, 1));
//        NodeUtil.printList(removeNthNode(head, 2));
//        NodeUtil.printList(removeNthNode(head, 3));
//        NodeUtil.printList(removeNthNode(head, 4));
//        NodeUtil.printList(removeNthNode(head, 5));
    }

    private static ListNode removeNthNode(ListNode head, int n) {
        int size = calculateLinkedListSize(head);
        if(n == size) {
            var tmp = head;
            head = head.next;
            tmp.next = null;
            return head;
        }

        int stop = size - n;
        ListNode tmp = head;

        for (int i = 1; i < stop; i++) {
            tmp = tmp.next;
        }

        ListNode next = tmp.next;

        tmp.next = next.next;
        next.next = null;

        return head;
    }

    private static int calculateLinkedListSize(ListNode head) {
        ListNode tmp = head;
        int size = 1;

        while (tmp.next != null) {
            tmp = tmp.next;
            size++;
        }

        return size;
    }
}
