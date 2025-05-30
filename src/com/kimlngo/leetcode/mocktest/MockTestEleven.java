package com.kimlngo.leetcode.mocktest;

import java.util.ArrayList;
import java.util.List;

public class MockTestEleven {
    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{0, 0, 1, 0, 1, 1}));
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
        System.out.println(maxDistToClosest(new int[]{0, 1}));
    }

    /**
     * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
     * <p>
     * There is at least one empty seat, and at least one person sitting.
     * <p>
     * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
     * <p>
     * Return that maximum distance to the closest person.
     * <p>
     * Input: seats = [1,0,0,0,1,0,1]
     * Output: 2
     * Explanation:
     * If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
     * If Alex sits in any other open seat, the closest person has distance 1.
     * Thus, the maximum distance to the closest person is 2.
     *
     * Example 2:
     *
     * Input: seats = [1,0,0,0]
     * Output: 3
     * Explanation:
     * If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
     * This is the maximum distance possible, so the answer is 3.
     *
     * Example 3:
     *
     * Input: seats = [0,1]
     * Output: 1
     * @param seats
     * @return
     */
    private static int maxDistToClosest(int[] seats) {
        int len = seats.length;
        List<Seat> seatList = buildSeatList(seats);

        List<Seat> occupiedSeats = seatList.stream()
                                           .filter(s -> s.val() == 1)
                                           .toList();

        //corner case where only 1 seat is occupied
        if (occupiedSeats.size() == 1) {
            int index = occupiedSeats.getFirst()
                                     .index();
            return Math.max(index, len - 1 - index);
        }

        //more than 1 seat occupied
        int maxDist = 0;
        int start = 0, end = 0;

        for (int i = 0; i < occupiedSeats.size() - 1; i++) {
            Seat first = occupiedSeats.get(i);
            Seat second = occupiedSeats.get(i + 1);
            int diff = second.index() - first.index();

            if (diff > maxDist) {
                maxDist = diff;
                start = first.index();
                end = second.index();
            }
        }

        int mid = (int) Math.floor(((double) (start + end)) / 2);

        //Corner cases
        int frontDistant = 0;
        if (seats[0] == 0) {
            frontDistant = occupiedSeats.getFirst()
                                        .index();
        }

        int backDistant = 0;
        if (seats[len - 1] == 0) {
            backDistant = len - 1 - occupiedSeats.getLast()
                                                 .index();
        }

        return Math.max(Math.max(frontDistant, backDistant), Math.min(mid - start, end - mid));
    }

    private static List<Seat> buildSeatList(int[] seats) {
        List<Seat> list = new ArrayList<>();

        for (int i = 0; i < seats.length; i++) {
            list.add(new Seat(seats[i], i));
        }

        return list;
    }
}

record Seat(int val, int index) {
}