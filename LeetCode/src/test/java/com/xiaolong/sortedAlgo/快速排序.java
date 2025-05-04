package com.xiaolong.sortedAlgo;

import static com.xiaolong.sortedAlgo.冒泡排序插入排序选择排序.maopao;

/**
 * @Author: imxiaolong
 * @Date: 2024/12/1 21:22
 * @Description:
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] array = generatedArray(50000, 100000);

        int[] clone1 = array.clone();
        long startTime = System.currentTimeMillis();
        quickSort(clone1, 0, clone1.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
//        System.out.println(Arrays.toString(clone1));
        System.out.println("--------------------------");
        startTime = System.currentTimeMillis();
        int[] clone = array.clone();
        maopao(clone);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
//        System.out.println(Arrays.toString(clone));
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int partition(int[] arr, int left, int right) {
        // 这里选择用中位数，为base
        int target = arr[left + ((right - left) >> 1)];
        int fast = left, slow = left;
        while (fast <= right) {
            if (arr[fast] < target) {
                swap(arr, fast++, slow++);
            } else if (arr[fast] > target) {
                swap(arr, fast, right--);
            } else {
                fast++;
            }
        }
        return slow;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }


    public static int[] generatedArray(int maxSize, int maxValue) {
        int[] arr = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

}
