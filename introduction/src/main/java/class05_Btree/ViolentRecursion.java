package class05_Btree;

import lombok.AllArgsConstructor;
import util.GeneraticTree;
import util.TreeNode;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/29 20:28
 * @Description:
 */
public class ViolentRecursion {

    public static void main(String[] args) {
        TreeNode treeNode = GeneraticTree.searchTree();
        TreeNode treeNode1 = GeneraticTree.generateTree2();
        TreeNode treeNode2 = GeneraticTree.generateTree();
//        ReturnData process = process(treeNode1);
//        System.out.println(process.isBST);

        Info info = process2(treeNode2);
        boolean isFullTree = info.nodes == (1 << info.height) -1;
        System.out.println(isFullTree);

    }


    @AllArgsConstructor
    public static class ReturnData {
        public boolean isBST;
        public int max;
        public int min;
    }

    @AllArgsConstructor
    public static class Info {
        public int height;
        public int nodes;
    }


    /**
     * 递归地判断给定二叉树是否是一棵二叉搜索树，并返回二叉树的最大值和最小值
     *
     * @param x 待判断的二叉树的根节点
     * @return ReturnData对象，包含是否是二叉搜索树（isBST），最大值（max），最小值（min）
     */
    public static ReturnData process(TreeNode x) {
        if (x == null) {
            return null;
        }

        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);
        boolean isBST = true;
        int max = x.val;
        int min = x.val;
        // 算出max和min，通过比较左右子树的最大最小值来决定
        if (leftData != null) {
            max = Math.max(max, leftData.max);
            min = Math.min(min, leftData.min);
        }
        if (rightData != null) {
            max = Math.max(max, rightData.max);
            min = Math.min(min, rightData.min);
        }
        // 再根据不是搜索树的条件判断是否是搜索树
        if (leftData != null && (!leftData.isBST || leftData.max >= x.val)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || x.val >= rightData.min)) {
            isBST = false;
        }
        return new ReturnData(isBST, max, min);
    }


    /**
     * 计算给定二叉树的高度和节点总数，用于判断是否是满二叉树
     *
     * @param x 二叉树的根节点
     * @return 包含二叉树高度和节点总数的Info对象
     */
    public static Info process2(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        // 左右递归
        Info leftData = process2(x.left);
        Info rightData = process2(x.right);

        int height =Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }
}
