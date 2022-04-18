package com.tutu.reading.leetcode.num;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 排序后遍历数组，固定第一个值，根据双指针方式遍历剩下的元素
 * 三个数相加的可能性有两种，一种是三数相加等于target、另一种是三个数相加无限接近于target，此种方式可用求取三数和的绝对值的方式获取到最接近target的值
 */
public class ThreeSumClosestSolution {

    public static void main(String[] args) {
        
    }

    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int length = nums.length;
        Arrays.sort(nums);
        int closest = 0;
        for (int i = 0; i < length; i++) {
            int first = nums[i];
            int temp = -(target - first);
            int slow = i + 1;
            int fast = length - 1;
            int closestTemp = 0;
            while (slow < fast) {
                int sum = nums[slow] + nums[fast];
                if (sum == temp) return target;
                if (sum - temp < 0) {
                    fast--;
                }
                if (sum - temp > 0) {
                    slow++;
                }
                closestTemp = Math.min(Math.abs(closestTemp - temp), Math.abs(sum - temp));
            }
//            closestTemp = Math.min(Math.abs(closest - target), );
        }

        return result;
    }
}
