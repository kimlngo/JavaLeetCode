package com.kimlngo.leetcode.mocktest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MockTestTwentySeven {

    public static void main(String[] args) {
        MockTestTwentySeven sol = new MockTestTwentySeven();

        System.out.println(sol.isOneBitCharacter(new int[]{1, 0, 0})); //true
        System.out.println(sol.isOneBitCharacter(new int[]{1, 1, 1, 0})); //false

        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3)); //3
        System.out.println(kthLargest.add(5)); //5
        System.out.println(kthLargest.add(10)); //5
        System.out.println(kthLargest.add(9)); //8
        System.out.println(kthLargest.add(4)); //8

        System.out.println("Test 2");
        kthLargest = new KthLargest(4, new int[]{7, 7, 7, 7, 8, 3});
        System.out.println(kthLargest.add(2)); //7
        System.out.println(kthLargest.add(10)); //7
        System.out.println(kthLargest.add(9)); //7
        System.out.println(kthLargest.add(9)); //8
    }

    public boolean isOneBitCharacter(int[] bits) {
        List<List<Integer>> chars = new ArrayList<>();

        int i = 0;

        while (i < bits.length) {
            if (bits[i] == 1) {
                chars.add(Arrays.asList(bits[i], bits[i + 1]));
                i++;
            } else {
                chars.add(List.of(bits[i]));
            }

            i++;
        }

        List<Integer> lastChar = chars.getLast();
        return lastChar.size() == 1;
    }
}

class KthLargest {
    private int k;
    private Node head, tail;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        if (nums.length > 0) {
            int[] sortedInts = Arrays.stream(nums)
                                     .sorted()
                                     .toArray();

            this.head = new Node(sortedInts[sortedInts.length - 1]);
            Node cur = head;

            for (int i = sortedInts.length - 2; i >= 0; i--) {
                cur.next = new Node(sortedInts[i]);
                cur = cur.next;
            }
            this.tail = cur;
            // this.printList();
        }
    }

    public int add(int val) {
        // System.out.println("Add: " + val);

        //1) step 1: add a new Node(val) to the linkedlist
        Node insertion = new Node(val);

        //1.0) if no head, then just put this insertion as head
        if (this.head == null) {
            this.head = insertion;
            this.tail = insertion;
            return this.head.val;
        }

        //1.1) if val > head.val, insert at the start of linked list
        if (val >= this.head.val) {
            insertion.next = this.head;
            this.head = insertion;
        }
        //1.2) insert to the end of linked list
        else if (val <= this.tail.val) {
            this.tail.next = insertion;
            this.tail = insertion;
        }
        //1.3) insert in the middle
        else {
            Node tmp = this.head;
            Node pre = tmp;

            while (tmp != null) {
                if (tmp.val <= val) {
                    //found the insertion point
                    pre.next = insertion;
                    insertion.next = tmp;
                    break;
                }
                pre = tmp;
                tmp = tmp.next;
            }
        }

        // this.printList();

        //step 2: get the kth node from linked list and return the value
        Node cur = this.head;
        for (int i = 0; i < this.k - 1; i++) {
            cur = cur.next;
        }
        // System.out.println("Return: " + cur.val);
        return cur.val;
    }

    void printList() {
        StringBuilder sb = new StringBuilder();

        Node tmp = this.head;
        while (tmp != null) {
            sb.append(tmp.val);
            sb.append(" -> ");
            tmp = tmp.next;
        }
        System.out.println(sb.substring(0, sb.length() - 4));
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
