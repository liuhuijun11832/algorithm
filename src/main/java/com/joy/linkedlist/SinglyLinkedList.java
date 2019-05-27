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
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    //无头节点
    //表头部插入，可以将输入的顺序进行逆序
    public void insertToHead(Node newNode) {
        if (head == null) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertToTail(Node newNode) {
        if (head == null) head = newNode;
        else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;
        newNode.next = p;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (p == head) insertToHead(newNode);
        else {
            Node q = head;
            if (q == null) return;
            while (q.next != p) {
                q = q.next;
            }
            q.next = newNode;
            newNode.next = p;
        }
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) return;
        if (p == head) {
            head = head.next;
            return;
        }
        Node q = head;
        while (q != null || q.next != p) {
            q = q.next;
        }
        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (null == head) return;
        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if (p == null) return;
        if (q == null) head = head.next;
    }

    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);
        while (l != null && r != null) {
            if (r.data == l.data) {
                l = l.next;
                r = r.next;
                continue;
            } else break;
        }
        System.out.println("什么结果");
        if (l == null && r == null) {
            System.out.println("什么结果");
            return true;
        } else return false;
    }

    public boolean palindrome() {
        if (head == null) return false;
        else {
            System.out.println("找到中间节点");
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }
            while (q.next != null && p.next != null) {
                p = p.next;
                q = q.next.next;
            }
            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if (q.next == null) {
                rightLink = p.next;

            }
        }
        return false;
    }


    public static class Node {
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

