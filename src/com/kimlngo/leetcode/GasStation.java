package com.kimlngo.leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GasStation {
    public static void main(String[] args) throws IOException {
//        System.out.println(canCompleteCircle(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
//        System.out.println(canCompleteCircle(new int[]{2, 3, 4}, new int[]{3, 4, 3}));

        System.out.println(canCompleteCircle(Util.readGas(), Util.readCost()));
    }

    private static int solution(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;

        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) return -1;

        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return start;
    }

    private static int canCompleteCircle(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();
        if(gasSum < costSum) return -1;

        int length = gas.length;

        //1) find out indexes with gas[i] >= cost[i]
        List<Integer> validIdx = new ArrayList<>();
        IntStream.range(0, length)
                 .forEach(i -> {
                     if (gas[i] >= cost[i] && gas[i] > 0) validIdx.add(i);
                 });
        System.out.println(validIdx);

        for (int i = 0; i < validIdx.size(); i++) {
            int startIdx = validIdx.get(i); //3
            boolean doable = true;

            int totalGas = gas[startIdx];

            //cycle through to see if this is do-able starting point
            for (int j = 0; j < length; j++) {
                if (totalGas - cost[(startIdx + j) % length] < 0) {
                    doable = false;
                    break;
                } else {
                    totalGas = totalGas - cost[(startIdx + j) % length] + gas[(startIdx + 1 + j) % length];
                }
            }
            if (doable) return startIdx;
        }
        return -1;
    }
}
