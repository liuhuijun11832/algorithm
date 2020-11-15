package com.joy.sort;

/**
 * 选择排序:分为已排序区和未排序区，每次从未排序区找到最小的元素到已排序区结尾
 * 非稳定排序（每次都要交换到最小的元素到已排序空间）
 * 原地排序
 *
 *
 * @author Joy
 * @date 2020-11-15
 */
public class SelectionSort {

    public static int[] sort(int[] originalArray){
        if (originalArray == null) {
            return null;
        }
        for (int i = 0; i < originalArray.length; i++) {
            int min = originalArray[i];
            int changePos = i;
            for(int j = i + 1; j < originalArray.length; j ++){
                if(originalArray[j] < min){
                    min = originalArray[j];
                    changePos = j;
                }
            }
            int temp = originalArray[i];
            originalArray[i] = min;
            originalArray[changePos] = temp;
        }
        return originalArray;
    }

    public static void main(String[] args) {
        int[] originalArray = new int[]{2, 3, 4, 6, 1, 5, 10, 9, 8, 7};
        int[] afterSort = sort(originalArray);
        for (int i : afterSort) {
            System.out.println(i);
        }
    }
}
