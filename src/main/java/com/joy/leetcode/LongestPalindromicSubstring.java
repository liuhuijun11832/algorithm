package com.joy.leetcode;

/**
 * 最长回文
 *
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babba"));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0, len = 0;
        for (int i = 0; i < chars.length; i++) {
            int n1 = extrated(chars, i, i);
            int n2 = extrated(chars, i, i + 1);
            int n = Math.max(n1, n2);
            if(n > len){
                len = n;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + len);
    }

    public int extrated(char[] chars, int left, int right){
        int length = chars.length;
        while (left >= 0 && right < length){
            if(chars[left] != chars[right]){
                break;
            }
            if(chars[left] == chars[right]){
                left--;
                right++;
            }
        }
        return right - left - 1;
    }

}
