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
}
