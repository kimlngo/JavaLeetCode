package com.kimlngo.leetcode.mocktest;

import java.util.*;

public class MockTestTwentySeven {

    public static void main(String[] args) {
        MockTestTwentySeven sol = new MockTestTwentySeven();

        System.out.println(sol.isOneBitCharacter(new int[]{1, 0, 0})); //true
        System.out.println(sol.isOneBitCharacter(new int[]{1, 1, 1, 0})); //false

        KthLargestV2 kthLargest = new KthLargestV2(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3)); //3
        System.out.println(kthLargest.add(5)); //5
        System.out.println(kthLargest.add(10)); //5
        System.out.println(kthLargest.add(9)); //8
        System.out.println(kthLargest.add(4)); //8

        System.out.println("Test 2");
        kthLargest = new KthLargestV2(4, new int[]{7, 7, 7, 7, 8, 3});
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
    private final int k;
    private Node head, tail;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        if (nums.length > 0) {
            Integer[] sortedInts = Arrays.stream(nums)
                                         .boxed()
                                         .sorted(Comparator.reverseOrder())
                                         .toArray(Integer[]::new);

            this.head = new Node(sortedInts[0]);
            Node cur = head;

            for (int i = 1; i < sortedInts.length; i++) {
                cur.next = new Node(sortedInts[i]);
                cur = cur.next;
            }
            this.tail = cur;
        }
    }

    public int add(int val) {
        //1) step 1: add a new Node(val) to the linked list
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

        //step 2: get the kth node from linked list and return the value
        Node cur = this.head;
        for (int i = 0; i < this.k - 1; i++) {
            cur = cur.next;
        }
        // System.out.println("Return: " + cur.val);
        return cur.val;
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

class KthLargestV2 {
    private final int k;
    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public KthLargestV2(int k, int[] nums) {
        this.k = k;
        for(int n : nums) this.add(n);
    }

    public int add(int val) {
        //if priorityQueue size is < k, keep adding val into priorityQueue
        //and use peek() to get the kth-largest

        //if val > current kth value then add val into the priorityQueue too
        //but have to check the size after adding, if so, remove the old kth-value
        if(priorityQueue.size() < k || priorityQueue.peek() < val) {
            priorityQueue.add(val);
            if(priorityQueue.size() > k) {
                priorityQueue.remove();
            }
        }

        return priorityQueue.peek();
    }

}