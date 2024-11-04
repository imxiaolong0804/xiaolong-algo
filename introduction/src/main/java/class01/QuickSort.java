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
        int[] array = GeneraticRandomArray.generateRandomArray(10, 10);
        System.out.println(Arrays.toString(array));
        quickSort(array, 3);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] arr, int num) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            if (arr[l] <= num) {
                l++;
            } else {
                swap(arr, l, r);
                r--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
