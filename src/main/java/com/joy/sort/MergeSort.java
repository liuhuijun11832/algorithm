package com.joy.sort;

/**
 * 归并排序
 * 排序两个子区间，然后合并
 * T(n)=2 * T(n/2) + n = 2 * (2 * T(n/4) + n/2) + n
 * =4 * T(n/4) + 2*n
 * =2^k * T(n/2^k) + k * n
 *
 * 由于T(1) = C常量级执行时间
 * 因此n/2^k = 1时，代入公式可得：T(n)=Cn+nlog2(n)
 * 根据加法法则，O(n) = nlog2(n)
 *
 *
 * @author Joy
 * @date 2022-11-17
 */
public class MergeSort {

    // 求解逆序对
    private static int num = 0;

    public static void main(String[] args) {
        int[] a = new int[]{3,2,6,1,3,4,8};
        sort(a, 0, 6);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 排序
     * 递归，然后合并
     * 首先选取重点，然后对左右分别进行排序
     * 最后进行合并
     * 合并就是将左右分区已经排序好的数据放到新的数组里
     *
     * @param a     待排序数组
     * @param start 开始位置
     * @param end   结束位置
     */
    public static void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int m = (start + end) / 2;
        sort(a, start, m);
        sort(a, m + 1, end);
        merge(a, start, m, end);

    }

    /**
     * 合并函数
     */
    public static void merge(int[] a, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
                num += mid - i + 1;
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }

        System.arraycopy(tmp, 0, a, start, tmp.length);
    }

}
