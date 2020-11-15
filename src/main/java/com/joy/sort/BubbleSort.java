package com.joy.sort;

/**
 * 冒泡排序:相邻数据比较交换
 * 时间复杂度O(n2)
 * 原地排序
 * 稳定排序
 *
 *
 * @author Joy
 * @date 2020-11-08
 */
public class BubbleSort {

    /**
     *  内层循环条件是 j = 0, j < originalArray.length，可以增加一个循环跳出条件
     * @param originalArray
     * @return
     */
    public static int[] sort(int[] originalArray){
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
        int[] afterSort = sort(originalArray);
        for (int i : afterSort) {
            System.out.println(i);
        }
    }

    /**
     * 排序相关：
     * 原地排序：不需要额外空间存储(不包含交换所需的临时空间),即空间复杂度O(1)
     * 稳定排序：排序完不会导致原数组中相同的两个元素交换顺序
     * 满有序度：一个排序好的数组的有序度=n(n-1)/2
     * 有序度：数组中有序元素对个数
     * 逆序度：与有序度相反，通常有序度+逆序度 = 满有序度
     */
}
