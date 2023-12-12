package com.joy.backtracking;

/**
 * 回溯算法解决背包问题
 *
 * @author Joy
 * @date 2022-12-26
 */
public class Knapsack {

    // 存储包中重量最大时的最大值
    private int maxW = Integer.MIN_VALUE;

    /**
     * @param i     考察的物品
     * @param cw    当前背包总重
     * @param items 每个物品的重量
     * @param n     物品个数
     * @param w     背包重量
     */
    public void pack(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
                return;
            }
        }
        // 考察下一个，不放进去的情况
        pack(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {
            // 如果还可以放，再尝试考察一下将下一个放进去的情况
            pack(i + 1, cw + items[i], items, n, w);
        }
    }

}
