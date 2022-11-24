package com.joy.linkedlist;

import java.util.StringJoiner;

/**
 * LRU缓存
 *
 * @author Joy
 * @date 2022-11-24
 */
public class LRUCache {

    private CacheNode head;

    /**
     * 缓存容量
     */
    private int capacity;

    /**
     * 缓存数据数量
     */
    private int cacheSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void lruPut(int data) {
        if (head == null) {
            head = new CacheNode(data, null);
            cacheSize++;
            return;
        }
        CacheNode pre = null;
        CacheNode curr = head;
        while (curr.data != data && curr.next != null) {
            pre = curr;
            curr = curr.next;
        }
        // 缓存未满的情况下，数据直接插入
        // 缓存已经满的情况下，数据需要先删除再插入
        if (curr.next == null && curr.data != data) {
            if (cacheSize == capacity) {
                if (pre != null) {
                    pre.next = null;
                }
            }
            head = new CacheNode(data, head);
        } else {
            // 如果缓存中找到了该数据
            // 删除旧节点，然后插入到头
            // 删除
            if (pre != null) {
                pre.next = curr.next;
            }
            // 插入到头节点之前
            curr.next = head;
        }
        cacheSize++;
        printAll();
    }

    public void printAll(){
        if(head != null){
            StringJoiner stringJoiner = new StringJoiner(",");
            CacheNode curr = head;
            while (curr != null){
                stringJoiner.add(curr.data + "");
                curr = curr.next;
            }
            System.out.println(stringJoiner);
        }
    }

    public static class CacheNode {

        private int data;

        private CacheNode next;

        public CacheNode(int data, CacheNode next) {
            this.next = next;
            this.data = data;
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.lruPut(1);
        cache.lruPut(2);
        cache.lruPut(3);
        cache.lruPut(4);
    }

}
