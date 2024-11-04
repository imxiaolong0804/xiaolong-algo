package class01;

import util.GeneraticRandomArray;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/24 14:04
 * @Description:
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] array = GeneraticRandomArray.generateRandomArray(5, 10);
        System.out.println(Arrays.toString(array));
//        int process = process(array, 0, array.length - 1);
//        System.out.println(process);


        System.out.println("求逆序对");
        System.out.println(reverseCup(array, 0, array.length - 1));
        System.out.println(Arrays.toString(array));
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R || arr == null || arr.length == 0) {
            return 0;
        }

        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid)
                + process(arr, mid + 1, R)
                + merge(arr, L, mid, R);
    }


    public static int merge(int[] arr, int L, int mid, int R) {
        if (L == R) {
            return 0;
        }
        int[] helper = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= R) {
            helper[i++] = arr[p2++];
        }
        for (i = 0; i < helper.length; i++) {
            arr[L + i] = helper[i];
        }
        return res;
    }


    public static int reverseCup(int[] arr, int L, int R) {
        if (L == R || arr == null || arr.length == 0) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return reverseCup(arr, L, mid) + reverseCup(arr, mid + 1, R)
                + merge2(arr, L, mid, R);
    }

    public static int merge2(int[] arr, int L, int mid, int R) {

        int[] helper = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int count = 0;
        int i = 0;
        while (p1 <= mid && p2 <= R) {
            count += arr[p1] > arr[p2] ? (R - p2 + 1) : 0;
            helper[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }

        while (p2 <= R) {
            helper[i++] = arr[p2++];
        }

        for (int k = 0; k < helper.length; k++) {
            arr[L + k] = helper[k];
        }
        return count;
    }
}
