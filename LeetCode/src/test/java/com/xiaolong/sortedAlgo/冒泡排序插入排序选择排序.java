package com.xiaolong.sortedAlgo;

import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/12/1 10:17
 * @Description:
 */
public class 冒泡排序插入排序选择排序 {


    public static int[] generatedArray(int maxSize, int maxValue) {
        int[] arr = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] array = generatedArray(10000, 100);
//        int[] array = new int[1000];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i;
//        }
        System.out.println(Arrays.toString(array));
        System.out.println("冒泡排序开始----------------------");
        long startTime = System.currentTimeMillis();
        int[] clone = array.clone();
        maopao(clone);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(clone));
        System.out.println(endTime - startTime);
        System.out.println("冒泡排序优化版开始----------------------");
        int[] clone2 = array.clone();
        startTime = System.currentTimeMillis();
        optiMaopao(clone2);
        endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(clone2));
        System.out.println(endTime - startTime);
        System.out.println("选择排序开始----------------------");
        int[] clone1 = array.clone();
        xuanzhe(clone1);
        System.out.println(Arrays.toString(clone1));
        System.out.println("插入排序-------------------------------");
        int[] clone3 = array.clone();
        startTime = System.currentTimeMillis();
        insertSort(clone3);
        endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(clone3));
        System.out.println(endTime - startTime);
    }


    public static void maopao(int[] arr) {
        int size = arr.length;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    switchArray(arr, j, j + 1);
                }
            }
        }
    }


    public static void optiMaopao(int[] arr) {
        int size = arr.length;
        for (int i = size - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    switchArray(arr, j, j + 1);
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void xuanzhe(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[temp] > arr[j]) {
                    temp = j;
                }
            }
            switchArray(arr, i, temp);
        }
    }

    public static void insertSort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) { // 只需要插入n-1次
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }


    public static void switchArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
