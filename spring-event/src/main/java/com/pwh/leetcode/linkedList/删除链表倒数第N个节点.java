package com.pwh.leetcode.linkedList;

import com.pwh.leetcode.math.ListNode;
import com.pwh.leetcode.util.ListNodeUtils;

/**
 * @author: Waver Pan
 * @date: 2022/1/19 13:58
 */
public class 删除链表倒数第N个节点 {
    class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 虚拟头结点（构建新链表时的常用技巧）
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
            ListNode x = findFromEnd(dummy, n + 1);
            // 删掉倒数第 n 个节点
            x.next = x.next.next;
            return dummy.next;
        }

        // 返回链表的倒数第 k 个节点
        public ListNode findFromEnd(ListNode head, int k) {
            ListNode p1 = head;
            // p1 先走 k 步
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }
            ListNode p2 = head;
            // p1 和 p2 同时走 n - k 步
            while (p1 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            // p2 现在指向第 n - k 个节点
            return p2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.buildListNode(new int[]{2, 4, 3, 1, 4});
        ListNodeUtils.print(listNode);
        System.out.println("========================================================================");
        ListNode fromEnd = new 删除链表倒数第N个节点().new Solution().findFromEnd(listNode, 2);
        ListNodeUtils.print(fromEnd);
        System.out.println("========================================================================");
        ListNode listNode1 = new 删除链表倒数第N个节点().new Solution().removeNthFromEnd(listNode,2);
        ListNodeUtils.print(listNode1);

    }
}
