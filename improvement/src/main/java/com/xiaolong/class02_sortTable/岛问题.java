package com.xiaolong.class02_sortTable;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/10 14:18
 * @Description:
 */
public class 岛问题 {

    @Test
    public void test_islands() {
        int[][] grid = new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(countIslands(grid));
        System.out.println(Arrays.deepToString(grid));
    }


    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    infect(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private static void infect(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        infect(grid, i - 1, j, m, n);
        infect(grid, i + 1, j, m, n);
        infect(grid, i, j - 1, m, n);
        infect(grid, i, j + 1, m, n);
    }
}
