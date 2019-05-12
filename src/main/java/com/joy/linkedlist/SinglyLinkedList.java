package com.joy.linkedlist;

/**
 * @Description 简单链表
 * @Author Joy
 * @Date 2019-05-12 18:38
 */
public class SinglyLinkedList {

    //表示空链表
    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while(p != null && p.data != value){
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while(p != null && pos != index){
            p = p.next;
            pos++;
        }
        return p;
    }

    public void insertToHead(int value){
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode){
        if(head == null) head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}
