package com.joy.leetcode;

public class PalindromeNum {

    public static void main(String[] args) {
        PalindromeNum palindromeNum = new PalindromeNum();
        System.out.println(palindromeNum.isPalindrome(121));
        System.out.println(palindromeNum.isPalindrome(-121));
        System.out.println(palindromeNum.isPalindrome(10));
        System.out.println(palindromeNum.isPalindrome(-101));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = x, cursor = 0;
        while (n != 0) {
            cursor = cursor * 10 + n % 10;
            n = n / 10;
        }
        return cursor == x;
    }

}
