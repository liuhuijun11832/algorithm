package com.joy.array;

/**
 * @Description:
 * @Author: Joy
 * @Date: 2019-05-10 11:25
 */
public class GenericArray<T> {

    private T[] data;
    //数组实际包含的元素数量
    private int size;

    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public GenericArray() {
        this(10);
    }

    public int getLength() {
        return data.length;
    }

    public int count() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T t) {
        checkIndex(index);
        data[index] = t;
    }

    public T get(int index) {
        return data[index];
    }

    public boolean contains(T t){
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(t)) return true;
        }
        return false;
    }

    public int find(T t){
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(t)) return i;
        }
        return -1;
    }

    public void add(int index,T t){

    }
    private void checkIndex(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index must >=0 and <= size");
    }



    private void printAll() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        GenericArray<String> genericArray = new GenericArray(5);
        genericArray.set(0, "1");
        genericArray.printAll();
    }
}
