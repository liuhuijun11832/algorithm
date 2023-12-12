package com.joy.leetcode;

import java.util.HashSet;

/**
 * 字符串转数字
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        StringToIntegerAtoi aaaa = new StringToIntegerAtoi();
        System.out.println(aaaa.myAtoi("    -42"));
        System.out.println(aaaa.myAtoi("42"));
        System.out.println(aaaa.myAtoi("4193 with words"));
        System.out.println(aaaa.myAtoi("     with words 20010"));
        System.out.println(aaaa.myAtoi("+1"));
    }

    public int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        // 状态机 0表示初始，1表示符号，2表示数字，3表示结束
        int state = 0, result = 0, index = 0, sign = 1;
        while (state != 3 && index < s.length()) {
            char c = s.charAt(index);
            if (state == 0 && (c == '-' || c == '+')) {
                state = 1;
                if (c == '-') {
                    sign = -1;
                }
            } else if (Character.isDigit(c)) {
                if(state == 0){
                    state = 1;
                }
                if(state == 1){
                    result = (c - '0') * sign;
                }else {
                    if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)){
                        return Integer.MAX_VALUE;
                    }else if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10))){
                        return Integer.MIN_VALUE;
                    }
                    result = result * 10 + (c - '0') * sign;
                }
                state = 2;
            } else {
                state = 3;
            }
            index++;
        }
        return result;
    }

}
