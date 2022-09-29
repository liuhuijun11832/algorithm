package com.joy.leetcode;


/**
 * 寻找两个正序数组的中位数
 */
public class MedianOfTwoSortedArrays {


    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] m1 = new int[]{1};
        int[] m2 = new int[]{};
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(m1, m2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int total = nums1.length + nums2.length;
        int index = total - 2;
        int[] merge = new int[total];
        while ((i + j) < total) {
            if (nums1.length != 0 && i <= nums1.length - 1 && (j == nums2.length || nums1[i] < nums2[j])) {
                merge[i + j] = nums1[i];
                i++;
            } else {
                merge[i + j] = nums2[j];
                j++;
            }
        }

        int medium = total >> 1;
        int a = index % 2;
        if(total == 1){
            return merge[0];
        }
        if (a > 0) {
            return merge[medium];
        } else {
            return (merge[medium - 1] + merge[medium]) / 2.0;
        }
    }
}
