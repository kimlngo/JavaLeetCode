package com.kimlngo.leetcode.algomap.stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> intStack;
    private Stack<Integer> minValStack;

    public MinStack() {
        this.intStack = new Stack<>();
        this.minValStack = new Stack<>();
    }

    public void push(int val) {
        if (minValStack.isEmpty())
            minValStack.push(val);
        else
            minValStack.push(Math.min(minValStack.peek(), val));

        this.intStack.push(val);
    }

    public void pop() {
        this.intStack.pop();
        this.minValStack.pop();
    }

    public int top() {
        return this.intStack.peek();
    }

    public int getMin() {
        return this.minValStack.peek();
    }
}
