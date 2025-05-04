package com.xiaolong.class04dp;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/14 19:46
 * @Description: 树型dp；以某一节点的的子树中，分析所有的可能性，然后再写一个返回值，最后开始写递归，递归有basecase，同样最后也要返回该返回值
 */
public class 树的最大距离 {

    public static class Node {
        public Integer val;
        public Node left;
        public Node right;

        public Node(Integer val) {
            this.val = val;
        }
    }

    public static class Info {
        public Integer maxDistance;
        public Integer maxHeight;

        public Info(Integer maxDistance, Integer maxHeight) {
            this.maxDistance = maxDistance;
            this.maxHeight = maxHeight;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info left = process(x.left);
        Info right = process(x.right);
        // 拿到黑盒的信息
        Integer leftMaxDistance = left.maxDistance;
        Integer rightMaxDistance = right.maxDistance;
        Integer leftMaxHeight = left.maxHeight;
        Integer rightMaxHeight = right.maxHeight;
        int maxDistance = Math.max(leftMaxDistance, Math.max(rightMaxDistance, leftMaxHeight + rightMaxHeight + 1));
        int maxHeight = Math.max(leftMaxHeight, rightMaxHeight) + 1;
        return new Info(maxDistance, maxHeight);
    }

}
