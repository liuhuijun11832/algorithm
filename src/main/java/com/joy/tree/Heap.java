package com.joy.tree;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.crypto.Cipher;

/**
 * 堆和堆排序
 *
 * @author Joy
 * @date 2022-12-08
 */
public class Heap {

    /**
     * 堆
     */
    private int[] a;

    /**
     * 堆最大可存储数据数量
     */
    private int n;

    /**
     * 已经存储数量
     */
    private int count;

    public static void main(String[] args) {
        Heap heap = new Heap(100);
        heap.insert(0);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(4);
        heap.insert(1);
        heap.insert(30);
        heap.insert(6);
        heap.print();
        heap.delete(0, 30);
        heap.print();
    }

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public Heap(int[] a) {
        a = new int[a.length + 1];
        n = a.length;
        count = a.length;
    }

    public void insert(int data) {
        // 堆满
        if (count >= n) {
            return;
        }
        // 将数据添加到数组最后一位
        a[++count] = data;
        int i = count;
        // 依次和父节点进行比较，大顶堆的话父节点最大，所以如果父节点小于当前插入的节点，就进行交换
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }

    }

    public void delete(int i, int data) {
        // 堆空、下标超过count、堆顶小于data的情况
        if (count == 0 || i > count || a[1] < data) {
            return;
        }
        if (i == 0) {
            i = 1;
        }
        if (a[i] > data) {
            // 递归删除左子树
            delete(i * 2, data);
            // 递归删除右子树
            delete((i * 2) + 1, data);
        } else {
            // 删除i位置，只需要将数组中最后一个元素拿过来，数量减1
            a[i] = a[count--];
            heapify(a, i, count);
        }
    }

    public static Heap buildHeap(int[] a, int count){
        // 方法1
        Heap heap = new Heap(a.length);
        for (int i = 2; i < a.length; i++) {
            heap.insert(a[i]);
        }
        // 方法2
        Heap heap1 = new Heap(a);
        for(int i = count / 2; i >= 1; --i) {
            heap1.heapify(a, count, i);
        }
        return heap;
    }

    /**
     * 堆化
     * 每个节点堆化的时间复杂度都是O(logn)
     * @param a 数组
     * @param i 堆化的子树的根节点
     * @param n 堆化到的最后一个元素的下标
     */
    private void heapify(int[] a,int i, int n){
        while (true) {
            // 调整过以后，找到子树中最大元素的位置，然后和当前位置i进行交换，记录最大位置
            int maxPos = i;
            // 先找i节点的左子树，下标没有超过数组阈值，并且当前节点小于左子树节点，更新最大位置
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            // 再找右子树的最大值，如果下标没有超过数组阈值，并且最大位置的值小于右子树某个节点，更新最大位置
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 如果当前就是最大值，因为两个子树肯定是满足堆要求的，所以直接跳出
            if (maxPos == i) {
                break;
            }
            // 找到的最大值和i进行交换，再以maxPos为根节点继续找
            swap(i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int i, int j) {
        int tmp = this.a[i];
        this.a[i] = this.a[j];
        this.a[j] = tmp;
    }

    private void print() {
        System.out.println(Arrays.stream(this.a).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}
