package com.kimlngo.leetcode.mocktest;

import java.util.Calendar;
import java.util.Stack;

public class MockTestTwentyThree {
    private static final String[] DAY_OF_WEEK = new String[]{
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
    };

    public static void main(String[] args) {
        var solution = new MockTestTwentyThree();

        System.out.println(solution.dayOfTheWeek(2025, 6, 15)); //Sunday
        System.out.println(solution.dayOfTheWeek(1988, 6, 29)); //Wednesday

        var myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);

        System.out.println(myQueue.peek()); //1
        System.out.println(myQueue.pop()); //1
        System.out.println(myQueue.empty()); //false
    }

    private String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar = new Calendar.Builder()
                .setDate(year, month - 1, day)
                .build();

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return DAY_OF_WEEK[dayOfWeek - 1];
    }
}

class MyQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        //reverse stack1 to get the first in
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return result;
    }

    public int peek() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int result = stack2.peek();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return result;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}