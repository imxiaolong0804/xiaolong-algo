package com.xiaolong.class03;

import org.junit.jupiter.api.Test;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/11 15:12
 * @Description: 求解字符串str中，最长回文子串的长度 P12-开始讲解的
 * todo 回文子串就是  abba 或者 abcba 这种
 * 四个概念：
 * 1、回文直径
 * 2、回文半径 todo 回文半径数组
 * 3、遍历的时候能够取得的最右边界 R
 * 4、取得最右边界的时候的中心 C
 * <p>
 * <p>
 * 总共有两大类情况：
 * 1、该点在回文半径外的，暴力扩
 * 2、该点在回文半径内，分三种小情况
 * 2.1. 该点的对称点的回文半径在大的回文半径内，直接返回对称点的回文半径
 * 2.2. 该点的对称点的回文半径大于大的回文半径，直接返回该点到右边边界的距离
 * 2.3. 该点的对称点的回文半径刚好压在了最大回文半径的左边界上面，那么可以在第二情况下往外扩
 */
public class Manacher {

    public static char[] manacherString(String s) {
        char[] charArray = s.toCharArray();
        char[] result = new char[charArray.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = (i & 1) == 0 ? '#' : charArray[index++];
        }
        return result;
    }


    public static int maxLcpsLenth(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = manacherString(s); // 1221 --- #1#2#2#1#
        int[] pAttr = new int[chars.length]; // 回文半径数组
        int R = -1; // 回文半径 回文右边界还要往右的位置
        int C = -1; // 该回文半径对应的中心点
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < chars.length; i++) {

            // 算出每一种情况最小的不用计算的
            pAttr[i] = R > i ? Math.min(pAttr[2 * C - i], R - i) : 1;

            while (i + pAttr[i] < chars.length && i - pAttr[i] > -1) {
                if (chars[i + pAttr[i]] == chars[i - pAttr[i]]) {
                    pAttr[i]++;
                } else {
                    break;
                }
            }

            // 最后更新R 和 C
            if (i + pAttr[i] > R) {
                R = i + pAttr[i];
                C = i;
            }
            max = Math.max(max, pAttr[i]);
        }
        return max - 1;
    }


    @Test
    public void testManacherAlgorithm() {
        String[] testCases = {"abcdsfdsf", "abba", "abcba", "dfd", "a", ""};
        int[] expected = {1, 4, 5, 3, 1, 0};

        for (int i = 0; i < testCases.length; i++) {
            int result = maxLcpsLenth(testCases[i]);
            System.out.println("Test case \"" + testCases[i] + "\": Expected = " + expected[i] + ", Got = " + result);
            assert result == expected[i] : "Failed for input: " + testCases[i];
        }
    }

}
