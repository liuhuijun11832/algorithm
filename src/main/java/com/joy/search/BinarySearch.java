package com.joy.search;

/**
 * 二分查找
 * log(n)复杂度的算法
 * 要求数据有序
 *
 * @author Joy
 * @date 2022-11-29
 */
public class BinarySearch {

    public static void main(String[] args) {

    }

    /**
     * 简单二分查询
     * 不存在重复元素
     *
     * @param a
     * @param value
     * @return
     */
    public static int bSearch1(int[] a, int value, int l, int r) {
        while (l <= r) {
            int mid = l + ((r - l) >> 2);
            if (a[mid] == value) {
                return mid;
            }
            if (a[mid] < value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查询变种，存在重复元素，查询第一个出现的位置
     *
     * @param a
     * @param value
     * @param l
     * @param r
     * @return
     */
    public static int bSearch2(int[] a, int value, int l, int r) {
        while (l <= r) {
            int mid = l + ((r - l) >> 2);
            if (a[mid] < value) {
                l = mid + 1;
            } else if (a[mid] > value) {
                r = mid - 1;
            } else {
                // 如果mid值在左半区间没有重复，认为是第一个
                // 要注意数组越界
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查询变种，存在重复元素，查询最后出现的位置
     *
     * @param a
     * @param value
     * @param l
     * @param r
     * @return
     */
    public static int bSearch3(int[] a, int value, int l, int r) {
        // 这次用递归的写法
        // 终止条件
        if (l >= r) {
            return -1;
        }
        int mid = l + ((r - l) >> 2);
        if (a[mid] < value) {
            l = mid + 1;
        } else if (a[mid] > value) {
            r = mid - 1;
        } else {
            // 警惕数组越界，如果mid是数组最后一个就不用再判断下一位
            if (mid == a.length - 1 || a[mid + 1] != value) {
                return mid;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查询变种，存在重复元素，查询第一个大于等于给定值的元素
     *
     * @param a
     * @param value
     * @param l
     * @param r
     * @return
     */
    public static int bSearch4(int[] a, int value, int l, int r) {
        // 这次用递归的写法
        // 终止条件
        if (l >= r) {
            return -1;
        }
        int mid = l + ((r - l) >> 2);
        if (a[mid] < value) {
            l = mid + 1;
        } else if (a[mid] > value) {
            r = mid - 1;
        } else {
            // 警惕数组越界，如果mid是数组最后一个就不用再判断下一位
            if (mid == a.length - 1 || a[mid + 1] != value) {
                return mid;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
