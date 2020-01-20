package com.ertu.leetcode.tree;


import com.ertu.leetcode.tree.TreeNode;
import com.ertu.leetcode.util.TreeUtils;

import java.util.LinkedList;

/**
 * @author ：hxf
 * @date ：Created in 2020/1/19 11:29
 * @description : 给定一个二叉树，检查是否是镜像对称
 */
public class SymmetricDemo {

    public static void main(String[] args) {
        Integer[] valArray = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        Integer[] val1Array = new Integer[]{1,null,2,3};
        TreeNode root = TreeUtils.createBinaryTreeByArray(val1Array, 0);
        if (root == null || isSymmetric(root)) {
            System.out.println("valArray数组对应的二叉树镜像对称");
        }
    }

    private static boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode treeNode1 = queue.poll();
            TreeNode treeNode2 = queue.poll();
            if (treeNode1 == null && treeNode2 == null){
                continue;
            }
            if (treeNode1 == null || treeNode2 == null){
                return false;
            }
            if (treeNode1.val != treeNode2.val){
                return false;
            }
            queue.add(treeNode1.left);
            queue.add(treeNode2.right);
            queue.add(treeNode1.right);
            queue.add(treeNode2.left);
        }
        return true;
//        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        //首先判断是否为空
        //若俩树都为空，则肯定堆成
        if (t1 == null && t2 == null) {
            return true;
        }
        //通过上层判断，若俩个树只有一个为null，则不对称
        if (t1 == null || t2 == null) {
            return false;
        }
        //俩都不为空，从左到右进行分别判断
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

}
