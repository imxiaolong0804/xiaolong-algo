package com.xiaolong.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/27 21:35
 * @Description:
 */
public class Rain {

    public static void main(String[] args) {
        int[] in = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        Arrays.sort(in, (a, b) -> Integer.compare((Integer) a, (Integer) b));
        System.out.println(Arrays.toString(in));
//        trap(in);
    }

    public static int trap(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (deque.isEmpty() || height[deque.peek()] > height[i]) {
                deque.push(i);
                continue;
            }
            while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
                int curindex = deque.pop();
                if (deque.isEmpty()) {
                    break;
                } else {
                    ans += Math.min(height[i], height[deque.peek()]) - height[curindex] * (i - deque.peek() - 1);
                }
            }
            deque.push(i);
        }
        return ans;
    }

}
