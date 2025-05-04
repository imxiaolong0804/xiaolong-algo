package com.xiaolong;

import org.junit.Test;

import java.util.*;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/13 19:31
 * @Description:
 */

public class exam {


    @Test
    public void test2() {

        String str = "hhhssss";
//        System.out.println(str.substring(0, ));
//        StringBuilder stringBuilder = new StringBuilder(str);
//        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
//        System.out.println(stringBuilder.toString());
//        System.out.println();
//        System.out.println(str.substring(0, 1));

    }

    @Test
    public void test1() {
        String str = "RL?";
        int[] arr = new int[3];
        recur(arr, new StringBuilder(str), 2, 0, 3);

    }

    public static void recur(int[] arr, StringBuilder str, int k, int index,
                             int step) {
        if (step == 0) {
            arr[k] = 1;
            return;
        }
        char ch = str.charAt(index);
        if (ch == 'R' && k <= arr.length - 1) {
            recur(arr, str, k + 1, index + 1, step - 1);
        } else if (ch == 'L' && k >= 1) {
            recur(arr, str, k - 1, index + 1, step - 1);
        } else if (ch == '?') {
            if (k <= arr.length - 2) {
                recur(arr, str, k + 1, index + 1, step - 1);
            }
            if (k >= 1) {
                recur(arr, str, k - 1, index + 1, step - 1);
            }
        }
    }

    @Test
    public void test4() {

        String str = "AHHATT";
        backtracking(str, 0);
        System.out.println(count);
    }

    public void backtracking(String str, int startIndex) {
        if (startIndex == str.length()) {
            return;
        }

        for (int i = startIndex; i < str.length(); i++) {
            String sb = str.substring(startIndex, i + 1);
            if (isValid(sb)) {
                backtracking(str, i + 1);
            }
        }
    }

    public static int count = 0;

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return true;
        }
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        count++;
        return true;

    }
}
