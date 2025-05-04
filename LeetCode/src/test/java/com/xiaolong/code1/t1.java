package com.xiaolong.code1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/29 22:30
 * @Description:
 */
public class t1 {

    public static void sortedSquares(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        Integer[] array = list.stream().map(item -> (int)Math.pow(item, 2)).toArray(Integer[]::new);
        for (Integer i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{-4, -1, 0, 3, 4};

        sortedSquares(array);
    }


}
