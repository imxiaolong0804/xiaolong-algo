package com.xiaolong.class05_bigdata;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/20 22:11
 * @Description:
 */
public class 加减乘除 {

    public static int bitAdd(int a, int b) {
        int sum = 0;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }


    public static int multiply(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res  = bitAdd(res, a);
            }
            b >>>= 1;
            a <<= 1;
        }
        return res;
    }
}
