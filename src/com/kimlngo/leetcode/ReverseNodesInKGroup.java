package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        NodeUtil.printList(reverseKGroup(NodeUtil.createLinkedList(new int[]{1, 2, 3, 4, 5}), 5));

    }
    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        List<ListNode> childHeads = new ArrayList<>();
        List<ListNode> reverseChildHeads = new ArrayList<>();

        //1) split linked lists in to k-size groups
        int totalNode = splitLinkedListAsKGroup(head, k, childHeads);
        boolean hasLeftOverNodes = totalNode % k != 0;
        int lastIterationIdx = hasLeftOverNodes ? childHeads.size() - 1 : childHeads.size();

        //2) reverse each individual list
        for(int i = 0; i < lastIterationIdx; i++) {
            reverseChildHeads.add(reverseLinkedList(childHeads.get(i)));
        }

        //3) joining the heads
        ListNode resultHead = reverseChildHeads.get(0);

        for(int i = 0, j = 1; i < childHeads.size() - 1 && j < reverseChildHeads.size(); i++, j++) {
            childHeads.get(i).next = reverseChildHeads.get(j);
        }

        if(hasLeftOverNodes) {
            int size = childHeads.size();
            childHeads.get(size - 2).next = childHeads.get(size - 1);
        }
        return resultHead;
    }

    private static int splitLinkedListAsKGroup(ListNode head, int k, List<ListNode> groups) {
        int count = 1;
        int totalNode = 0;
        ListNode cur = head;
        ListNode cHead = head;

        //1) split the linked list into k-size groups
        while (cur != null) {
            if (count < k) {
                count++;
                cur = cur.next;
            } else {
                groups.add(cHead);
                count = 1;
                ListNode prev = cur;
                cur = cur.next;
                cHead = cur;
                prev.next = null;
            }
            totalNode++;
        }

        if(totalNode % k != 0)
            groups.add(cHead);
        return totalNode;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;

        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode newHead = stack.pop();
        cur = newHead;

        while(!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            tmp.next = null;
            cur.next = tmp;
            cur = cur.next;
        }

        return newHead;
    }
}
