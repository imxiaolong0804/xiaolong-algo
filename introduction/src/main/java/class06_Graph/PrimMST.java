package class06_Graph;

import util.Edge;
import util.GNode;
import util.Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/31 20:59
 * @Description:
 */
public class PrimMST {


    /**
     * 使用Prim算法计算给定图的最小生成树（Minimum Spanning Tree, MST）
     *
     * @param G 图对象，需要是连通图
     * @return 包含最小生成树中所有边的集合
     */
    public static Set<Edge> primMST(Graph G) {
        // 准备一个小根堆，将解锁的边放入小根堆中
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        // 准备一个set将加入过的点放入
        HashSet<GNode> hashSet = new HashSet<>();
        // 准备一个set用于存放边的值
        HashSet<Edge> res = new HashSet<>();

        // 这个for是为了防止非联通图的
        for (GNode node : G.nodes.values()) {
            if (!hashSet.contains(node)) {
                // 循环将node的edge加入优先队列中
                hashSet.add(node);
                priorityQueue.addAll(node.edges);
                // 再循环去得到结果
                while (!priorityQueue.isEmpty()) {
                    // 弹出weight最小的edge
                    Edge minEdge = priorityQueue.poll();
                    // 拿到最小边的to点
                    GNode toNode = minEdge.to;
                    // 判断如果to点不再set里面，说明是新的点
                    if (!hashSet.contains(toNode)) {
                        // 先结果中加入最小的边
                        res.add(minEdge);
                        // 将新的点加入set中
                        hashSet.add(toNode);
                        // 循环将新的点的边加入优先队列中
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
            break; // 这里break是在知道已经是联通图的情况下
        }
        return res;
    }

}
