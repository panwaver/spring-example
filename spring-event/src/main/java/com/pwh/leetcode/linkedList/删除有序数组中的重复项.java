package com.pwh.leetcode.linkedList;

import java.util.Arrays;

/**
 * @author: Waver Pan
 * @date: 2022/1/21 11:14
 */
public class 删除有序数组中的重复项 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[slow] != nums[fast]) {
                    slow++;
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 5, 6, 6};
        int i = new 删除有序数组中的重复项().new Solution().removeDuplicates(arr);
        System.out.println(i);
        Arrays.stream(arr).forEach(s -> System.out.print(s + ","));
    }
}
