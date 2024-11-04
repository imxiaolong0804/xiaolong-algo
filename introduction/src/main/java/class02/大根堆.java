package class02;

import util.GeneraticRandomArray;
import util.Swap;

import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/25 21:13
 * @Description:
 */
public class 大根堆 {

    public static void main(String[] args) {
        int[] array = GeneraticRandomArray.generateRandomArray(20, 50);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }
        System.out.println(Arrays.toString(array));
        int heapSize = array.length;
        Swap.swap(array, 0, --heapSize);
        while (heapSize > 0) {
            heapify(array, 0, heapSize);
            Swap.swap(array, 0, --heapSize);
        }
        System.out.println(Arrays.toString(array));
    }


    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Swap.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {

        int left = 2 * index + 1;
        while (left < heapSize) {
            // 找出左右孩子哪一个孩子大
            int largest = arr[left] > arr[left + 1] ? left: left + 1;
            // 再判断大孩子和爸爸哪个大
            largest = arr[largest] > arr[index] ? largest: index;
            // 这里如果相等，说明大孩子也没有本身大，直接返回
            if (largest == index) {
                return;
            }
            // 否则交换
            Swap.swap(arr, index, largest);
            index = largest;
            // 最后再循环下去
            left = 2 * index + 1;
        }
    }
}
