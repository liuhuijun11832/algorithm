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
            boolean isChanged = false;
            for (int j = 0; j < originalArray.length - i - 1; j++) {
                if(originalArray[j+1] < originalArray[j]){
                    int temp = originalArray[j];
                    originalArray[j] = originalArray[j+1];
                    originalArray[j + 1] = temp;
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
