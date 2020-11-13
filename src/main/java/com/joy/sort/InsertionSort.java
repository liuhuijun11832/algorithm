package com.joy.sort;

/**
 * 插入排序
 *
 * @author Joy
 * @date 2020-11-12
 */
public class InsertionSort {

    public static int[] insertionSort(int[] originalArray){
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
        int[] originalArray = new int[]{2, 3, 4, 6, 1, 5, 10, 9, 8, 7};
        int[] afterSort = insertionSort(originalArray);
        for (int i : afterSort) {
            System.out.println(i);
        }
    }

}
