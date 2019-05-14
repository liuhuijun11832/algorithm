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

    //无头节点
    //表头部插入，可以将输入的顺序进行逆序
    public void insertToHead(Node newNode){
        if(head == null) head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertToTail(Node newNode){
        if(head == null) head = newNode;
        else{
            Node q = head;
            while (q.next != null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void insertAfter(Node p,int value){
        Node newNode = new Node(value,null);
        insertAfter(p,newNode);
    }

    public void insertAfter(Node p,Node newNode){
        if(p == null) return;
        newNode.next = p;
        p.next = newNode;
    }

    public void insertBefore(Node p,int value){
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }

    public void insertBefore(Node p,Node newNode){
        if( p == null) return;
        if( p == head) insertToHead(newNode);
        else{
            Node q = head;
            if(q == null) return;
            while (q.next != p){
                q = q.next;
            }
            q.next = newNode;
            newNode.next = p;
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
