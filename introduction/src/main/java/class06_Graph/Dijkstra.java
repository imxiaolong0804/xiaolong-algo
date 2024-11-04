package class06_Graph;

import util.Edge;
import util.GNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/31 22:04
 * @Description:
 */
public class Dijkstra {


    /**
     * 使用Dijkstra算法计算从指定起点到其他所有节点的最短路径长度。
     *
     * @param head 图的起点节点
     * @return 一个HashMap，键为图中的节点，值为从起点到该节点的最短路径长度
     */
    public static HashMap<GNode, Integer> dijkstra(GNode head) {

        // 首先创建一个hashmap存储数据
        HashMap<GNode, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        // 再创建一个set，将已经确定的点放入，以后再也不碰
        HashSet<GNode> selectedNode = new HashSet<>();
        GNode minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNode);

        while (minNode != null) {
            // 取出现在到该minNode的距离
            Integer distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                GNode toNode = edge.to;
                // 这里是如果这个点根本就没有加入过，那么相当于是无穷大，直接put进去
                if (!selectedNode.contains(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    // 否则就需要再与原来的值比较一下加入后的值
                    distanceMap.put(toNode, Math.max(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNode.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNode);
        }
        return distanceMap;
    }


    public static GNode getMinDistanceAndUnselectedNode(
            HashMap<GNode, Integer> distanceMap,
            HashSet<GNode> selectedNode
    ) {
        GNode minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<GNode, Integer> entry : distanceMap.entrySet()) {
            if (!selectedNode.contains(entry.getKey()) && entry.getValue() < minDistance) {
                minNode = entry.getKey();
                minDistance = entry.getValue();
            }
        }
        return minNode;
    }
}
