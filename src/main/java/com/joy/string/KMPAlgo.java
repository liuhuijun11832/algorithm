package com.joy.string;

/**
 * kmp算法
 */
public class KMPAlgo {

    public int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; i++) {
            // 表示主串中的i位和模式串中的j位匹配到了坏字符，则找到最长可匹配前缀子串的长度
            while (j > 0 && a[i] != b[j]) {
                // next[j - 1]为好前缀中最长可匹配前缀子串的最后一个字符下标，+1为最长可匹配前缀的长度
                j = next[j - 1] + 1;
            }
            // 主串中下标为i等于模式串下标为j时，i++和j++，继续比较下一个主串字符，直到j=m为止
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 生成next数组
     * 通过生成所有模式串的前缀子串，找到能够和最长后缀子串匹配的最长前缀子串
     * @param b
     * @param m
     * @return
     */
    private int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        // k是模式串的前缀子串的
        int k = -1;
        // i是要对比模式串的字符位置
        for (int i = 1; i < m; i++) {
            // 这里当模式串的子串长度后移一位，判断后移1位的字符是否和当前前缀子串的后一位字符相等
            // 如果不相等，将k重置成当前0到k子串的最长可匹配前缀子串的尾字符下标，也就是模式串后移公共前后缀子串长度
            // 然后用k+1和当前i对比，相等的话，公共前后缀长度位+1，重复执行
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            // 如果前一个子串的最长可匹配前缀子串的尾字符下标的下一位和i相等，则公共前后缀长度可以+1位
            if (b[k + 1] == b[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
