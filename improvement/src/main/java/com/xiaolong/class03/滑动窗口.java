package com.xiaolong.class03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/12 15:37
 * @Description: 也就是单调队列问题 这里写的是单调递增的逻辑  p12 1:44左右
 * todo 在右边添加元素的时候，如果发现队列中最右边的元素大于要添加的元素，直接添加，否则一直弹出直到空或者大于添加元素
 * todo 在左边缩小窗口的时候，判断队列中最左边的元素是否等于缩小后丢失的元素，若是，则弹出，否则不管
 */
public class 滑动窗口 {


    public static void window(int[] arr) {
        LinkedList<Integer> queue = new LinkedList<>();
        int l = -1;
        int r = -1;
        int[] res = new int[arr.length - 3 + 1];
        int i = 0;
        while (i < 3) {

        }

    }

    public static void rMove(int index, LinkedList<Integer> queue, int[] arr) {
        if (queue.isEmpty()) {
            queue.addLast(index);
        } else {
            if (arr[queue.peekLast()] > arr[index]) {
                queue.addLast(index);
            } else {
                while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[index]) {
                    queue.removeLast();
                }
                queue.addLast(index);
            }
        }
    }

    public static void lMove(int index, LinkedList<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        if (index == queue.peekFirst()) {
            queue.removeFirst();
        }
    }

    @Test
    public void test_forqueue() {

        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = new int[arr.length - 3 + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            rMove(i, queue, arr);
        }
        int rIndex = 2;
        int lIndex = -1;
        res[0] = arr[queue.peekFirst()];
        // 这里开始计算
        for (int i = 1; i < res.length; i++) {
            rMove(++rIndex, queue, arr);
            lMove(++lIndex, queue);
            res[i] = arr[queue.getFirst()];
        }
        Arrays.stream(res).forEach(System.out::println);
    }
}
