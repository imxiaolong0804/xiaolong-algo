package com.xiaolong.class04dp;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/14 20:25
 * @Description:
 */
public class Morris {

    public static class MorrisNode {
        public int val;
        public MorrisNode left;
        public MorrisNode right;

        public MorrisNode(int val) {
            this.val = val;
        }
    }

    public static MorrisNode findMostRight(MorrisNode root) {
        MorrisNode cur = root;
        if (cur.right == null) {
            return null;
        }
        while (cur.right != null) {
            if (cur.right == root) {
                return cur;
            }
            cur = cur.right;
        }
        return cur;
    }


    /**
     * 对Morris树的基本实现，简洁版
     *
     * @param root Morris树的根节点
     */
    public static void Morris(MorrisNode root) {
        if (root == null) {
            return;
        }
        MorrisNode cur = root;
        MorrisNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    // 第一次到
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // 第二次到该节点
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }


    public static void mirris(MorrisNode root) {
        if (root == null) {
            return;
        }
        MorrisNode cur = root;
        MorrisNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左孩子的情况下，找到左孩子的mostright
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (null == mostRight.right) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                // 没有左孩子的情况下
                cur = cur.right;
            }
        }
    }

    public static void mirrisPre(MorrisNode root) {
        if (root == null) {
            // 如果根节点为空，则直接返回
            return;
        }
        MorrisNode cur = root;
        MorrisNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左孩子的情况下
                // 找到左孩子的mostright
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (null == mostRight.right) {
                    // 这里表示第一次来到mostright
                    System.out.println(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    // 如果mostRight的右孩子不为空且指向当前节点，将其置为null后cur向右移动
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                // 没有左孩子的情况下
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

    public static void mirrisMid(MorrisNode root) {
        if (root == null) {
            // 如果根节点为空，则直接返回
            return;
        }
        MorrisNode cur = root;
        MorrisNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左孩子的情况下
                // 找到左孩子的mostright
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (null == mostRight.right) {
                    // 这里表示第一次来到mostright
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    // 如果mostRight的右孩子不为空且指向当前节点，将其置为null后cur向右移动
                    System.out.println(cur.val);
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                // 没有左孩子的情况下
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

    public static void mirrisAfter(MorrisNode root) {
        if (root == null) {
            // 如果根节点为空，则直接返回
            return;
        }
        MorrisNode cur = root;
        MorrisNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左孩子的情况下
                // 找到左孩子的mostright
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (null == mostRight.right) {
                    // 这里表示第一次来到mostright
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    // 如果mostRight的右孩子不为空且指向当前节点，将其置为null后cur向右移动
                    mostRight.right = null;
                    // todo 这里是再第二次遍历时候，通过反向遍历该节点左子树的右子树
                    reversePrint(cur.left);
                    cur = cur.right;
                }
            } else {
                // 没有左孩子的情况下
                cur = cur.right;
            }
        }
        reversePrint(root);
    }


    public static void reversePrint(MorrisNode root) {
        MorrisNode tail = reverse(root);
        MorrisNode cur = tail;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.right;
        }
        reverse(tail);
    }


    public static MorrisNode reverse(MorrisNode root) {
        if (root == null) {
            return null;
        }
        MorrisNode pre = null;
        MorrisNode next;
        while (root.right != null) {
            next = root.right;
            root.right = pre;
            pre = root;
            root = next;
        }
        return pre;
    }


    public static boolean isBST(MorrisNode root) {
        if (root == null) {
            return true;
        }
        MorrisNode cur = root;
        MorrisNode mostRight;
        int pre = Integer.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    // 说明是第一次到达
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    // 第二次到达
                    mostRight.right = null;
                    if (cur.val < pre) {
                        return false;
                    }
                    pre = cur.val;
                    cur = cur.right;
                }
            } else {
                // 没有左节点
                if (cur.val < pre) {
                    return false;
                }
                pre = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
}
