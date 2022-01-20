package com.pwh.leetcode.linkedList;

import com.pwh.leetcode.math.ListNode;
import com.pwh.leetcode.util.ListNodeUtils;

/**
 * @author: Waver Pan
 * @date: 2022/1/20 17:15
 */
public class 合并两个有序链表 {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1), p = dummy;
            ListNode p1 = list1, p2 = list2;
            while (p1 != null && p2 != null) {
                if (p1.val > p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                } else {
                    p.next = p1;
                    p1 = p1.next;
                }
                p = p.next;
            }
            if (p1 != null) {
                p.next = p1;
            }
            if (p2 != null) {
                p.next = p2;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = ListNodeUtils.buildListNode(new int[]{1, 6, 10, 13});
        ListNode node2 = ListNodeUtils.buildListNode(new int[]{4, 8, 9, 16});
        ListNode resultNode = new 合并两个有序链表().new Solution().mergeTwoLists(node1, node2);
        ListNodeUtils.print(resultNode);
    }
}
