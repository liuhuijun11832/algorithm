package com.joy.leetcode;


/**
 * 盛最多水的容器
 */
public class MaxWaterContainer {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1, h = 0;
        while (left < right){
            h = Math.min(height[left], height[right]);
            max = Math.max(max, h * (right - left));
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
