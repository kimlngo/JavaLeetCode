package api.review.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListReview {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("four");

        System.out.println(stringList);
        stringList.add(2, "three");
        System.out.println(stringList);

        stringList.addAll(Arrays.asList("five", "six"));
        System.out.println(stringList);

        stringList.addAll(2, Arrays.asList("1", "2", "3"));
        System.out.println(stringList);

        List<Integer> charList = new ArrayList<>();
        charList.add(5);
        charList.add(7);
        charList.add(1);
        charList.add(3);
        System.out.println(charList);

        charList.sort((a, b) -> a - b);
        System.out.println(charList);

        charList.sort((a, b) -> b - a);
        System.out.println(charList);

        System.out.println(Arrays.toString(charList.toArray()));

        System.out.println(charList.subList(1, 3)); // 5, 3

        //convert array to list
        int[] arr = {1, 3, 4, 6};
        List<Integer> intList = Arrays.stream(arr)
                                      .boxed()
                                      .toList();

        System.out.println(intList);
    }
}
