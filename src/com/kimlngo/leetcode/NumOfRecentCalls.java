package com.kimlngo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumOfRecentCalls {
    public static void main(String[] args) {

    }

    class RecentCounter {
        private List<Integer> callList;

        public RecentCounter() {
            this.callList = new ArrayList<>();
        }

        public int ping(int t) {
            this.callList.add(t);

            int count = 0;
            int lowerBound = t - 3000;

            for (Integer i : callList) {
                if(i.compareTo(lowerBound) < 0) count++;
                else break;
            }

            return callList.size() - count;
        }
    }
}
