package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.ListNode;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode head = one;
        printList(head);

        System.out.println("//reverse");
        printList(reverseLinkedList(head));
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    private static ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) return head;

        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode newHead = stack.pop();
        cur = newHead;
        while(!stack.empty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }
}

