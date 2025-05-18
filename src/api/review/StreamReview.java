package api.review;

import java.util.List;
import java.util.stream.Stream;

public class StreamReview {
    public static void main(String[] args) {
        streamReview();
    }

    private static void streamReview() {
        List<String> list = Stream.of("Hello", "one", "three", "five")
                                  .filter(s -> s.length() > 3)
                                  .toList();

        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}
