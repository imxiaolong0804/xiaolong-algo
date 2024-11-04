package class05_Btree;

import util.GeneraticTree;
import util.TreeNode;

import java.util.LinkedList;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/30 14:48
 * @Description:
 */
public class Serialization {
    public static void main(String[] args) {
        TreeNode beautifulTree = GeneraticTree.generateTree();
        String serialization = serialByPre(beautifulTree);
        System.out.println(serialization);
    }



    /**
     * 序列化二叉树为字符串表示形式
     *
     * @param root 二叉树的根节点
     * @return 序列化后的字符串表示形式，若根节点为空则返回null
     */
    public static String serialByPre(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res = root.val + "_";
        res += serialByPre(root.left);
        res += serialByPre(root.right);
        return res;
    }


    public static TreeNode reconByPreString(String preString) {
        String[] s = preString.split("_");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < s.length; i++) {
            queue.add(s[i]);
        }
        return reconPreOrder(queue);
    }

    private static TreeNode reconPreOrder(LinkedList<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) {
            return null;
        }

        TreeNode head = new TreeNode(Integer.parseInt(s));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
