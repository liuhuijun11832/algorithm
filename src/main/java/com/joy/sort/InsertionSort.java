package com.joy.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 插入排序:分为两个区域，每次从为未序区域找第一个元素放到已排序区合适的位置
 *
 * 最好时间复杂度,只需要遍历 o(n)
 * 最差时间复杂度，每次循环都需要插入到第1位所以是 o(n2)
 * 稳定排序
 * 原地排序
 *
 * @author Joy
 * @date 2020-11-12
 */
public class InsertionSort {

    public static int[] sort(int[] originalArray){
        if (originalArray == null) {
            return null;
        }
        for (int i = 1; i < originalArray.length; i++) {
            int value = originalArray[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(originalArray[j] > value){
                    originalArray[j + 1] = originalArray[j];
                }else{
                    break;
                }
            }
            originalArray[j + 1] = value;
        }
        return originalArray;
    }

    public static void main(String[] args) {
        //int[] originalArray = new int[]{2, 3, 4, 6, 1, 5, 10, 9, 8, 7};
        //int[] afterSort = sort(originalArray);
        //for (int i : afterSort) {
        //    System.out.println(i);
        //}

        int count = 1000;

        Random random = new Random();
        List<int[]> lists = new ArrayList<int[]>(1000);
        for (int j = 0; j < 1000; j++) {
            int[] origin = new int[count];
            for (int i = 0; i < count; i++) {
                origin[i] = random.nextInt(count);
            }
            lists.add(origin);
        }
        long curr = System.currentTimeMillis();
        for (int[] list : lists) {
            InsertionSort.sort(list);
        }
        System.out.println(System.currentTimeMillis() - curr);
        curr = System.currentTimeMillis();
        for (int[] list : lists) {
            BubbleSort.sort(list);
        }
        System.out.println(System.currentTimeMillis() - curr);
        curr = System.currentTimeMillis();
        for (int[] list : lists) {
            SelectionSort.sort(list);
        }
        System.out.println(System.currentTimeMillis() - curr);
    }

}
