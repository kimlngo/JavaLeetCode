package com.kimlngo.leetcode.mocktest;

import com.kimlngo.leetcode.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class MockTestThirtySix {

    public static void main(String[] args) {
        MockTestThirtySix sol = new MockTestThirtySix();

        //Example 1:
        System.out.println(sol.shipWithinDays(Util.readInput1DArray("[1,2,3,4,5,6,7,8,9,10]"), 5));

        //Example 2:
        System.out.println(sol.shipWithinDays(Util.readInput1DArray("[3,2,2,4,1,4]"), 3));

        //Example 3:
        System.out.println(sol.shipWithinDays(Util.readInput1DArray("[1,2,3,1,1]"), 4));
    }

    public int shipWithinDays(int[] weights, int days) {

        //1) find sum, ave and max to determine the starting point
        IntSummaryStatistics stats = Arrays.stream(weights)
                                           .summaryStatistics();

        int sum = (int) stats.getSum();
        int max = stats.getMax();

        int ave = (int) Math.floor((double) sum / days);
        int capacity = Math.max(ave, max);

        var shipments = splitShipments(weights, capacity);
        int expectedDays = shipments.size();

        while (expectedDays > days) {
            capacity++;
            expectedDays = splitShipments(weights, capacity).size();
        }

        return capacity;
    }

    private List<List<Integer>> splitShipments(int[] weights, int capacity) {
        int sum = 0;
        List<List<Integer>> shipments = new ArrayList<>();

        List<Integer> currentShipment = new ArrayList<>();

        for (int weight : weights) {
            sum += weight;

            if (sum > capacity) {
                shipments.add(currentShipment);
                currentShipment = new ArrayList<>();
                sum = weight;
            }
            currentShipment.add(weight);
        }

        if (!currentShipment.isEmpty()) {
            shipments.add(currentShipment);
        }
        return shipments;
    }
}
