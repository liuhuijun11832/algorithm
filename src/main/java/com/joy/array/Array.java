package com.joy.array;

/**
 * @Description:
 * @Author: Joy
 * @Date: 2019-05-10 9:56
 */
public class Array {

    public int[] data;
    //数组长度
    private int n;
    //实际元素个数
    private int count;


    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     *@description
     *@author Joy
     *@params [index]
     *@return int
     */
    public int find(int index){
        if(index <0 || index > count) return -1;
        return data[index];
    }

    /**
     *@description
     *@author Joy
     *@params [index, value]
     *@return boolean
     */
    public boolean insert(int index,int value){
        if (n == count) {
            System.out.println("数组已满");
            return false;
        }

        if(index < 0 || index > n-1){
            System.out.println("位置不合法");
            return false;
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index){
        if(index < 0 || index > count - 1){
            System.out.println("位置不合法");
            return false;
        }

        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }
    public void printAll(){
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();

    }
}
