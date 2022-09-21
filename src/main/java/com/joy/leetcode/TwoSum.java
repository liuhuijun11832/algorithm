package com.joy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author Joy
 * @date 2022-09-15
 */
public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }

}
