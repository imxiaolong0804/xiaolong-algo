package class00;

import util.GeneraticRandomArray;

import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/23 22:38
 * @Description:
 */
public class GuiBinSort {

    public static void main(String[] args) {
        int[] array = GeneraticRandomArray.generateRandomArray(10, 50);
        guiBin(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }


    public static void guiBin(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        guiBin(arr, l, mid);
        guiBin(arr, mid + 1, r);
        merge(arr, l, r, mid);
    }

    private static void merge(int[] arr, int l, int r, int m) {

        int[] helper = new int[r - l + 1];
        int i = 0;
        int p1 = l; // 左边部分的起始位置
        int p2 = m + 1; // 右边部分的起始位置
        while (p1 <= m && p2 <= r) {
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= r) {
            helper[i++] = arr[p2++];
        }
        System.arraycopy(helper, 0, arr, l, helper.length);
    }
}
