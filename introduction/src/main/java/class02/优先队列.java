package class02;

import util.GeneraticRandomArray;

import java.awt.font.ImageGraphicAttribute;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/26 10:44
 * @Description:
 */
public class 优先队列 {

    public static void main(String[] args) {
//        int[] array = GeneraticRandomArray.generateRandomArray(10, 20);
//        sortAlmostSortedArray();
        int[] arr = {2, 6, 3, 12, 56, 8};
        sortAlmostSortedArray(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortAlmostSortedArray(int[] arr, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        // 这里先将前k+1个数加入到优先队列中
        for (int i = 0; i <= k && i < arr.length; i++) {
            heap.add(arr[i]);
        }
        // 然后循环弹出和加入
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = heap.poll();
            heap.add(arr[i]);
        }
        // 最后循环弹出剩余的值
        while (!heap.isEmpty()) {
            arr[index++] = heap.poll();
        }

    }
}
