package com.joy.leetcode;

import java.util.Arrays;

/**
 * Z字形变换
 * <a href="https://leetcode.cn/problems/zigzag-conversion/"></a>
 */
public class ZigzagConversion {


    public static void main(String[] args) {
        ZigzagConversion z = new ZigzagConversion();
        System.out.println(z.convert("PAYPALISHIRING", 3));
        System.out.println(z.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows == 1) {
            return s;
        }
        int rowNum = 1, cursor, index = 0;
        char[] chars = new char[s.length()];
        int interval = numRows - 2;
        while (rowNum <= numRows) {
            cursor = rowNum - 1;
            if (interval <= 0) {
                while (cursor < s.length()) {
                    chars[index++] = s.charAt(cursor);
                    cursor += 2;
                }
            } else {
                if (rowNum == 1 || rowNum == numRows) {
                    while (cursor < s.length()) {
                        chars[index++] = s.charAt(cursor);
                        cursor += (numRows - 1) * 2;
                    }
                } else {
                    int temp = numRows - rowNum;
                    while (cursor < s.length()) {
                        chars[index++] = s.charAt(cursor);
                        cursor += temp * 2;
                        temp = numRows - 1 - temp;
                    }
                }
            }
            rowNum++;
        }
        return new String(chars);
    }

}
