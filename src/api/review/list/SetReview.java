package api.review.list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetReview {
    public static void main(String[] args) {

        Set<Integer> intSet = new HashSet<>(Arrays.asList(1, 2, 3, 5, 4, 5, 3));

        for (var i : intSet) {
            System.out.println(i);
        }


    }


}
