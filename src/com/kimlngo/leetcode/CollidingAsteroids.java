package com.kimlngo.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CollidingAsteroids {
    public static void main(String[] args) {
        print(asteroidCollision(new int[]{5, 10, -5}));
        print(asteroidCollision(new int[]{5, -5}));
        print(asteroidCollision(new int[]{10, 2, -5}));
        print(asteroidCollision(new int[]{-2, -1, 1, 2}));
        print(asteroidCollision(new int[]{1, -2, -2, -2}));
        print(asteroidCollision(new int[]{1, -1, -2, -2}));
    }

    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> result = new Stack<>();
        result.push(Integer.valueOf(asteroids[0]));

        int top, cur;
        for (int i = 1; i < asteroids.length; i++) {
            cur = asteroids[i];
            if (result.isEmpty()) {
                result.push(cur);
                continue;
            }

            top = result.pop();

            if (cur * top > 0 || (top < 0 && cur > 0)) {
                //same direction or opposite direction but not collide
                result.push(top);
                result.push(cur);
            } else {
                //collide case
                if (Math.abs(top) > Math.abs(cur)) result.push(top);
                else if (Math.abs(top) < Math.abs(cur)) i--;
            }
        }

        return result.stream()
                     .mapToInt(Integer::valueOf)
                     .toArray();

    }
}
