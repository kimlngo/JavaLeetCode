package com.kimlngo.leetcode;

public class MaxAltitude {
    public static void main(String[] args) {
//        System.out.println(maxAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(maxAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
        //-4,-3,-2,-1,4,3,2
    }

    private static int maxAltitude(int[] gain) {
//        [-5,1,5,0,-7]
        //start: 0
        //maxAltitude: [0, -5, -4, 1, 1, -6] ==> max Altitude = 1

        int maxAltitude = 0;
        int sum = 0;

        for(int g : gain) {
            sum += g;
            if(sum > maxAltitude) maxAltitude = sum;
        }

        return maxAltitude;
    }
}
