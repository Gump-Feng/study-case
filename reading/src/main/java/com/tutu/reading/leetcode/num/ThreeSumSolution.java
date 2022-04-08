package com.tutu.reading.leetcode.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSumSolution {

    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) break;
            int num = nums[i];
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i + 1;
            int end = length - 1;
            while (start < end) {
                int tempSum = nums[start] + nums[end];
                if (tempSum == -num) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(num);
                    tempList.add(nums[start]);
                    tempList.add(nums[end]);
                    resultList.add(tempList);
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                } else if (tempSum < -num) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return resultList;
    }
}
