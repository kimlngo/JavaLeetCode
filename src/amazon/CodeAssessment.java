package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeAssessment {
    public static void main(String[] args) {
        List<Integer> ratings = new ArrayList<>(Arrays.asList(4, 2, 1, 1, 2));
        System.out.println(getMaxIncrements(ratings));
    }
    public static int getMaxIncrements(List<Integer> ratings) {
        // Write your code here

        // Direction: maximum possible number of indices can be obtain
        // if the ratings is sorted in ascending order. In that way,
        // the ratings[i] < ratings[i + 1] will most likely to happen rather
        // than generating all permutations and count

        // Special consideration: need to also consider if two ratings have the same value, e.g 1, 2, 2, 3
        // in this case, 2 -> 2 does not count as an increment.
        List<Integer> sortedRatings = new ArrayList<>();
        sortRatings(ratings, sortedRatings);
        System.out.println(sortedRatings);

        int maxCount = 0;

        for (int i = 0; i < sortedRatings.size() - 1; i++) {
            if (sortedRatings.get(i) < sortedRatings.get(i + 1)) {
                maxCount++;
            }
        }

        return maxCount;
    }

    private static void sortRatings(List<Integer> ratings, List<Integer> sortedRatings) {
        if (ratings.isEmpty()) return;
        else if (ratings.size() == 1) {
            sortedRatings.add(ratings.get(0));
            return;
        }

        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;

        //finding the minimum value
        for (int i = 0; i < ratings.size(); i++) {
            if (ratings.get(i) < minVal) {
                minVal = ratings.get(i);
                minIndex = i;
            }
        }

        ratings.remove(minIndex);
        int nextMin = Integer.MAX_VALUE;
        int nextMinIndex = -1;

        //finding the next minimum number
        for (int i = 0; i < ratings.size(); i++) {
            if (ratings.get(i) < nextMin && ratings.get(i) != minVal) {
                nextMin = ratings.get(i);
                nextMinIndex = i;
            }
        }

        sortedRatings.add(minVal);
        if(nextMinIndex != -1) {
            ratings.remove(nextMinIndex);
            sortedRatings.add(nextMin);
        }

        sortRatings(ratings, sortedRatings);
    }
}
