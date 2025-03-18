package com.kimlngo.leetcode.data;

public class ListNode {
    public int val;
    public ListNode next;
    public boolean visited;

    public ListNode(){}

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.visited = false;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
        this.visited = false;
    }
}
