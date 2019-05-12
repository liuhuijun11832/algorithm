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

    public boolean contains(T t) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(t)) return true;
        }
        return false;
    }

    public int find(T t) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(t)) return i;
        }
        return -1;
    }

    /**
     * 增加某个元素，需要将该位置后面的元素集体后移（包括该位置），需要注意边界，是不是需要扩容，先扩容再移动
     * @param index
     * @param t
     */
    public void add(int index, T t) {
        checkIndex(index);
        if (size == data.length) resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = t;
        size++;
    }

    public void add(T t){
        add(size,t);
    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(size, t);
    }

    /**
     * 移除某个位置，要注意将某个位置后面的元素全部往前移。需要注意移动完以后是不是需要缩容
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndexForRemove(index);
        T t = data[index];
        for (int i = index + 1; i < size; i++) {
            //前移
            data[i - 1] = data[i];
        }
        size--;
        //将最后一位置为null
        data[size] = null;
        //缩容
        if (size == data.length / 4 && data.length / 2 != 0) resize(data.length / 2);
        return t;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeiLast() {
        return remove(size - 1);
    }

    public void removeElement(T t) {
        int index = find(t);
        if (index != -1) remove(index);
    }

    //扩容的时间复杂度是O(n)
    private void resize(int capacity) {
        T[] newDate = (T[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            newDate[i] = data[i];
        }
        data = newDate;
    }

    private void checkIndex(int index) {
        //这里是允许index==size，因为set用于add元素
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index must >=0 and index <= size");
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index must >= 0 and size < size");
    }


    private void printAll() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array size = %d,capacity = %d \n", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        GenericArray<String> genericArray = new GenericArray(5);
        genericArray.add("1");
        System.out.println(genericArray.toString());
        genericArray.printAll();
    }
}
