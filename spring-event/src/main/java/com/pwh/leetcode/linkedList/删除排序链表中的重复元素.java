package com.pwh.leetcode.linkedList;

import com.pwh.leetcode.math.ListNode;
import com.pwh.leetcode.util.ListNodeUtils;

/**
 * @author: Waver Pan
 * @date: 2022/1/20 21:23
 */
public class 删除排序链表中的重复元素 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    // nums[slow] = nums[fast];
                    slow.next = fast;
                    // slow++;
                    slow = slow.next;
                }
                // slow++;
                fast = fast.next;
            }
            // 断开与后面重复元素的连接
            slow.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.buildListNode(new int[]{1, 1, 2, 2, 3, 4, 4});
        ListNodeUtils.print(listNode);
        System.out.println("========================================================================");
        ListNode result = new 删除排序链表中的重复元素().new Solution().deleteDuplicates(listNode);
        ListNodeUtils.print(result);
    }
}
