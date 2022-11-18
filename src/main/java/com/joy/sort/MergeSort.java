package com.joy.sort;

/**
 * 插入排序
 *
 * @author Joy
 * @date 2022-11-17
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{3,2,6,1,3,4,8};
        sort(a, 0, 6);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 排序
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
