package com.xiaolong.class02_sortTable;

import org.junit.Test;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/10 15:56
 * @Description: 求解一个字符串在另外一个字符串中的位置
 * 对于主函数：
 * 1、如果对应元素都相等，那么两个指针都++
 * 2、如果不相等了，判断p2是否在0位置，如果在0位置，那么p1++
 * 3、如果不相等同时，p2不再0位置，那么p2跳到next数组值对应的位置上去
 * 对于next函数：
 * 1、如果i-1位置上的值和next【i-1】位置上的值相等，直接i位置的值为i-1位置上的值加一
 * 2、判断cn能否跳转，就判断cn是否大于0，大于0，cn = next【cn】进行跳转
 * 3、如果不能跳转，那么该点值为0
 */
public class KMP {


    public static int customKmp(String str, String patter) {
        if (str == null || patter == null || str.length() < patter.length() || patter.isEmpty()) {
            return -1;
        }

        char[] ch1 = str.toCharArray();
        char[] ch2 = patter.toCharArray();
        // 开始计算next 数组
        int[] next = getNext(ch2);
        int p1 = 0, p2 = 0;
        while (p1 < ch1.length && p2 < ch2.length) {
            if (ch1[p1] == ch2[p2]) {
                p1++;
                p2++;
            } else if (p2 == 0) {
                p1++;
            } else {
                p2 = next[p2];
            }
        }
        return p2 == ch2.length ? p1 - p2 : -1;
    }


    public static int[] getNext(char[] ch) {
        if (ch.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[ch.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0; // 表示什么位置的值与 i - 1位置的值相比
        while (i < ch.length) {
            if (ch[i] == ch[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }


//    public static int kmp(String str, String pattern) {
//        if (str == null || pattern == null || str.length() < pattern.length() || pattern.isEmpty()) {
//            return -1;
//        }
//        char[] str1 = str.toCharArray();
//        char[] str2 = pattern.toCharArray();
//        int[] nextArray = getNextArray(str2);
//
//        int i1 = 0, i2 = 0;
//        while (i1 < str1.length && i2 < str2.length) {
//            if (str1[i1] == str2[i2]) {
//                i1++;
//                i2++;
//            } else if (nextArray[i2] == -1) {
//                i1++;
//            } else {
//                i2 = nextArray[i2];
//            }
//        }
//        return i2 == str2.length ? i1 - i2 : -1;
//    }
//
//
//    public static int[] getNextArray(char[] str) {
//        if (str.length == 1) {
//            return new int[] {-1};
//        }
//        // 创建一个返回值
//        int[] nextArray = new int[str.length];
//        nextArray[0] = -1;
//        nextArray[1] = 0;
//        int i = 2;
//        int cur = 0;
//        while (i < str.length) {
//            if (str[i - 1] == str[cur]) {
//                nextArray[i++] = ++cur;
//            } else if (cur > 0) {
//                cur = nextArray[cur];
//            } else {
//                nextArray[i++] = 0;
//            }
//        }
//        return nextArray;
//    }

    // todo repete 2
//    public static int KMP(String str, String pattern) {
//        if (str == null || pattern == null || str.length() < pattern.length() || pattern.isEmpty()) {
//            return 0;
//        }
//        // 将字符串转换为数组
//        char[] str1 = str.toCharArray();
//        char[] str2 = pattern.toCharArray();
//        int[] nextArray = getNextArray(str2);
//        int p1 = 0; // str1的指针 也叫下表
//        int p2 = 0; // str2的指针
//        while (p1 < str1.length && p2 < str2.length) {
//            if (str1[p1] == str2[p2]) {
//                p1++;
//                p2++;
//            } else if (p2 == 0) {
//                p1++;
//            } else {
//                p2 = nextArray[p2];
//            }
//        }
//        return p2 == str2.length ? p1 - p2 : -1;
//
//    }

//    private static int[] getNextArray(char[] str2) {
//        if (str2.length == 1) {
//            return new int[]{-1};
//        }
//        int[] nextArray = new int[str2.length];
//        nextArray[0] = -1;
//        nextArray[1] = 0;
//        int i = 2;
//        int cur = 0;
//        while (i < str2.length) {
//            if (str2[i - 1] == str2[cur]) {
//                nextArray[i++] = ++cur;
//            } else if (cur > 0) {
//                cur = nextArray[cur];
//            } else {
//                nextArray[i++] = 0;
//            }
//        }
//        return nextArray;
//    }


//    // todo repeat3
//    public static int KMP(String str, String pattern) {
//        if (null == str || null == pattern || str.length() < pattern.length() || pattern.isEmpty()) {
//            return -1;
//        }
//        char[] source = str.toCharArray();
//        char[] target = pattern.toCharArray();
//        int[] nextArray = getNextArray(target);
//        int p1 = 0, p2 = 0;
//        while (p1 < source.length && p2 < target.length) {
//            if (source[p1] == target[p2]) {
//                p1++;
//                p2++;
//            } else if (p2 == 0) {
//                p1++;
//            } else {
//                p2 = nextArray[p2];
//            }
//        }
//        return p2 == target.length ? p1 - p2 : -1;
//    }

//    // todo repete 4
//    public static int KMP(String str, String pat) {
//        if (str == null || pat == null || str.length() < pat.length() || pat.length() == 0) {
//            return -1;
//        }
//        char[] charArray = str.toCharArray();
//        char[] patCharArray = pat.toCharArray();
//        int[] nextArray = getNextArray(patCharArray);
//        int p1 = 0, p2 = 0;
//        while (p1 < charArray.length && p2 < patCharArray.length) {
//            if (charArray[p1] == patCharArray[p2]) {
//                p1++;
//                p2++;
//            } else if (nextArray[p2] == -1) {
//                p1++;
//            } else {
//                p2 = nextArray[p2];
//            }
//        }
//        return p2 == patCharArray.length ? p1 - p2 : -1;
//    }

    // todo repeat 4
//    public static int[] getNextArray(char[] pat) {
//        if (pat.length == 1) {
//            return new int[]{-1};
//        }
//        int[] nextArray = new int[pat.length];
//        nextArray[0] = -1;
//        nextArray[1] = 0;
//        int i = 2;
//        int cur = 0;
//        while (i < pat.length) {
//            if (pat[i - 1] == pat[cur]) {
//                nextArray[i++] = ++cur;
//            } else if (cur > 0) {
//                cur = nextArray[cur];
//            } else {
//                nextArray[i++] = 0;
//            }
//        }
//        return nextArray;
//    }


//    // todo repete 5
//    public static int KMP(String str, String pattern) {
//        if (str == null || pattern == null || str.length() < pattern.length() || pattern.isEmpty()) {
//            return -1;
//        }
//        char[] charArray = str.toCharArray();
//        char[] patternCharArray = pattern.toCharArray();
//        int[] nextArray = getNextArray(patternCharArray);
//        int p1 = 0, p2 = 0;
//        while (p1 < charArray.length && p2 < patternCharArray.length) {
//            if (charArray[p1] == patternCharArray[p2]) {
//                p1++;
//                p2++;
//            } else if (p2 == 0) {
//                p1++;
//            } else {
//                p2 = nextArray[p2];
//            }
//        }
//        return p2 == patternCharArray.length ? p1 - p2 : -1;
//
//    }

//    private static int[] getNextArray(char[] patternCharArray) {
//        if (patternCharArray.length == 1) {
//            return new int[]{-1};
//        }
//        int[] nextArray = new int[patternCharArray.length];
//        nextArray[0] = -1;
//        nextArray[1] = 0;
//        int i = 2;
//        int cn = 0;
//        while (i < patternCharArray.length) {
//            if (patternCharArray[i - 1] == patternCharArray[cn]) {
//                nextArray[i++] = ++cn;
//            } else if (cn > 0) {
//                cn = nextArray[cn];
//            } else {
//                nextArray[i] = 0;
//            }
//        }
//        return nextArray;
//    }

//    // todo repeat 6
//    public static int KMP(String str, String pattern) {
//        if (str == null || pattern == null || str.length() < pattern.length() || pattern.isEmpty()) {
//            return -1;
//        }
//        char[] charArray = str.toCharArray();
//        char[] patternCharArray = pattern.toCharArray();
//        int[] nextArray = getNextArray(patternCharArray);
//        int p1 = 0, p2 = 0;
//        while (p1 < charArray.length && p2 < patternCharArray.length) {
//            if (charArray[p1] == patternCharArray[p2]) {
//                p1++;
//                p2++;
//            } else if (p2 == 0) {
//                p1++;
//            } else {
//                p2 = nextArray[p2];
//            }
//        }
//        return p2 == patternCharArray.length ? p1 - p2 : -1;
//    }

//    public static int[] getNextArray(char[] pattern) {
//        if (pattern.length == 1) {
//            return new int[]{-1};
//        }
//        int[] nextArray = new int[pattern.length];
//        nextArray[0] = -1;
//        nextArray[1] = 0;
//        int i = 2;
//        int cur = 0;
//        while (i < pattern.length) {
//            if (pattern[i - 1] == pattern[cur]) {
//                nextArray[i++] = ++cur;
//            } else if (cur > 0) {
//                cur = nextArray[cur];
//            } else {
//                nextArray[i] = 0;
//            }
//        }
//        return nextArray;
//    }

    // repete 7
    public static int KMP(String str, String pattern) {
        if (str == null || pattern == null || str.length() < pattern.length() || pattern.isEmpty()) {
            return -1;
        }
        char[] charArray = str.toCharArray();
        char[] patternCharArray = pattern.toCharArray();
        int[] nextArray = getNextArray(patternCharArray);
        int p1 = 0, p2 = 0;
        while (p1 < charArray.length && p2 < patternCharArray.length) {
            if (charArray[p1] == patternCharArray[p2]) {
                p1++;
                p2++;
            } else if (p2 == 0) { // or nextArray[p2] == -1
                p1++;
            } else {
                p2 = nextArray[p2];
            }
        }

        return p2 == patternCharArray.length ? p1 - p2 : -1;
    }

    private static int[] getNextArray(char[] patternCharArray) {
        if (patternCharArray.length == 1) {
            return new int[]{-1};
        }
        int[] nextArray = new int[patternCharArray.length];
        nextArray[0] = -1;
        nextArray[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < patternCharArray.length) {
            if (patternCharArray[i - 1] == patternCharArray[cn]) {
                nextArray[i++] = ++cn;
            } else if (cn > 0) {
                cn = nextArray[cn];
            } else {
                nextArray[i++] = 0;
            }
        }
        return nextArray;
    }


//    private static int[] getNextArray(char[] target) {
//        if (target.length == 1) {
//            return new int[]{-1};
//        }
//        // 先new 出一个结果
//        int[] nextArray = new int[target.length];
//        nextArray[0] = -1;
//        nextArray[1] = 0;
//        int i = 2;
//        int cn = 0;
//        while (i < target.length) {
//            if (target[i - 1] == target[cn]) {
//                nextArray[i++] = ++cn;
//            } else if (cn > 0) {
//                cn = nextArray[cn];
//            } else {
//                nextArray[i++] = 0;
//            }
//        }
//        return nextArray;
//    }


    @Test
    public void testKMP() {
        String str = "ababed";
        int[] nextArray = getNextArray(str.toCharArray());
    }
}
