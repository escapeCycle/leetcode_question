package com.xunhuan.leetcode;

import java.util.Stack;

public class MinStack {
    class Record {
        public final int value;
        public final int minValue;
        
        public Record(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }
    
    private final Stack<Record> _stack = new Stack();

    public void push(int x) {
        int minValue = _stack.size() == 0 ? x : Math.min(x, getMin());
        _stack.push(new Record(x, minValue));
    }
    
    public void pop() {
        _stack.pop();
    }
    
    public int top() {
        return _stack.peek().value;
    }
    
    public int getMin() {
        return _stack.peek().minValue;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(-2);
        minStack.push(-3);
        minStack.pop();
        int min = minStack.getMin();
        System.out.println(min);
    }
}