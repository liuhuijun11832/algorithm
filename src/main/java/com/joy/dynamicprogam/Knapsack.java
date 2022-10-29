package com.joy.dynamicprogam;

/**
 * 动态规划-背包问题-原始版
 *
 * @author Joy
 * @date 2022-10-29
 */
public class Knapsack {

    public static void main(String[] args) {
        System.out.println( pack(new int[] {2, 2, 4, 6, 3}, 5, 9));
    }

    /**
     * 打包
     *
     * @param weights 物品数组
     * @param n       物品数量
     * @param w       背包最大重量
     * @return
     */
    public static int pack(int[] weights, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if (weights[0] <= w) {
            states[0][weights[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                // 第i个物品不放入背包，则第i个物品的重量和第i减1个物品的重量一致
                // 这样避免了多一次计算
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }
            // 如果第i个物品放入背包，根据上次是否放入，计算本次的重量
            for (int j = 0; j <= w - weights[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + weights[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

}
