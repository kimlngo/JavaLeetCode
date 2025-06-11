package dynamicprogramming;

import java.util.*;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        int n = 45;
        long start, end;
/*      start = System.currentTimeMillis();
        System.out.println(fibonacci.naiveFib(n));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");*/


        System.out.println("===== Fibonacci by DP =====");
        start = System.currentTimeMillis();
        System.out.println(fibonacci.fibByDP(n));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");


        System.out.println("===== Fibonacci by DP Bottom Up =====");
        start = System.currentTimeMillis();
        System.out.println(fibonacci.fibByDPBottomUp(n));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
        System.out.println("Finished");
    }

    public int naiveFib(int n) {
        if (n < 2) return n;
        return naiveFib(n - 1) + naiveFib(n - 2);
    }

    public int fibByDPBottomUp(int n) {
        //Create cache and pre-fill it with 2 values 0 and 1
        List<Integer> cache = new ArrayList<>(Arrays.asList(0, 1));

        //Use loop iteration to fill up the Fibonacci values until reaching n
        for (int i = 2; i <= n; i++) {
            cache.add(cache.get(i - 1) + cache.get(i - 2));
        }

        return cache.getLast();
    }

    public int fibByDP(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        try {
            return fibByDP(n, cache);
        } finally {
            System.out.println(cache);
        }
    }

    private int fibByDP(int n, Map<Integer, Integer> cache) {
        if (cache.get(n) != null)
            return cache.get(n);

        if (n < 2) {
            cache.put(n, n);
            return n;
        }

        cache.put(n, fibByDP(n - 1, cache) + fibByDP(n - 2, cache));
        return cache.get(n);
    }
}
