package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        ListNode head = NodeUtil.createLinkedList(new int[]{4, 2, 1, 3});

        NodeUtil.printList(head);

        SortList sut = new SortList();
        NodeUtil.printList(sut.sortList(head));
    }

    private ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        List<ListNode> nodeList = new ArrayList<>();

        ListNode tmp = head;
        while (tmp != null) {
            nodeList.add(tmp);
            tmp = tmp.next;
        }

        var sortedList = nodeList.stream()
                                 .sorted(Comparator.comparing(this::getVal))
                                 .toList();

        for(int i = 0; i < sortedList.size() - 1; i++) {
            sortedList.get(i).next = null;
            sortedList.get(i + 1).next = null;
            sortedList.get(i).next = sortedList.get(i + 1);
        }
        return sortedList.get(0);
    }

    private int getVal(ListNode n) {
        return n.val;
    }
}
