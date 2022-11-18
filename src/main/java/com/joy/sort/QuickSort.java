package com.joy.sort;

/**
 * 快速排序
 *
 * @author Joy
 * @date 2022-11-16
 */
public class QuickSort {

    public static void sort(int[] data, int start, int end){
        if(start >= end){
            return;
        }
        int partition = partition(data, start, end);
        sort(data, start, partition - 1);
        sort(data, partition + 1, end);
    }

    public static int partition(int[] data, int start, int end){
        int pivot = data[end];
        int i = start, j = start;
        int tmp;
        while (j < end - 1){
            if(data[j] < pivot){
                tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                i++;
            }
            j++;
        }
        tmp = data[i];
        data[i] = data[end];
        data[end] = tmp;
        return i;
    }




    public static void main(String[] args) {
        int[] a = new int[]{3,2,6,1,3,4,8};
        QuickSort.sort(a, 0, 6);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
