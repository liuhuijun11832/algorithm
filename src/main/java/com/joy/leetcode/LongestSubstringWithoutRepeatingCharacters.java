package com.joy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 无重复字符的最长串
 * @Author Joy
 * @Date 2022-09-24 11:42
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("bbbbb");
        lengthOfLongestSubstring("pwwkew");
        lengthOfLongestSubstring("abba");
        lengthOfLongestSubstring("dvdf");
        lengthOfLongestSubstring("tmmzuxt");
    }

    public static int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        char[] chars = s.toCharArray();
        int max = 0, start = 0;
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 如果包含了该字符的情形
            if (lastIndexMap.containsKey(c)) {
                // 判断该字符上一次出现的位置
                Integer lastIndex = lastIndexMap.get(c);
                // 该字符重复出现上次位置远大于窗口起始，并且窗口起始位置小于上次位置
                if (start < lastIndex) {
                    start = lastIndex + 1;
                } else if (lastIndex == start) {
                    start++;
                }
            }

            max = Math.max(max, i - start + 1);

            lastIndexMap.put(c, i);
        }

        return max;
    }

}
