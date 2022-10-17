package com.joy.leetcode;

/**
 * 整型翻转
 */
public class ReverseInteger {

    public static void main(String[] args) {
            System.out.println(new ReverseInteger().reverse(32768));
    }

    public int reverse(int x) {
        int  res = 0, tmp = 0, compareMax = Integer.MAX_VALUE / 10, compareMin = Integer.MIN_VALUE / 10,
        a = Integer.MAX_VALUE % 10, b = Integer.MIN_VALUE % 10;

        while (x != 0){
            tmp = x % 10;
            x = x / 10;
            // 溢出判断
            if(res > compareMax || res < compareMin){
                return 0;
            } else if ((res == compareMax && tmp == a) || (res == compareMin && (tmp == b))) {
                return 0;
            } else{
                res = res * 10 + tmp;
            }
        }
        return res;
    }
}
