package com.joy.greedy;

import java.util.Arrays;

import com.joy.search.BinarySearch;

/**
 * 贪心算法
 *
 * @author Joy
 * @date 2022-12-15
 */
public class GreedyAlgo {

    public static void main(String[] args) {
        System.out.println(CandyProblem());
    }

    public static int CandyProblem() {
        // 糖果，值为糖果大小
        int[] candy = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 孩子，值为孩子需要的糖果大小
        int[] kid = new int[] {2, 4, 5, 2, 1, 3, 3, 3, 20, 10, 10, 12};
        Arrays.sort(kid);
        int n = 0;
        int r = candy.length - 1;
        // 遍历孩子
        for (int j : kid) {
            // 二分查找糖果的大小，如果是-1表示符合的糖果没了
            int idx = BinarySearch.bSearch4(candy, j, 0, r);
            if (idx == -1) {
                break;
            }
            n++;
            System.arraycopy(candy, idx + 1, candy, idx, r - idx);
            r--;
        }
        return n;
    }

    public static int CoinProblem() {
        return 0;
    }

}
