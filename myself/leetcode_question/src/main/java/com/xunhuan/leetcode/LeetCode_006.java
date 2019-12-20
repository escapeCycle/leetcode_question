package com.xunhuan.leetcode;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;

/**
 * @author th
 * <p>
 * question:ZigZag Conversion
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class LeetCode_006 {


    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1) return s;
        if (numRows <= 1) return s;
        if (numRows >= s.length()) return s;

        int len = s.length();

        int col = 0;

        int limit = numRows - 1;

        if ((len - numRows) % ((numRows - 1) * 2) <= (numRows - 1)) {
            col = 1 + (len - numRows) / ((numRows - 1) * 2) * (numRows - 1) + (len - numRows) % ((numRows - 1) * 2);
        } else {
            col = 1 + (len - numRows) / ((numRows - 1) * 2) * (numRows - 1) + numRows - 1;
        }

        String[][] strArr = new String[numRows][col];

        int stepx = 0;
        int stepy = 0;

        int param = 0;


        char[] chars = s.toCharArray();
        strArr[0][0] = String.valueOf(chars[0]);
        for (int i = 1; i < chars.length; ++i) {
            if (param < limit) {
                param++;
            } else {
                param = -param;
            }
            if (param == 0) {
                i--;
                continue;
            }

            if (param > 0) {
                stepx++;
            } else {
                stepx--;
                stepy++;
            }
            strArr[stepx][stepy] = String.valueOf(chars[i]);
        }

        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < col; ++j) {
                if ("".equals(strArr[i][j]) || strArr[i][j] == null) {
                    continue;
                }
                resStr.append(strArr[i][j]);
            }
        }
        return resStr.toString();
    }


    public static void main(String[] args) {
        LeetCode_006 leetCode_006 = new LeetCode_006();
        String paypalishiring = leetCode_006.convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring);

    }
}
