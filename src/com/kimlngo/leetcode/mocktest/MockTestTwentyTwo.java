package com.kimlngo.leetcode.mocktest;

public class MockTestTwentyTwo {
    public static void main(String[] args) {
        MockTestTwentyTwo sol = new MockTestTwentyTwo();

        System.out.println(sol.addStrings("9999999", "9999"));

    }

    public String addStrings(String num1, String num2) {
        //1) iterate through num1 and num2 from the back to the front
        //sum the digits and produce the digit addition result, push this result into a reverseList and take care of the carry over too
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carryOver = 0;
        StringBuilder sb = new StringBuilder();

        while (i1 >= 0 && i2 >= 0) {
            char c1 = num1.charAt(i1);
            char c2 = num2.charAt(i2);

            Addition addition = sumTwoDigits(c1, c2, carryOver);
            carryOver = addition.carryOver();

            sb.append(addition.sum());
            i1--;
            i2--;
        }

        //two numbers have same length
        if (i1 < 0 && i2 < 0) {
            if (carryOver != 0)
                sb.append(carryOver);
        } else {
            String largerNum = i1 < 0 ? num2 : num1;
            int index = i1 < 0 ? i2 : i1;

            String remaining = addStrings(largerNum.substring(0, index + 1), String.valueOf(carryOver));
            for (int k = remaining.length() - 1; k >= 0; k--) {
                sb.append(remaining.charAt(k));
            }
        }

        //3) pop all the values from a reverseList into a List and join them into a String
        return sb.reverse().toString();
    }

    private Addition sumTwoDigits(char c1, char c2, int carryOver) {
        int digit1 = convertDigit(c1);
        int digit2 = convertDigit(c2);

        int addition = digit1 + digit2 + carryOver;

        return new Addition(String.valueOf(addition % 10), addition / 10);
    }

    private int convertDigit(char c) {
        return c - '0';
    }
}

record Addition(String sum, int carryOver) {
}