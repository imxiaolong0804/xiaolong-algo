package class01;

import util.GeneraticRandomArray;

import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/24 15:16
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = GeneraticRandomArray.generateRandomArray(20, 10);
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int[] pivot = partition(array, left, right);
            quickSort(array, left, pivot[0] - 1);
            quickSort(array, pivot[1] + 1, right);
        }
    }


    public static int[] partition(int[] array, int left, int right) {
        int randomIndex = (int) (Math.random() * (right - left + 1)) + left;
        int target = array[randomIndex];
        swap(array, randomIndex, right);
        int lt = left, i = left, gt = right;
        while (i < gt) {
            if (array[i] < target) {
                swap(array, i++, lt++);
            } else if (array[i] > target) {
                swap(array, i, --gt);
            } else {
                i++;
            }
        }
        // 交换gt和right的值
        swap(array, gt, right);
        return new int[]{lt, gt};


    }

//    public static int partition(int[] array, int left, int right) {
//        int len = right - left + 1;
//        int targetIndex = (int) (Math.random() * len) + left;
//        int target = array[targetIndex];
//        swap(array, targetIndex, right);
//        int fast = left, slow = left;
//        int r = right - 1;
//        while (fast <= r) {
//            if (array[fast] < target) {
//                swap(array, fast++, slow++);
//            } else if (array[fast] > target) {
//                swap(array, fast, r--);
//            } else {
//                fast++;
//            }
//        }
//        swap(array, right, fast);
//        return fast;
//    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
