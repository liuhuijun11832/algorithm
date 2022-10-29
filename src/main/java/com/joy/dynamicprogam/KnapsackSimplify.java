package com.joy.dynamicprogam;

/**
 * 动态规划-背包问题-简化版代码
 * 满足背包最大重量的前提下，背包中物品总重量的最大值
 *
 * @author Joy
 * @date 2022-10-29
 */
public class KnapsackSimplify {

    public static void main(String[] args) {
        System.out.println( pack(new int[] {2, 2, 4, 6, 3}, 5, 9));
    }

    public static int pack(int[] items, int n, int w){
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        if (items[0] <= w) {
            states[items[0]] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = w - items[i]; j >= 0; j--) {
                if (states[j]) {
                    states[j + items[i]] = true;
                }
            }
        }
        for (int i = w; i > 0; i--) {
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }

}
