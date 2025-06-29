package com.kimlngo.leetcode;

import java.util.PriorityQueue;

public class KthSmallestProduct {

    public static void main(String[] args) {
        KthSmallestProduct sol = new KthSmallestProduct();
        System.out.println(sol.kthSmallestProduct(Util.readInput1DArray("[-4,-2,0,3]"), Util.readInput1DArray("[2,4]"), 6));
        System.out.println(sol.kthSmallestProduct(Util.readInput1DArray("[2,5]"), Util.readInput1DArray("[3,4]"), 2));
        System.out.println(sol.kthSmallestProduct(Util.readInput1DArray("[-2,-1,0,1,2]"), Util.readInput1DArray("[-3,-1,2,4,5]"), 3));
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        PriorityQueue<Long> pQueue = new PriorityQueue<>();

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                pQueue.add((long) n1 * n2);
            }
        }

        for (int i = 0; i < k - 1; i++) {
            pQueue.poll();
        }

        return pQueue.poll();
    }
}
