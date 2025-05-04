package com.xiaolong.class03;


import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/12 16:36
 * @Description: 讲解的时候是为了去求解一个数组中，某个元素，左边大于它并且离它最近的元素，右边大于它并且离它最近的元素
 * todo 首先维护一个栈，该栈是从下往上递减的，然后每次进入的时候，判断栈内的元素是否比它大，若比它大，则放入
 * todo 反之，则将栈顶元素弹出，弹出后的这个元素，问题所提右边值就为要放入的值，左边值就为下一个栈顶元素的值
 */
public class 单调栈 {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Stack<ArrayList<Integer>> stack = new Stack<>();

        // 维持单调栈
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek().iterator().next()] < height[i]) {
                // 需要记录的值
                ArrayList<Integer> record = stack.pop();
                int finalI = i;
                record.forEach(
                        index -> {
                            rightMax[index] = finalI;  // 右边理他最大的值就是要放入的值，我们这里存的都是index
                            if (stack.isEmpty()) {
                                leftMax[index] = -1; // 左边离他最大的值就是他栈的下一个值
                            } else {
                                leftMax[index] = stack.peek().iterator().next();
                            }
                        }
                );
            }
            if (!stack.isEmpty() && height[stack.peek().iterator().next()] == height[i]) {
                stack.peek().add(i);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                stack.push(arrayList);
            }
        }
        // 最后清空栈
        while (!stack.isEmpty()) {
            ArrayList<Integer> pop = stack.pop();
            pop.forEach(i -> {
                rightMax[i] = -1;
                if (stack.isEmpty()) {
                    leftMax[i] = -1;
                } else {
                    leftMax[i] = stack.peek().iterator().next();
                }
            });
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
    }

}
