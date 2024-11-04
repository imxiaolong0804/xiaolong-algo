package class07_暴力递归;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/2 14:02
 * @Description:
 */
public class 做最多项目的利润最大 {

    @AllArgsConstructor
    public static class CPNode {
        public int c;
        public int p;
    }


    public static int findMaxProfit(int m, int k, int[] costs, int[] profits) {
        // 首先创建一个大根堆和一个小根堆
        PriorityQueue<CPNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
        PriorityQueue<CPNode> maxHeap = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);
        // 首先将所有的数据放入小根堆中
        for (int i = 0; i < profits.length; i++) {
            minHeap.add(new CPNode(costs[i], profits[i]));
        }
        int profit = m;
        // 循环最多做k个项目
        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().c <= profit) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.isEmpty()) {
                return profit;
            }
            profit += maxHeap.poll().p;
        }
        return profit;
    }
}
