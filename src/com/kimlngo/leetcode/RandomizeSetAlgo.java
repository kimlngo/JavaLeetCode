package com.kimlngo.leetcode;

import com.kimlngo.leetcode.data.RandomizedSet;

public class RandomizeSetAlgo {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();

        System.out.println("insert 1: " + set.insert(1));
        System.out.println("remove 2: " + set.remove(2));
        System.out.println("insert 2: " + set.insert(2));

        System.out.println("get random: " + set.getRandom());
        System.out.println("remove 1: " + set.remove(1));
        System.out.println("insert 2: " + set.insert(2));
        System.out.println("get random: " + set.getRandom());
    }
}
