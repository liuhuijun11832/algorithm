package com.joy.array;

import java.util.StringJoiner;

/**
 * 有序数组
 *
 * @author Joy
 * @date 2022-11-16
 */
public class SortedList {

    /**
     * 数据
     */
    private int[] data;

    /**
     * 数组容量
     */
    private int capacity;

    /**
     * 数据实际数量
     */
    private int dataNum;

    public SortedList(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
    }

    public void insert(int value) {
        if (data == null) {
            data = new int[10];
        }
        if (dataNum == capacity) {
            resize();
        }
        int i = find(value, 0, dataNum - 1);
        if (i < dataNum - 1) {
            System.arraycopy(data, i + 1, data, i + 2, dataNum);
        }
        data[i + 1] = value;
        dataNum++;
        print();
    }

    private void print() {
        StringJoiner sb = new StringJoiner(",", "[", "]");
        for (int datum : data) {
            sb.add(datum + "");
        }
        System.out.println(sb);
    }

    public void update(int index, int value) {
        delete(index);
        insert(value);
        print();
    }

    public void delete(int index) {
        if (index < 0 || index >= dataNum) {
            System.out.println("index位置不合法");
            return;
        }
        System.arraycopy(data, index + 1, data, index, dataNum - index);
        dataNum--;
        print();
    }

    public static void main(String[] args) {
        SortedList sortedList = new SortedList(10);
        sortedList.insert(5);
        sortedList.insert(7);
        sortedList.insert(3);
        sortedList.insert(0);
        sortedList.insert(9);
        sortedList.insert(2);
        sortedList.insert(1);
        sortedList.insert(100);
        sortedList.delete(0);
        sortedList.delete(3);
    }

    private void resize() {
        int[] resizeArray = new int[data.length * 2];
        System.arraycopy(data, 0, resizeArray, 0, data.length);
        data = resizeArray;
    }

    /**
     * 查找到最后一个小于某个值的元素，然后返回下标
     *
     * @return
     */
    private int find(int value, int start, int end) {
        if (dataNum == 0) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (mid == 0) {
            return data[mid] > value ? -1 : mid;
        }
        // 如果mid的value大于给定值，从左边区间查找
        // 如果mid的value小于或者等于给定值，有两种情况
        // 1.mid是数组最后一个元素，或者mid的下一个是大于给定值的，mid就是最后一个
        // 2.mid不是数组最后一个元素，并且mid的下一个值不是大于给定值，再从右边区间查找
        if (data[mid] > value) {
            return find(value, start, mid - 1);
        } else {
            if (mid == dataNum - 1 || data[mid + 1] > value) {
                return mid;
            } else {
                return find(value, mid + 1, end);
            }
        }
    }
}
