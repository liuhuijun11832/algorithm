package com.joy.sort;

/**
 * 冒泡排序
 *
 * @author Joy
 * @date 2020-11-08
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] originalArray){
        if (originalArray == null) {
            return null;
        }
        for (int i = 0; i < originalArray.length; i++) {
            int j = i + 1;
            boolean isChanged = false;
            for (; j < originalArray.length; j++) {
                if(originalArray[j] < originalArray[i]){
                    int temp = originalArray[j];
                    originalArray[j] = originalArray[i];
                    originalArray[i] = temp;
                    isChanged = true;
                }
            }
            if(!isChanged){
                break;
            }
        }
        return originalArray;
    }

    public static void main(String[] args) {
        int[] originalArray = new int[]{2, 3, 4, 6, 1, 5, 10, 9, 8, 7};
        int[] afterSort = bubbleSort(originalArray);
        for (int i : afterSort) {
            System.out.println(i);
        }
    }
}
