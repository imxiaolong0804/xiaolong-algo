package class08;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/5 10:21
 * @Description:
 */
public class 拿牌先后手求最大值问题 {

    public static int f(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        return Math.max((arr[l] + s(arr, l + 1, r)), (arr[r] + s(arr, l, r - 1)));
    }

    public static int s(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(f(arr, l + 1, r), f(arr, l, r - 1));
    }
}
