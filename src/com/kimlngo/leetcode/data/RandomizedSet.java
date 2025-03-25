package com.kimlngo.leetcode.data;

import java.util.HashSet;
import java.util.Set;

public class RandomizedSet {
    private Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (set.contains(Integer.valueOf(val))) return false;

        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(Integer.valueOf(val))) return false;

        set.remove(val);
        return true;
    }

    public int getRandom() {
        Integer result = null;

        if (set.size() == 1) {
            for (Integer i : set) {
                result = i;
            }
        } else {
            int randomIdx = (int) (Math.random() * set.size());
            int count = 0;
            for (Integer i : set) {
                if (count == randomIdx) {
                    result = i;
                    break;
                }
                count++;
            }
        }
        return result;
    }
}
