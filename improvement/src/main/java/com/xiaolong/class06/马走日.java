package com.xiaolong.class06;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/25 20:03
 * @Description: 马走棋盘问题
 */
public class 马走日 {
    public static void main(String[] args) {

        int x = 7;
        int y = 7;
        int step = 10;
        long startTime = System.nanoTime();
        int ways = process(x, y, step);
        long endTime = System.nanoTime();
        System.out.println("共有" + ways + "种方法" + "时间消耗为" + (endTime - startTime) + "ns");
        System.out.println("================================================================");
        System.out.println("================================================================");
        startTime = System.nanoTime();
        int dp = processDp(x, y, step);
        endTime = System.nanoTime();
        System.out.println("共有" + dp + "种方法" + "时间消耗为" + (endTime - startTime) + "ns");
    }

    /**
     * 我们这里反过来想，相当于从x，y到0，0位置
     *
     * @param x    目标点x的位置
     * @param y    目标的y的位置
     * @param step 可以走的步数
     * @return 返回方法数
     */
    public static int process(int x, int y, int step) {
        // 这里表示如果走出界的话
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        if (step == 0) {
            return (x == 0 && y == 0) ? 1 : 0;
        }
        // 马走日的8种方法
        return process(x - 1, y + 2, step - 1)
                + process(x - 1, y - 2, step - 1)
                + process(x + 1, y + 2, step - 1)
                + process(x + 1, y - 2, step - 1)
                + process(x + 2, y - 1, step - 1)
                + process(x + 2, y + 1, step - 1)
                + process(x - 2, y - 1, step - 1)
                + process(x - 2, y + 1, step - 1);
    }

    private static int processDp(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9 || step < 0) {
            return 0;
        }
        int[][][] dp = new int[9][10][step + 1];
        dp[0][0][0] = 1;
        for (int h = 1; h <= step; h++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 10; j++) {
                    dp[i][j][h] += getValue(dp, i - 1, j + 2, h - 1);
                    dp[i][j][h] += getValue(dp, i - 1, j - 2, h - 1);
                    dp[i][j][h] += getValue(dp, i - 2, j - 1, h - 1);
                    dp[i][j][h] += getValue(dp, i - 2, j + 1, h - 1);
                    dp[i][j][h] += getValue(dp, i + 2, j + 1, h - 1);
                    dp[i][j][h] += getValue(dp, i + 2, j - 1, h - 1);
                    dp[i][j][h] += getValue(dp, i + 1, j - 2, h - 1);
                    dp[i][j][h] += getValue(dp, i + 1, j + 2, h - 1);
                }
            }
        }
        return dp[x][y][step];
    }

    public static int getValue(int[][][] dp, int i, int j, int step) {
        if (i < 0 || i > 8 || j < 0 || j > 9) {
            return 0;
        }
        return dp[i][j][step];
    }
}
