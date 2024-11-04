package util;

import javax.swing.tree.TreeCellRenderer;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/29 13:59
 * @Description:
 */
public class GeneraticTree {
    /**
     * 生成一个完美二叉树
     *
     * @return 生成的二叉树的根节点
     */
    public static TreeNode generateTree() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        return treeNode;
    }

    /**
     * 生成一个不是完美也不是完全的二叉树
     *
     * @return 返回生成的二叉树的根节点
     */
    public static TreeNode generateTree2() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.right.left.left = new TreeNode(8);
        return treeNode;
    }

    /**
     * 创建一个二叉搜索树
     *
     * @return 返回构建好的树形结构的根节点
     */
    public static TreeNode searchTree() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(1);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);
        return treeNode;
    }
}
