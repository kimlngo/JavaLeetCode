package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{2, 3, 3}, 2));
    }

    private static int removeElement(int[] nums, int val) {
        //1) browse through to find count of # different from val
        int count = 0;

        //O(n)
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) count++;
        }

        for(int i = 0; i < count; i++) {
            if(nums[i] == val) {
                remove(nums, i);
                i--;
            }
        }

        System.out.println(Arrays.toString(nums));
        return count;
    }

    private static void remove(int[] nums, int removeIdx) {
        if (removeIdx < 0 || removeIdx >= nums.length) return;

        for (int i = removeIdx; i < nums.length - 1; i++)
            nums[i] = nums[i + 1];
    }
}
