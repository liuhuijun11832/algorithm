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
        int[] a = new int[] {1, 2, 3, 4, 5};
        System.out.println(BinarySearch.bSearch1(a, 3, 0, a.length - 1));//第一次出现的下标为2
        int[] b = new int[] {1, 2, 2, 3, 4, 5};
        System.out.println(BinarySearch.bSearch2(b, 2, 0, b.length - 1));//第一次出现的下标为1
        System.out.println(BinarySearch.bSearch3(b, 2, 0, b.length - 1));//最后一次出现的下标为2
        System.out.println(BinarySearch.bSearch4(b, 4, 0, b.length - 1));// 第一个大于等于4的下标为4
        System.out.println(BinarySearch.bSearch5(b, 2, 0, b.length - 1));// 最后一个小于等于2的下标为2
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
            int mid = l + ((r - l) >> 1);
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
            int mid = l + ((r - l) >> 1);
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
        if (l > r) {
            return -1;
        }
        int mid = l + ((r - l) >> 1);
        if (a[mid] < value) {
            l = mid + 1;
        } else if (a[mid] > value) {
            r = mid - 1;
        } else {
            // 警惕数组越界，如果mid是数组最后一个就不用再判断下一位
            if (mid == a.length - 1 || a[mid + 1] != value) {
                return mid;
            } else {
                // 右边还有，需要从右边查询
                l = mid + 1;
            }
        }
        return bSearch3(a, value, l, r);
    }

    /**
     * 二分查询变种，存在重复元素，查询第一个大于等于给定值的元素
     *
     * @param a 给定数组
     * @param value 给定值
     * @param l 左下标
     * @param r 右下标
     * @return
     */
    public static int bSearch4(int[] a, int value, int l, int r) {
        // 这次用递归的写法
        // 终止条件
        if (l > r) {
            return -1;
        }
        int mid = l + ((r - l) >> 1);
        if (a[mid] < value) {
            l = mid + 1;
        } else {
            if (mid == 0 || a[mid - 1] < value) {
                return mid;
            }
            r = mid - 1;
        }
        return bSearch4(a, value, l, r);
    }

    /**
     * 二分查询变种，存在重复元素，查询最后一个小于等于给定值的元素
     *
     * @param a
     * @param value
     * @param l
     * @param r
     * @return
     */
    public static int bSearch5(int[] a, int value, int l, int r) {
        // 这次用递归的写法
        // 终止条件
        if (l > r) {
            return -1;
        }
        int mid = l + ((r - l) >> 1);
        if (a[mid] > value) {
            r = mid - 1;
        } else {
            if (mid == a.length - 1 || a[mid + 1] > value) {
                return mid;
            }
            l = mid + 1;
        }
        return bSearch5(a, value, l, r);
    }

}
