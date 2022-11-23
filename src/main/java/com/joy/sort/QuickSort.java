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

    /**
     * 选定一个值作为比较值进行分区，再利用两个游标，分别和比较值进行对比，如果小于比较值，则两个游标交换
     * 如果不小于比较值，不进行交换
     * 比较值左边的分区视为已排序好的分区，右边的分区视为未排序好的分区
     * @param data
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] data, int start, int end){
        int pivot = data[end];
        int i = start, j = start;
        int tmp;
        while (j <= end - 1){
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
