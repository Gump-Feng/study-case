package com.tutu.reading.leetcode.num;



import java.util.HashMap;
import java.util.Map;

/**
 * @author ：hxf
 * @date ：Created in 2019/11/18 15:26
 * @description : leetcode中数字相关的解答
 */
public class NumAlgorithm {

    public static void main(String[] args) {
        int[] result = twoSum2(new int[]{1, 7, 3, 8, 9}, 10);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    /*
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    /**
     * 解法1
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    private static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (num1 + num2 == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 解法2
     * 时间复杂度：O(n)
     * 我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1)O(1) 的时间。
     * 空间复杂度：O(n)
     * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 nn 个元素。
     */
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int num2 = target - nums[i];
            if (resultMap.containsKey(num2)) {
                return new int[]{i, resultMap.get(num2)};
            }
            resultMap.put(num, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /*
      给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
      如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
      您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
      示例：

      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
      输出：7 -> 0 -> 8
      原因：342 + 465 = 807
     */

    /**
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
