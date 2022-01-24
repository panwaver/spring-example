package com.pwh.leetcode.linkedList;

import com.pwh.leetcode.math.ListNode;
import com.pwh.leetcode.util.ListNodeUtils;

/**
 * @author: Waver Pan
 * @date: 2022/1/20 21:23
 */
public class 删除排序链表中的重复元素 {

    class Solution {
        //双指针技巧
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null){
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    // nums[slow] = nums[fast];
                    slow.next = fast;
                    // slow++;
                    slow = slow.next;
                }
                // fast++;
                fast = fast.next;
            }
            // 断开与后面重复元素的连接
            slow.next = null;
            return head;
        }
        //方法二 一次遍历
        public ListNode deleteDuplicates1(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode cur = head;
            while (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
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
