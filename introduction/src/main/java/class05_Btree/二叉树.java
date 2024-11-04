package class05_Btree;

import util.GeneraticTree;
import util.TreeNode;

import java.util.*;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/29 13:55
 * @Description:
 */
public class 二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode = GeneraticTree.generateTree();
        TreeNode treeNode1 = GeneraticTree.generateTree2();
        TreeNode treeNode2 = GeneraticTree.searchTree();
//        inOrderRecur(treeNode2);
//        ArrayList<Object> list = new ArrayList<>();
//        list.get(0);
        boolean cbt = isCBT(treeNode);
        System.out.println(cbt);
        boolean cbt1 = isCBT(treeNode1);
        System.out.println(cbt1);


//        inOrderUnRecur(treeNode2);
//        preOrderUnRecur(treeNode);
//        preOrderRecur(treeNode);
//        posOrederUnRecur(treeNode);
//        inOrderUnRecur(treeNode);
//        layerOrderUnRecur(treeNode);
//        int maxWidth = findMaxWidth(treeNode1);
//        System.out.println("maxWidth = " + maxWidth);

    }


    public static void preOrderUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        boolean flag = false;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (flag) {
                System.out.print("->");
            }
            System.out.print(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            flag = true;
        }
    }

    public static void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }


    public static void posOrederUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> collectStack = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        // 这里通过中右左的方式将数据放入收集栈中
        while (!stack.isEmpty()) {
            cur = stack.pop();
            collectStack.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        // 这里再一个一个出栈，因为是先进后出，所以也就变为了左右中，成为了后序遍历
        boolean flag = false;
        while (!collectStack.isEmpty()) {
            if (flag) {
                System.out.print("==>");
            }
            System.out.print(collectStack.pop().val);
            flag = true;
        }
    }

    public static void inOrderUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public static void inOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.println(root.val);
        inOrderRecur(root.right);
    }


    public static void layerOrderUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    /**
     * 查找给定二叉树的最大宽度。
     *
     * @param root 给定的二叉树的根节点
     * @return 给定二叉树的最大宽度
     */
    public static int findMaxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curLevel = 1;
        int curLevelNodes = 0;
        int curNodeLevel = 0;
        int max = Integer.MIN_VALUE;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curNodeLevel = map.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                curLevel++;
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 1;
            }
            if (cur.left != null) {
                queue.add(cur.left);
                map.put(cur.left, curNodeLevel + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                map.put(cur.right, curNodeLevel + 1);
            }
//            max = Math.max(max, curLevelNodes);
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static long pre = Long.MIN_VALUE;

    /**
     * 判断给定的二叉树是否是二叉搜索树
     *
     * @param root 二叉树的根节点
     * @return 如果是二叉搜索树则返回true，否则返回false
     */
    public static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBST(root.left) || root.val <= pre) {
            return false;
        } else {
            pre = root.val;
        }
        return isBST(root.right);
    }


    /**
     * 判断给定的二叉树是否是完全二叉树
     *
     * @param root 二叉树的根节点
     * @return 如果是完全二叉树则返回true，否则返回false
     */
    public static boolean isCBT(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        queue.add(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (
                    (cur.left == null && cur.right != null) || (leaf && (cur.left != null || cur.right != null))
            ) {
                return false;
            }

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (cur.left == null || cur.right == null) {
                leaf = true;
            }
        }
        return true;
    }
}
