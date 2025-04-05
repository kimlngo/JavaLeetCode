package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode h1 = NodeUtil.createLinkedList(new int[]{1, 4, 5});
        ListNode h2 = NodeUtil.createLinkedList(new int[]{1, 3, 4});
        ListNode h3 = NodeUtil.createLinkedList(new int[]{2, 6});

        NodeUtil.printList(h1);
        NodeUtil.printList(h2);
        NodeUtil.printList(h3);

        MergeKSortedList sut = new MergeKSortedList();
//        NodeUtil.printList(sut.mergeKSortedList(new ListNode[]{h1, h2, h3}));
//
        System.out.println(sut.mergeKSortedList_FlatMap(new ListNode[]{}));
        System.out.println(sut.mergeKSortedList_FlatMap(new ListNode[]{null}));


        NodeUtil.printList(sut.mergeKSortedList_FlatMap(new ListNode[]{h1, h2, h3}));
    }

    private ListNode mergeKSortedList_FlatMap(ListNode[] lists) {
        if(lists == null) return null;
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        var sortedList = Arrays.stream(lists)
                               .map(this::convertLinkedListToList)
                               .flatMap(List::stream)
                               .sorted(this::compareListNode)
                               .toList();

        if(sortedList.size() == 0) return null;
        var head = sortedList.get(0);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            sortedList.get(i).next = null;
            sortedList.get(i + 1).next = null;

            sortedList.get(i).next = sortedList.get(i + 1);
        }

        return head;
    }

    private int compareListNode(ListNode n1, ListNode n2) {
        return n1.val - n2.val;
    }

    private List<ListNode> convertLinkedListToList(ListNode head) {
        if (head == null) return new ArrayList<>();
        if (head.next == null) return Arrays.asList(head);

        var list = new ArrayList<ListNode>();
        ListNode tmp = head;

        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }

        return list;
    }

    private static ListNode mergeKSortedList(ListNode[] lists) {
        if (lists.length == 0) return null;
        else if (lists.length == 1) return lists[0];

        ListNode result = mergeTwoSortedList(lists[0], lists[1]);

        for (int i = 2; i < lists.length; i++) {
            result = mergeTwoSortedList(result, lists[i]);
        }
        return result;
    }

    private static ListNode mergeTwoSortedList(ListNode h1, ListNode h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        ListNode cur1 = h1;
        ListNode cur2 = h2;

        ListNode head;
        if (h1.val <= h2.val) {
            head = h1;
            cur1 = h1.next;
        } else {
            head = h2;
            cur2 = h2.next;
        }
        ListNode cur = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
                cur = cur.next;
            } else if (cur2.val < cur1.val) {
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            } else {
                //equal case
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;

                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }

        if (cur1 != null) {
            cur.next = cur1;
        } else if (cur2 != null) {
            cur.next = cur2;
        }

        return head;
    }
}
