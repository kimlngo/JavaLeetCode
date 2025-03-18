package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head1 = NodeUtil.createLinkedList(new int[]{-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5});
        System.out.println(hasCycle(head1));
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode cur = head;

        while (cur != null) {
            if (cur.visited) {
                //node already visited, cycle detected
                return true;
            }

            if (cur.next == null) {
                //reaching the tail, return false
                return false;
            }

            cur.visited = true;
            cur = cur.next;
        }

        return false;
    }

//    private static boolean hasVisited(List<ListNode> list, ListNode node) {
//        if(list.isEmpty()) return false;
//
//        for(ListNode n : list) {
//            if(n == node && n.val == node.val) return true;
//        }
//        return false;
//    }
}
