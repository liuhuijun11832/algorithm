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
        int carry = 0,num = 0;
        ListNode result = new ListNode();
        ListNode next = result;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            num = val % 10;
            carry = val / 10;
            next.next = new ListNode(num);
            next = next.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int val = l1.val + carry;
            carry = val / 10;
            num = val % 10;
            next.next = new ListNode(num);
            next = next.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int val = l2.val + carry;
            carry = val / 10;
            num = val % 10;
            next.next = new ListNode(num);
            next = next.next;
            l2 = l2.next;
        }

        if(carry > 0){
            next.next = new ListNode(carry);
        }

        return result.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
