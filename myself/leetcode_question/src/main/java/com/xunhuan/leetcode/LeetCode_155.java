package com.xunhuan.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 设计一个栈，可以直接获取最小元素
 */
public class LeetCode_155 {
    private int[] elements;
    private static final int[] EMPTY_ELEMENTDATA = {};

    private Stack<Integer> minStack = new Stack<Integer>();

    public LeetCode_155() {
        elements = new int[0];
        minStack.push(Integer.MAX_VALUE);
    }

    public LeetCode_155(int initialCapacity) {
        if (initialCapacity > 0) {
            elements = new int[initialCapacity];
        } else if (initialCapacity == 0) {
            elements = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int o) {
        int[] newStack = new int[elements.length + 1];

        for (int i = 0; i < elements.length; i++) {
            newStack[i] = elements[i];
        }
        newStack[elements.length] = o;
        elements = newStack;
        if(minStack.peek() >= o){
            minStack.push(o);
        }

    }

    public int pop() {
        if (elements.length == 0) {
            throw new RuntimeException("stack is empty");
        }
        int element = elements[elements.length - 1];
        int[] newStack = new int[elements.length - 1];
        for (int i = 0; i < elements.length - 1; i++) {
            newStack[i] = elements[i];
        }
        elements = newStack;
        if(element == minStack.peek()){
            minStack.pop();
        }
        return element;
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    public int getMin() {
        if (elements.length == 0) {
            throw new RuntimeException("stack is empty");
        }
        return Arrays.stream(elements).min().getAsInt();
    }

    public int getMin2() {
        return minStack.peek();
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public int peek() {
        return elements[elements.length - 1];
    }


    public static void main(String[] args) {
        LeetCode_155 leetCode_155 = new LeetCode_155();
        leetCode_155.push(0);
        leetCode_155.push(-2);
        leetCode_155.push(-3);
        leetCode_155.pop();
        int min = leetCode_155.getMin2();
        System.out.println(min);
    }

}
