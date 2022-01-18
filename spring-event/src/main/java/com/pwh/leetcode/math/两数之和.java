package com.pwh.leetcode.math;

import java.util.HashMap;

/**
 * @author: Waver Pan
 * @date: 2022/1/18 15:12
 */
public class 两数之和 {
    class Solution {
        //直接解法
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{i, j};
                    }
                }
            }
            //不存在
            return new int[]{-1, -1};
        }

        //哈希表
        public int[] twoSumUseHash(int[] nums, int target) {
            int length = nums.length;
            HashMap<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < length; i++) {
                index.put(nums[i], i);
            }
            for (int i = 0; i < length; i++) {
                int other = target - nums[i];
                if (index.containsKey(other) && index.get(other) != i) {
                    return new int[]{i, index.get(other)};
                }
            }
            //不存在
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        int[] ints = new 两数之和().new Solution().twoSum(new int[]{1, 2, 3, 4, 5, 6}, 4);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println("===================================");
        int[] ints1 = new 两数之和().new Solution().twoSumUseHash(new int[]{1, 2, 3, 4, 5, 6}, 4);
        for (int i = 0; i < ints1.length; i++) {
            System.out.println(ints1[i]);
        }
    }
}
