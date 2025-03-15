package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicatesII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, FrequencyObj> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (freqMap.get(num) == null) {
                freqMap.put(num, new FrequencyObj());
            }

            var obj = freqMap.get(num);
            obj.setCount(obj.getCount() + 1);
            obj.addIndex(i);

            if (obj.getCount() > 1) {
                List<Integer> indexes = obj.getIndexes();

                int diff = indexes.get(indexes.size() - 1) - indexes.get(indexes.size() - 2);
                if (diff <= k) return true;
            }
        }

        return false;
    }
}

class FrequencyObj {
    private int count;
    private List<Integer> indexes;

    public FrequencyObj() {
        this.count = 0;
        this.indexes = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addIndex(int i) {
        this.indexes.add(i);
    }

    public List<Integer> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<Integer> indexes) {
        this.indexes = indexes;
    }
}
