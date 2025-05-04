package com.xiaolong.字符串;

/**
 * @Author: imxiaolong
 * @Date: 2024/12/9 21:36
 * @Description:
 */
class 字符串 {
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return true;
        }
        // 感觉可以使用next数组完成
        char[] ch = s.toCharArray();
        int[] next = getNextArray(ch);
        int dupLength = ch.length - next[ch.length - 1] - 1;
        if (next[ch.length - 1] > 0 && ch.length % dupLength == 0) {
            return true;
        }
        return false;
    }

    public static int[] getNextArray(char[] arr) {
        int[] next = new int[arr.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < arr.length) {
            if (arr[i - 1] == arr[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "abac";
        System.out.println(repeatedSubstringPattern(s));
    }
}