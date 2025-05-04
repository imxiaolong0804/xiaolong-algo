package com.xiaolong.practice;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/26 19:52
 * @Description:
 */
public class MaxArrSubArr {

    public static void main(String[] args) {
        int num1[] = {1,2,3,2,1};
        int num2[] = {3,2,1,4,7};
        findLength(num1, num2);
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1]; // 表示的是以 i - 1，j - 1结尾的最长的公共子数组
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        print(dp);
        return max;
    }

    public static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "-");
            }
            System.out.println();
        }
    }
}
