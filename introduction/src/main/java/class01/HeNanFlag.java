package class01;

import util.GeneraticRandomArray;
import util.Swap;

import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/24 15:30
 * @Description:
 */
public class HeNanFlag {

    public static void main(String[] args) {
        int[] array = GeneraticRandomArray.generateRandomArray(10, 10);
//        int[] array = new int[]{1, 4, 0, 0, 1, -5};
        System.out.println(Arrays.toString(array));
        threeProcess(array, 3);
        System.out.println(Arrays.toString(array));

    }

    public static void threeProcess(int[] arr, int num) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int slow = 0, fast = 0;
        int right = arr.length - 1;
        while (fast <= right) {
            if (arr[fast] < num) {
                Swap.swap(arr, fast++, slow++);
            } else if (arr[fast] > num) {
                Swap.swap(arr, fast, right--);
            } else if (arr[fast] == num) {
                fast++;
            }
        }
    }
}
