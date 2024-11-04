package class00;

import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/22 21:46
 * @Description:
 */
public class Odd {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 9, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4};
        int[] arr2 = new int[]{9, 9, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4};
//        oddNum1(arr);
        oddNum2(arr);

        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        SelcetSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }


    public static void oddNum1(int[] arr) {

        int eor = 0;
        for (int a : arr) {
            eor ^= a;
        }
        System.out.println(eor);
    }

    public static void oddNum2(int[] arr) {
        int eor = 0;
        for (int a : arr) {
            eor ^= a;
        }
        // eor = a ^ b
        int rightone = eor & (~eor + 1);
        int onlyOne = 0;

        for (int a : arr) {
            if ((rightone & a) == 0) {
                onlyOne ^= a;
            }
        }
        System.out.println("one is " + onlyOne);
        System.out.println("two is " + (eor ^ onlyOne));

    }

    public static void BubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > (arr[j + 1])) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    public static void SelcetSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > (arr[j + 1]); j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
