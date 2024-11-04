package class07_暴力递归;

import java.util.PriorityQueue;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/2 13:45
 * @Description: 这也就是所谓的哈夫曼编码问题
 */
public class 分金条问题 {

    public static int findMinGold(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 往优先队列里面加入arr的值
        for (int i : arr) {
            queue.add(i);
        }
        int res = 0;
        // 再循环取出两个数，相加
        while (queue.size() > 1) {
            int f1 = queue.poll();
            int f2 = queue.poll();
            int temp = f1 + f2;
            res += temp;
            // 然后再将temp重新加回去
            queue.add(temp);
        }
        return res;
    }
}
