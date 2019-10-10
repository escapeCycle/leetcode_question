package com.xunhuan.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Stream;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * <p>
 * Example:
 * Input: "{[]}"
 * Output: true
 * <p>
 * Example:
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Example:
 * Input: "([)]"
 * Output: false
 *
 * <p>
 * 可以使用栈(或者队列逆向取)
 */
public class LeetCode_20 {

    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.equals("")) return true;
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        int size = 0;
        for(char ch : chars){
            size++;
            if (isLeft(String.valueOf(ch))) {
                if(size == chars.length){
                    return false;
                }
                stack.push(String.valueOf(ch));
            } else {
                if (!stack.empty()) {
                    String strTail = stack.pop();
                    if (!isSymmetric(strTail, String.valueOf(ch))) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public boolean isLeft(String str) {
        if (str.equals("{") || str.equals("(") || str.equals("[")) {
            return true;
        }
        return false;
    }

    public boolean isSymmetric(String strA, String strB) {
        if (strA.equals("{") && strB.equals("}")) {
            return true;
        }
        if (strA.equals("[") && strB.equals("]")) {
            return true;
        }
        if (strA.equals("(") && strB.equals(")")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode_20 leetCode_20 = new LeetCode_20();
        boolean valid = leetCode_20.isValid("()");
        System.out.println(valid);

    }

}
