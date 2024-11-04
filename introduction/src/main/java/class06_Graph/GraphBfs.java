package class06_Graph;

import util.GNode;
import util.GeneraticGraph;
import util.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/31 18:38
 * @Description:
 */
public class GraphBfs {


    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 3, 1},
                {1, 2, 1},
                {1, 4, 1},
                {2, 4, 1},
                {2, 5, 1},
                {3, 2, 1},
                {3, 5, 1},
                {4, 5, 1}
        };
        Graph graph = GeneraticGraph.generateGraph(matrix);
        graphBfs(graph.nodes.get(1));
        System.out.println("-----------------------");
        graphDfs(graph.nodes.get(1));
    }


    /**
     * 使用广度优先搜索遍历图
     *
     * @param root 图的根节点
     */
    public static void graphBfs(GNode root) {

        if (root == null) {
            return;
        }
        LinkedList<GNode> queue = new LinkedList<>();
        HashSet<GNode> hashSet = new HashSet<>();
        queue.add(root);
        hashSet.add(root);
        while (!queue.isEmpty()) {
            GNode cur = queue.poll();
            System.out.println(cur.value);
            for (GNode next : cur.nexts) {
                if (!hashSet.contains(next)) {
                    queue.add(next);
                    hashSet.add(next);
                }
            }
        }
    }

    /**
     * 使用深度优先搜索遍历图
     *
     * @param root 图的根节点
     */
    public static void graphDfs(GNode root) {
        if (root == null) {
            return;
        }
        Stack<GNode> stack = new Stack<>();
        HashSet<GNode> hashSet = new HashSet<>();
        stack.push(root);
        hashSet.add(root);
        System.out.println(root.value);
        while (!stack.isEmpty()) {
            GNode cur = stack.pop();
            for (GNode next : cur.nexts) {
                if (!hashSet.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    hashSet.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
