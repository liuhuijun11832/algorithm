package com.joy.string;

/**
 * bm算法
 */
public class BMAlgo {

    public static final int SIZE = 256;

    /**
     * 记录字符位置，用于生成坏字符规则
     *
     * @param b  模式串
     * @param m  模式串长度
     * @param bc 申请好的模式串hash表
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int ascii = b[i];
            bc[ascii] = i;
        }
    }

    /**
     * bm算法核心逻辑
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return
     */
    public int bm(char[] a, int n, char[] b, int m) {
        // 记录模式串各个字符的位置，下标为ascii码，值为出现在模式串中的下标
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        // i为当前主串和模式串对齐的位置
        int i = 0;
        while (i <= n - m) {
            // j为坏字符在模式串中出现的位置
            int j;
            for (j = m - 1; j >= 0; j--) {
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            // 没有找到坏字符，则此时主串和模式串匹配，返回对齐下标
            if (j < 0) {
                return i;
            }
            int y = 0;
            // 好后缀最后一位是m - 2，只要小于等于m-2就意味着存在好后缀
            if (j < m - 1) {
                y = moveByGS(j, m, suffix, prefix);
            }
            // 进行滑动，更新i的位置，重新进行对齐
            int x = j - bc[a[i + j]];
            i += Math.max(x, y);
        }
        return -1;
    }

    /**
     * 生成好后缀规则
     *
     * @param b      模式串
     * @param m      模式串长度
     * @param suffix 好后缀数组，下标是好后缀长度，值是好后缀对应的另外一个子串的起始下标
     * @param prefix 好后缀数组，下标是好后缀长度，值表示该长度能否找到对应的前缀子串
     */
    public void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        // 初始化数据
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        // 预处理模式串0~m-2位置的子串
        for (int i = 0; i < m - 1; i++) {
            // 从模式串i位置开始，逐个判断子串是否和好后缀匹配
            int j = i;
            // k表示好后缀长度
            int k = 0;
            // 第j位的字符和最后的字符相等，就是和好后缀相等的另外一个子串，所以k+1长度的下标就是j，然后--j往前再判断一位字符
            while (j >= 0 && b[j] == b[m - 1 - k]) {
                suffix[++k] = --j + 1;
            }
            // 如果j变成了-1，此时整个从0到i位的前缀子串和好后缀时完全匹配的，将prefix置为true
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    public int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        for (int i = j + 2; i < m; i++) {
            // m - 1 - i + 1，下标最大位m-1，但是长度还需要+1
            k = m - i;
            if (prefix[k]) {
                return k;
            }
        }
        return m;
    }

}
