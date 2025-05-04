package com.xiaolong.class01_hash;

import org.junit.jupiter.api.Test;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/7 22:09
 * @Description:
 */
public class BitMap {


    @Test
    public void test_1() {
        int i = 32 % 32;
        System.out.println(i);
    }

    public static void main(String[] args) {
        int a = 0;

        int[] arr = new int[10]; // 表示320bit
        // int[0] -> 0 ~ 31
        // int[1] -> 32 ~ 63

        int i = 178; // 想要取得178bit上的信息

        int numIndex = i / 32;
        int bitIndex = i % 32;

        // 拿到178位置上的状态
//        int i1 = arr[numIndex] & (1 << bitIndex);
        int i2 = (arr[numIndex] >> bitIndex) & 1;

        // 把178bit位上的信息改为1
        int s = (1 << bitIndex) | arr[numIndex];

        // 把178bit位上的信息改为0
        int s2 = (~(1 << bitIndex)) & arr[numIndex];
    }
}
