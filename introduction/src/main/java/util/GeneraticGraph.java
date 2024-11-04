package util;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/31 16:57
 * @Description:
 */
public class GeneraticGraph {

    /**
     * matrix为nx3的矩阵
     * [from节点上面的值, to节点上面的值, weight]
     * @param matrix 图的矩阵
     * @return 返回一个按照给定matrix的图
     */
    public static Graph generateGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            // 先判断图上是否已经有这个node了，没有再put进去
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new GNode(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new GNode(to));
            }
            // 现在可以从graph中拿出这个node了
            GNode fromNode = graph.nodes.get(from);
            GNode toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            // 向fromNode里面加入Edge
            fromNode.edges.add(edge);
            // 最后向图里面加入边的信息
            graph.edges.add(edge);
        }
        return graph;
    }
}
