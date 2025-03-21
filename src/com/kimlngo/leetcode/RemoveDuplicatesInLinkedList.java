package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesInLinkedList {
    public static void main(String[] args) {
        NodeUtil.printList(
                deleteDuplicatesII(NodeUtil.createLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5})));

        NodeUtil.printList(
                deleteDuplicatesII(NodeUtil.createLinkedList(new int[]{1, 1, 1, 3, 4})));

        NodeUtil.printList(
                deleteDuplicatesII(NodeUtil.createLinkedList(new int[]{1, 2, 2})));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        List<ListNode> list = new ArrayList<>();
        Set<Integer> duplicates = new HashSet<>();

        ListNode cur = head;
        ListNode next = cur.next;

        while (next != null) {
            if (cur.val != next.val && !duplicates.contains(cur.val)) {
                list.add(cur);
            } else {
                duplicates.add(cur.val);
            }
            cur = next;
            next = cur.next;
        }

        if (!duplicates.contains(cur.val)) {
            list.add(cur);
        }

        if (list.isEmpty()) return null;

        ListNode newHead = list.get(0);
        cur = newHead;
        cur.next = null;
        for (int i = 1; i < list.size(); i++) {
            ListNode node = list.get(i);
            node.next = null;

            cur.next = node;
            cur = cur.next;
        }

        return newHead;
    }

    private static ListNode deleteDuplicatesII(ListNode head) {
        if (head == null || head.next == null) return head;

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        var distinctList = list.stream().distinct().toList();

        if(distinctList.isEmpty()) return null;

        ListNode newHead = distinctList.get(0);
        cur = newHead;
        cur.next = null;
        for(int i = 1; i < distinctList.size(); i++) {
            var node = distinctList.get(i);
            node.next = null;
            cur.next = node;
            cur = cur.next;
        }

        return newHead;
    }
}
