package class05_Btree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.GeneraticTree;
import util.TreeNode;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/29 20:04
 * @Description:
 */
public class IsBanlaceTree {

    public static void main(String[] args) {
        TreeNode treeNode = GeneraticTree.generateTree2();
//        printTree(treeNode);
        boolean isBanlanceed = process(treeNode).isBanlanceed;
        System.out.println(isBanlanceed);
    }


    public static ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }

        ReturnType infoLeft = process(root.left);
        ReturnType infoRight = process(root.right);

        int height = Math.max(infoLeft.height, infoRight.height) + 1;
        boolean isBanlance = infoLeft.isBanlanceed && infoRight.isBanlanceed &&
                (Math.abs(infoLeft.height - infoRight.height) < 2);
        return new ReturnType(isBanlance, height);
    }

    // 可视化二叉树，初始调用传入 root 和初始深度 0
    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    // 递归打印二叉树
    private static void printTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 打印右子树，深度+1
        printTree(root.right, level + 1);

        // 打印当前节点的值，并用缩进表示层次
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + root.val);
        } else {
            System.out.println(root.val);
        }

        // 打印左子树，深度+1
        printTree(root.left, level + 1);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReturnType {
        public boolean isBanlanceed;
        public int height;
    }
}
