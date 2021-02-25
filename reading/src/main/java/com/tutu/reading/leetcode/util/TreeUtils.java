package com.tutu.reading.leetcode.util;

import com.tutu.reading.leetcode.tree.TreeNode;

/**
 * @author ：hxf
 * @date ：Created in 2020/1/19 14:36
 * @description :
 */
public class TreeUtils {

    /**
     * 根据数组按照先序创建二叉树名称
     *
     * @param array 数组对应的列表
     * @param index 每棵树的元素对应的数组的下标元素
     * @return 数组指定元素生成的数组
     */
    public static TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }
}
