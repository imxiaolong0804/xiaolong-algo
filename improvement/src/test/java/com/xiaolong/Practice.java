package com.xiaolong;

import org.junit.Test;

import java.util.*;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/21 18:09
 * @Description:
 */
public class Practice {
    public static void main(String[] args) {
        int n = 255678;
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(9);
        arr.add(3);
        arr.sort((a, b) -> b - a);

        StringBuilder nstr = new StringBuilder(Integer.toString(n));
        int multi = 0;
        boolean flag = false;
        for (int i = 0; i < nstr.length(); i++) {
            char c = nstr.charAt(i);
            int cur = c - '0';
            if (flag) {
                multi = multi * 10 + arr.get(0);
            } else {
                int num = arr.stream()
                        .filter(item -> item <= cur)
                        .findFirst()
                        .orElse(-1);
                if (num == -1) {
                    System.out.println("-1");
                    return;
                }
                multi = multi * 10 + num;
                if (num != cur) {
                    flag = true;
                }
            }
        }
        System.out.println(multi);
    }

    @Test
    public void test1() {
        int i = 3;
        double half = i / 2.0;
        System.out.println(half);
    }

    @Test
    public void test2() {
        int[] arr = new int[] {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] used = new int[arr.length];
//        bactracking1(arr, used, path, res);
        backtracking2(arr, 0, path, res);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }


    public void bactracking1(int[] arr, int[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                path.add(arr[i]);
                bactracking1(arr, used, path, res);
                path.remove(path.size() - 1);
                used[i] = 0;
            }
        }
    }

    public void backtracking2(int[] arr, int startIndex, List<Integer> path, List<List<Integer>> res) {
        if (startIndex == arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            path.add(arr[i]);
            backtracking2(arr, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
