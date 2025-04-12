package com.kimlngo.leetcode.mocktest;

public class MockTestFive {

    public static void main(String[] args) {
        var main = new MockTestFive();
        int[] cost = {0, 1, 2, 2};
        System.out.println(main.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        var holder1 = new CostHolder(cost);
        findCost(0, holder1);

        var holder2 = new CostHolder(cost);
        findCost(1, holder2);

        return Math.min(holder1.getCost(), holder2.getCost());
    }

    private void findCost(int startIndex, CostHolder costHolder) {
        if (startIndex >= costHolder.getAllCost().length) {
            return;
        }

        costHolder.setCost(costHolder.getCost() + costHolder.getCostAtIndex(startIndex));

        if (startIndex + 2 >= costHolder.getAllCost().length) return;

        int cost1 = costHolder.getCostAtIndex(startIndex + 1);
        int cost2 = costHolder.getCostAtIndex(startIndex + 2);

        if (cost1 < cost2) {
            findCost(startIndex + 1, costHolder);
        } else {
            findCost(startIndex + 2, costHolder);
        }
    }
}

class CostHolder {
    private int cost;
    private int[] allCost;

    public CostHolder(int[] allCost) {
        this.cost = 0;
        this.allCost = allCost;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int[] getAllCost() {
        return this.allCost;
    }

    public int getCostAtIndex(int index) {
        return allCost[index];
    }
}