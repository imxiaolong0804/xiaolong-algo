package class06_Graph;

import lombok.AllArgsConstructor;
import util.Edge;
import util.GNode;

import java.util.HashMap;


/**
 * @Author: imxiaolong
 * @Date: 2024/11/4 20:43
 * @Description:
 */
public class DijkstraImprove {


    public static HashMap<GNode, Integer> dijkstra2(GNode head, int size) {
        // 首先创建一个自己定义的小顶堆
        NodeHeap nodeHeap = new NodeHeap(size);
        // 然后通过黑盒方法，将head添加进去
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<GNode, Integer> res = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            GNode node = record.node;
            int distance = record.dsitance;
            for (Edge edge : node.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            res.put(node, distance);
        }
        return res;
    }

    public static class NodeHeap {
        private GNode[] nodes;
        // 存储自定义heap中节点的index
        private HashMap<GNode, Integer> heapIndexMap;
        // 存储自定义heap中节点的距离
        private HashMap<GNode, Integer> distanceMap;
        int size;

        public NodeHeap(int size) {
            nodes = new GNode[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public void addOrUpdateOrIgnore(GNode node, int distance) {
            // 这里判断如果这个节点进来过并且没有被弹出，就可以更新，否则忽略，或者没进来过加入
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distance, distanceMap.get(node)));
                // 因为肯定是越来越小，所以肯定是heapinsert往上冒泡
                insertHeapify(heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(size++);
            }
        }

        private boolean isEntered(GNode node) {
            return heapIndexMap.containsKey(node);
        }

        private void insertHeapify(Integer index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(Integer p1, Integer p2) {
            // 首先交换两个index的值
            heapIndexMap.put(nodes[p1], p2);
            heapIndexMap.put(nodes[p2], p1);
            // 然后交换两个节点
            GNode temp = nodes[p1];
            nodes[p1] = nodes[p2];
            nodes[p2] = temp;
        }

        public NodeRecord pop() {
            NodeRecord record = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            // 交换堆顶元素和最后一个元素
            swap(0, size - 1);
            // 删除最后一个元素也就是改为-1
            heapIndexMap.put(nodes[size - 1], -1);
            nodes[size - 1] = null;
            // 最后将size--，然后heapify
            heapify(0, --size);
            return record;
        }

        private void heapify(int p1, int heapSize) {

            int left = p1 * 2 + 1;
            while (left < heapSize) { // 如果左子节点大于堆的大小，说明没有左子节点，直接break
                // 首先判断左右节点哪个小
                int smallest = left + 1 < heapSize && distanceMap.get(left) < distanceMap.get(left + 1) ? left : left + 1;
                // 然后再判断跟父亲比谁小
                smallest = distanceMap.get(smallest) < distanceMap.get(p1) ? smallest : p1;
                // 如果父亲小，说明不用交换，直接break，也就是父亲最小，还交换个毛线啊
                if (smallest == p1) {
                    break;
                }
                swap(smallest, p1);
                p1 = smallest;
                left = p1 * 2 + 1;
            }
        }


        public boolean isEmpty() {
            return size == 0;
        }

        public boolean inHeap(GNode node) {
            return heapIndexMap.containsKey(node) && heapIndexMap.get(node) != -1;
        }
    }


    @AllArgsConstructor
    public static class NodeRecord {
        public GNode node;
        public int dsitance;
    }
}
