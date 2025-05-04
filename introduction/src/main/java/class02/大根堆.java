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
        // 开始建堆
        for (int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }
        System.out.println(Arrays.toString(array));
        int heapSize = array.length;
        Swap.swap(array, 0, --heapSize);
        // 通过大顶堆的特性，进行数组排序
        while (heapSize > 0) {
            heapify2(array, 0, heapSize);
            Swap.swap(array, 0, --heapSize);
        }
        System.out.println(Arrays.toString(array));
    }


    public static void heapInsert(int[] arr, int index) {
        // 判断该点与其父节点的大小，若大于，则交换
        while (arr[index] > arr[(index - 1) / 2]) {
            Swap.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {

        int left = 2 * index + 1;
        while (left < heapSize) {
            // 找出左右孩子哪一个孩子大
            int largest = arr[left] > arr[left + 1] ? left : left + 1;
            // 再判断大孩子和爸爸哪个大
            largest = arr[largest] > arr[index] ? largest : index;
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

    public static void heapify2(int[] arr, int index, int heapSize) {
        // todo 这里为什么用左孩子，而不使用右孩子，因为没有右孩子不一定没有左孩子
        int left = 2 * index + 1; // 左孩子索引
        while (left < heapSize) {
            int largest;
            if (left + 1 < heapSize) {
                largest = arr[left + 1] > arr[left] ? left + 1 : left;
            } else {
                largest = left;
            }
            // 再判断它和index的大小
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                // 说明该点已经是最大的了，不需要动了
                return;
            }
            // 否则交换index与最大值
            Swap.swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }
}
