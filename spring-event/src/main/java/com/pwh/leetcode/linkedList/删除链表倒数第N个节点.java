package com.pwh.leetcode.linkedList;

import com.pwh.leetcode.math.ListNode;

/**
 * @author: Waver Pan
 * @date: 2022/1/19 13:58
 */
public class 删除链表倒数第N个节点 {
    class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 虚拟头结点（构建新链表时的常用技巧）
            ListNode dummy = new ListNode(-1);
            int size = 0;
            for (ListNode node = head;node!=null;node = node.next,size++){

            }
            int i = 1;
            int offset = size -n;
            for (ListNode node = head;node!=null;node = node.next,i++){
                if (i == offset){
                    continue;
                }
            }


//            for (ListNode l = head; l!=null; l=l.next){
//                System.out.println(l.val);
//            }

        }
    }
}
