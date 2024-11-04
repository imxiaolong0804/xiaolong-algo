package class06_Graph;

import util.GNode;
import util.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/31 19:30
 * @Description:
 */
public class TopologicalSorting {



    /**
     * 对有向无环图进行拓扑排序
     *
     * @param graph 图对象
     * @return 拓扑排序的结果，即图中的节点顺序列表
     */
    public static List<GNode> topologicalSort(Graph graph) {

        // key为某一个节点，value为该节点的in数目
        HashMap<GNode, Integer> nodeHashMap = new HashMap<>();
        // 0度的点
        LinkedList<GNode> zeroNode = new LinkedList<>();
        // 循环将每一个点的度都放入map中，同时将0度的点放入zeroNode中
        for (GNode node : graph.nodes.values()) {
            nodeHashMap.put(node, node.in);
            if (node.in == 0) {
                zeroNode.add(node);
            }
        }
        List<GNode> res = new ArrayList<>();
        // 循环弹出zeroNode中的值
        while (!zeroNode.isEmpty()) {
            GNode cur = zeroNode.poll();
            res.add(cur);
            for (GNode next : cur.nexts) {
                // 对于每一个cur的next点，都将其的in值减一
                nodeHashMap.put(next, nodeHashMap.get(next)  - 1);
                if (nodeHashMap.get(next) == 0) {
                    zeroNode.add(next);
                }
            }
        }
        return res;
    }
}
