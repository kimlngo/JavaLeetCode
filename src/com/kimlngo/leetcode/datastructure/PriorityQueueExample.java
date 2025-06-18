package com.kimlngo.leetcode.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Comparator<Integer> reverseOrderComparator = (a, b) -> b - a;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(reverseOrderComparator);

        pQueue.add(3);
        pQueue.add(2);
        pQueue.add(5);
        pQueue.add(4);
        pQueue.add(1);

        System.out.println(pQueue);

        while (!pQueue.isEmpty()) {
            System.out.println(pQueue.poll());
        }


    }
}
