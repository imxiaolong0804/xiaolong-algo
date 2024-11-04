package util;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/24 15:33
 * @Description:
 */
public class Swap {

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
