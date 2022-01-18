package com.pwh.leetcode.math;

/**
 * @author: Waver Pan
 * @date: 2022/1/18 16:52
 */
public class 两数相加 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 在两条链表上的指针
            ListNode p1 = l1, p2 = l2;
            // 虚拟头结点（构建新链表时的常用技巧）
            ListNode dummy = new ListNode(-1);
            // 指针 p 负责构建新链表
            ListNode p = dummy;
            // 记录进位
            int carry = 0;
            // 开始执行加法，两条链表走完且没有进位时才能结束循环
            while (p1 != null || p2 != null || carry > 0) {
                //先加上次的进位
                int val = carry;
                if (p1 != null){
                    val += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null){
                    val += p2.val;
                    p2 = p2.next;
                }
                //处理进位
                carry = val / 10;
                val = val % 10;
                //构建新节点
                p.next = new ListNode(val);
                p = p.next;
            }
            return dummy.next;
        }
    }
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        // 在两条链表上的指针
//        ListNode p1 = l1, p2 = l2;
//        // 虚拟头结点（构建新链表时的常用技巧）
//        ListNode dummy = new ListNode(-1);
//        // 指针 p 负责构建新链表
//        ListNode p = dummy;
//        // 记录进位
//        int carry = 0;
//        // 开始执行加法，两条链表走完且没有进位时才能结束循环
//        while (p1 != null || p2 != null || carry > 0) {
//            // 先加上上次的进位
//            int val = carry;
//            if (p1 != null) {
//                val += p1.val;
//                p1 = p1.next;
//            }
//            if (p2 != null) {
//                val += p2.val;
//                p2 = p2.next;
//            }
//            // 处理进位情况
//            carry = val / 10;
//            val = val % 10;
//            // 构建新节点
//            p.next = new ListNode(val);
//            p = p.next;
//        }
//        // 返回结果链表的头结点（去除虚拟头结点）
//        return dummy.next;
//    }
//}

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode4 = new ListNode(4);
        listNode5.next = listNode6;
        listNode6.next = listNode4;
//        System.out.println(listNode+"");

        ListNode resultNode = new 两数相加().new Solution().addTwoNumbers(listNode, listNode5);

        for (ListNode l = resultNode; l!=null; l=l.next){
            System.out.println(l.val);
        }

//        do {
//            System.out.println(resultNode.val);
//            resultNode = resultNode.next;
//        }while (resultNode != null);

//        while (resultNode != null){
//            System.out.println(resultNode.val);
//            resultNode = resultNode.next;
//        }

    }
}
