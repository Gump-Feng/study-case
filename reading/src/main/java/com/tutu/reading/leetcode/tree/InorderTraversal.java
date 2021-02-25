package com.tutu.reading.leetcode.tree;

import com.tutu.reading.leetcode.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：hxf
 * @date ：Created in 2020/1/19 14:29
 * @description : 给定一个二叉树，返回它的中序遍历
 */
public class InorderTraversal {
    public static void main(String[] args) {
        Integer[] valArray = new Integer[]{1, null, 2, 3};
        TreeNode treeNode = TreeUtils.createBinaryTreeByArray(valArray, 0);
        List<Integer> integerList = inorderTraversal(treeNode);
    }

    private List<Integer> orderByStack(TreeNode root){
        List<Integer> numList = new ArrayList<>();
        orderByMlrAndStack(root, numList);
        return numList;
    }

    private void orderByMlrAndStack(TreeNode root, List<Integer> numList) {
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()){
            while (root != null){
                nodeStack.add(root);
                root = root.left;
            }
            root = nodeStack.pop();
            numList.add(root.val);
            root = root.right;
        }
    }


    /**
     * 递归的解法
     * @param root 总结点
     * @return 返回的排序列表
     */
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> numList = new ArrayList<>();
        orderByMlr(root, numList);
        return numList;
    }

    private static void orderByMlr(TreeNode root, List<Integer> numList) {
        if (root != null) {
            if (root.left != null) {
                orderByMlr(root.left, numList);
            }
            numList.add(root.val);
            if (root.right != null) {
                orderByMlr(root.right, numList);
            }
        }
    }


}
