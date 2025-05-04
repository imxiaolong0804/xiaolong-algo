package com.xiaolong.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: imxiaolong
 * @Date: 2025/4/8 13:12
 * @Description:
 */
public class MatrixPractice {

    @Test
    public void test1() {

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrder(matrix);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int left = 0, top = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;
        int loop = right * bottom;
        while (left < right && top < bottom) {
            // 从左到右
            for (int i = left; i < right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            // 从上到下
            for (int i = top; i < bottom; i++) {
                ans.add(matrix[i][right - 1]);
            }
            right--;
            // 从右到左
            for (int i = right - 1; i >= left; i--) {
                ans.add(matrix[bottom - 1][i]);
            }
            bottom--;
            // 从下到上
            for (int i = bottom - 1; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
