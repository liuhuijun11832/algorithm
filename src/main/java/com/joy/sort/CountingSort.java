package com.joy.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 计数排序
 *
 * @author Joy
 * @date 2022-11-28
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] scores = new int[10];
        Random random = new Random();
        for (int j = 0; j < scores.length; j++) {
            int i = random.nextInt(701);
            scores[j] = i;
        }
        System.out.println(Arrays.stream(scores).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        int[] sort = CountingSort.sort(scores);
        System.out.println(Arrays.stream(sort).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }


    public static int[] sort(int[] scores){
        int max = 0,score,index = 0;
        while (index < scores.length){
            score = scores[index++];
            if(score > max){
                max = score;
            }
        }
        // 申请一个计数数组，分数就是下标
        int[] scoreRange = new int[max +1];
        for (int k : scores) {
            scoreRange[k]++;
        }
        // 计数数组内的数据依次累加求和
        // 表示小于等于某个分数的数有多少位
        for (int i = 1; i < scoreRange.length; i++) {
            scoreRange[i] += scoreRange[i - 1];
        }
        int[] sorted = new int[scores.length];
        for (int i = scores.length - 1; i >= 0; i--) {
            // 从score中倒序遍历.保证是稳定排序
            // 为什么需要倒序遍历，是因为前面计算分数数量的时候，是从前往后的，后进入的+1
            int j = scoreRange[scores[i]] - 1;
            sorted[j] = scores[i];
            scoreRange[scores[i]] --;
        }
        return sorted;
    }

}
