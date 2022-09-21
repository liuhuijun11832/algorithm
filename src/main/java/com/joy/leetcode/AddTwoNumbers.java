package com.joy.leetcode;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * @author Joy
 * @date 2022-09-21
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1c = new ListNode(2);
        ListNode l1b = new ListNode(4, l1c);
        ListNode l1 = new ListNode(9, l1b);

        ListNode l2c = new ListNode(5);
        ListNode l2b = new ListNode(6, l2c);
        ListNode l2a = new ListNode(4, l2b);
        ListNode l2 = new ListNode(9, l2a);

        ListNode next = addTwoNumbers(l1, l2);
        while (next != null){
            System.out.println(next.val);
            next = next.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        ListNode next = l1;
        while (next  != null){
            sb.append(next.val);
            next = next.next;
        }
        int i1 = Integer.parseInt(sb.toString());
        sb = new StringBuilder();
        next = l2;
        while (next != null){
            sb.append(next.val);
            next = next.next;
        }
        int i2 = Integer.parseInt(sb.toString());
        int i3 = i1 + i2;
        ListNode listNode = null;
        char[] chars = String.valueOf(i3).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int val = Integer.parseInt(String.valueOf(chars[i]));
            if(listNode == null){
                listNode = new ListNode(val);
            }else{
                listNode = new ListNode(val, listNode);
            }

        }
        return listNode;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
