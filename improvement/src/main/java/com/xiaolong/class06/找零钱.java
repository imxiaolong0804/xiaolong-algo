package com.xiaolong.class06;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/25 22:23
 * @Description:
 */
public class 找零钱 {


    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
            ways += process(arr, index + 1, rest - zhang * arr[index]);
        }
        return ways;
    }


    public static int dp(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        dp[n][0] = 1;
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
                    ways += dp[index + 1][rest - arr[index] * zhang];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }
}
