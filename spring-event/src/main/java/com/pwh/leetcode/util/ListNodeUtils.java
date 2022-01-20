package com.pwh.leetcode.util;

import com.pwh.leetcode.math.ListNode;

/**
 * 链表工具类
 *
 * @author: Waver Pan
 * @date: 2022/1/20 14:43
 */
public class ListNodeUtils {
    /**
     * 循环打印链表
     *
     * @param listNode
     */
    public static void print(ListNode listNode) {
        for (ListNode l = listNode; l != null; l = l.next) {
            System.out.println(l.val);
        }
    }

    /**
     * 根据数组构建链表
     *
     * @param array
     * @return
     */
    public static ListNode buildListNode(int[] array) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for (int val : array) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void getDeepNode(ListNode listNode, int deep) {
        if (deep == 0) {
            return;
        }
        for (; deep > 0; deep--) {
            listNode = listNode.next;
        }
    }
}