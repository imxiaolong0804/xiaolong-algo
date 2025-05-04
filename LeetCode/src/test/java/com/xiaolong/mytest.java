package com.xiaolong;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/12/24 20:58
 * @Description:
 */
public class mytest {


    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        setZeroes(matrix);

    }

    public static void setZeroes(int[][] matrix) {
        // 尝试使用暴力解法，双层for
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int l = 0; l < matrix.length; l++) {
                        matrix[l][j] = 0;
                    }
                }
            }
        }
    }

    @Test
    public void test1() {
//
//        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 10);
//        }
        int[] arr = new int[]{7, 6, 5, 10, 1, 0};
        Arrays.stream(arr).forEach(
                item -> System.out.print(item + " ")
        );
        System.out.println();
        mydp(arr);
//        Arrays.stream(arr).forEach(
//                (item) -> {
//                    System.out.print(item + " ");
//                }
//        );

    }


    public static void chooseSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void bubboSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int base = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > base) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = base;
        }
    }

    public static void mydp(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        System.out.println(max);
    }

}
