package com.xiaolong.class06;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/25 21:44
 * @Description:
 */
public class BobDie {


    public static int process(int n, int m, int row, int col, int rest) {
        // 越界，die
        if (row < 0 || row == n || col < 0 || col == m) {
            return 0;
        }
        // 如果走完了，并且没有越界，返回1
        if (rest == 0) {
            return 1;
        }
        // 递归往4个反向走
        int live = process(n, m, row, col + 1, rest - 1);
        live += process(n, m, row, col - 1, rest - 1);
        live += process(n, m, row - 1, col, rest + 1);
        live += process(n, m, row + 1, col, rest + 1);
        return live;
    }
}
