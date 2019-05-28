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

    //比较是否回文
    public boolean palindrome() {
        //空链表直接为false
        if (head == null) return false;
        else {
            System.out.println("找到中间节点");
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }
            //两个指针，一个每次走一位，一个每次走两位，直到快的到达尾节点
            while (q.next != null && p.next != null) {
                p = p.next;
                q = q.next.next;
            }
            //通过这种方式找到的p即为中间节点
            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if (q.next == null) {
                //p一定为链表重点，且链表数目为奇数
                rightLink = p.next;
                //链表倒序一下的下一个节点则是左节点
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个节点" + leftLink.data);
                System.out.println("右边第一个节点" + rightLink.data);
            }else{
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return TFResult(leftLink, rightLink);
        }
    }

    public Node inverseLinkList(Node p){
        Node pre = null;
        Node r = head;
        Node next = null;
        while(r != p){
            //临时保存遍历到的节点的下一个节点
            next = r.next;
            //进行反转，将原来的前节点变成后节点
            r.next = pre;
            //保存当前节点
            pre = r;
            //将r往后移动一位
            r = next;
        }
        //跳出循环时，pre是p的前一个节点，所以还需要进行一次反转赋值
        r.next = pre;
        //返回左半部分的中点之前的节点
        //此处开始同步向两边比较
        return r;
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

