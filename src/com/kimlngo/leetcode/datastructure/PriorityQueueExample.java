package com.kimlngo.leetcode.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Comparator<Student> decendingScoreComparator = Comparator.comparingInt(Student::score)
                                                                 .reversed()
                                                                 .thenComparing(Student::name);
        PriorityQueue<Student> studentRanking = new PriorityQueue<>(decendingScoreComparator);

        studentRanking.add(new Student(1, "John", 79));
        studentRanking.add(new Student(2, "Peter", 85));
        studentRanking.add(new Student(3, "Thomas", 77));
        studentRanking.add(new Student(5, "Luke", 99));
        studentRanking.add(new Student(4, "James", 99));

        while (!studentRanking.isEmpty()) {
            System.out.println(studentRanking.poll());
        }

        System.out.println("End");
    }
}

record Student(int id, String name, int score) {
};
