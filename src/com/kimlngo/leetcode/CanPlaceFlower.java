package com.kimlngo.leetcode;

public class CanPlaceFlower {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0}, 0));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //corner case of length = 1 and 2
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 1) return n <= 0;
            else return n <= 1;
        } else if (flowerbed.length == 2) {
            if(flowerbed[0] == 0 && flowerbed[1] == 0) return n <= 1;
            else return n <= 0;
        }

        int count = n;
        int[] copy = new int[flowerbed.length];
        System.arraycopy(flowerbed, 0, copy, 0, flowerbed.length);

        //use sliding window of 3
        for (int i = 0; i < copy.length; i++) {
            if (i == 0) {
                if(copy[0] == 0 && copy[1] == 0){
                    copy[0] = 1;
                    count--;
                }
            } else if (i == copy.length - 1) {
                if (copy[i - 1] == 0 && copy[i] == 0) {
                    copy[i] = 1;
                    count--;
                }
            } else {
                if (copy[i - 1] == 0 && copy[i] == 0 && copy[i + 1] == 0) {
                    copy[i] = 1;
                    count--;
                }
            }
        }

        return count <= 0;
    }
}
