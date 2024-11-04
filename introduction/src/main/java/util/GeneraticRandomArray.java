package util;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/23 9:33
 * @Description:
 */
public class GeneraticRandomArray {

    /**
     * 生成一个指定大小范围内且元素值在指定范围内的随机整数数组
     *
     * @param maxLenth 数组的最大长度
     * @param maxvalue 数组元素的最大值
     * @return 随机整数数组
     */
    public static int[] generateRandomArray(int maxLenth, int maxvalue) {

        // 0-100随机整数
        int l = (int) ((maxLenth + 1) * Math.random());
        int[] arr = new int[l];

        // 随机在maxvalue内随机赋值
        for (int i = 0; i < l; i++) {
            arr[i] = (int) ((maxvalue + 1) * Math.random()) - (int) ((maxvalue) * Math.random());
        }
        return arr;
    }
}
