package com.kimlngo.leetcode.data;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                ", visited=" + visited +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ListNode listNode = (ListNode) o;
//        return val == listNode.val && Objects.equals(next, listNode.next);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(val, next);
//    }
}
