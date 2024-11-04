package class05_Btree;

import util.GeneraticTree;
import util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/30 13:04
 * @Description:
 */
public class HasSameNode {

    public static void main(String[] args) {
        TreeNode treeNode = GeneraticTree.generateTree2();
        TreeNode o1 = treeNode.right.right;
        TreeNode o2 = treeNode.right.left.left;
//        TreeNode o2 = treeNode.left.right;
        TreeNode lca = lca(treeNode, o1, o2);
        TreeNode lowsetAncestor = lowsetAncestor(treeNode, o1, o2);
        System.out.println(lowsetAncestor.val);
        System.out.println(lca.val);

    }

    /**
     * 寻找二叉树中两个节点的最低公共祖先节点
     *
     * @param head 二叉树的根节点
     * @param o1 需要查找最低公共祖先的第一个节点
     * @param o2 需要查找最低公共祖先的第二个节点
     * @return 两个节点的最低公共祖先节点，如果o1或o2不在树中，则返回null
     */
    public static TreeNode lowsetAncestor(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }

        TreeNode left = lowsetAncestor(head.left, o1, o2);
        TreeNode right = lowsetAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }


    /**
     * 寻找两个节点的最近公共祖先节点
     *
     * @param head 二叉树的根节点
     * @param o1   需要查找最近公共祖先的第一个节点
     * @param o2   需要查找最近公共祖先的第二个节点
     * @return 返回两个节点的最近公共祖先节点，如果o1和o2中任一节点不存在于树中，则返回null
     */
    public static TreeNode lca(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null) {
            return null;
        }

        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap); // 这里将所有节点的father节点都放入map中
        // 然后再将o1的父节点放入一个set中
        HashSet<TreeNode> o1Set = new HashSet<>();
        while (o1 != fatherMap.get(o1)) {
            o1Set.add(o1);
            o1 = fatherMap.get(o1);
        }
        // 这里再通过o2向上走来的时候判断是否在o1set中有相同的值，如果有相同的值，那么就是该点为相同点
        while (o2 != fatherMap.get(o2) && !o1Set.contains(o2)) {
            o2 = fatherMap.get(o2);
        }
        return o2;
    }


    /**
     * 将给定二叉树的每个节点的父节点记录到给定的HashMap中
     *
     * @param head      二叉树的根节点
     * @param fatherMap 用于存储节点及其父节点的HashMap
     */
    public static void process(TreeNode head, HashMap<TreeNode, TreeNode> fatherMap) {
        if (head == null) {
            return;
        }
        // 这里判断一下是否为空再加入fathermap里面
        if (head.left != null) {
            fatherMap.put(head.left, head);
        }
        if (head.right != null) {
            fatherMap.put(head.right, head);
        }
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

}
