package com.kimlngo.leetcode.data;

public class NodeUtil {
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();

        while (cur != null) {
            sb.append(cur.val);
            sb.append(" -> ");
            cur = cur.next;
        }

        System.out.println(sb.substring(0, sb.length() - 4));
    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        else if (arr.length == 1) return new ListNode(arr[0]);

        //two nodes and above
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            cur.next = newNode;
            cur = newNode;
        }

        return head;
    }
}
