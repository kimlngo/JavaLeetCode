package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;
import com.kimlngo.leetcode.data.NodeUtil;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        NodeUtil.printList(reverseBetween(NodeUtil.createLinkedList(new int[]{1, 2, 3, 4, 5}), 2, 5));
        NodeUtil.printList(reverseBetween(NodeUtil.createLinkedList(new int[]{5}), 1, 1));
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        // collecting
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new ArrayDeque<>();

        int i = 1, end;

        while (cur != null) {
            if (i < left || i > right) queue.add(cur);
            else if (i >= left && i <= right) stack.push(cur);

            cur = cur.next;
            i++;
        }
        end = i - 1;

        // reversing
        ListNode reverseStart = stack.pop();
        ListNode reverseEnd;
        cur = reverseStart;

        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = null;
            cur.next = pop;
            cur = cur.next;
        }

        reverseEnd = cur;

        // re-joining
        ListNode newHead = left > 1 ? queue.remove() : reverseStart;
        cur = newHead;
        for(int j = 0; j < left - 2; j++) {
            cur.next = queue.remove();
            cur = cur.next;
        }
        if(left > 1 ) cur.next = reverseStart;
        cur = reverseEnd;
        for(int j = 0; j < end - right; j++) {
            cur.next = queue.remove();
            cur = cur.next;
        }

        return newHead;
    }
}
