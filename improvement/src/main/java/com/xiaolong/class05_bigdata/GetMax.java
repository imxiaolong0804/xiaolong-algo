package com.xiaolong.class05_bigdata;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/20 21:10
 * @Description:
 */
public class GetMax {

    /**
     * 输入为1，返回为0，输入为0，返回为1
     *
     * @param n 只能输入 0 或者 1
     * @return 0  |  1
     */
    public static int flip(int n) {
        return n ^ 1;
    }

    /**
     * 作用是如果输入的为非负，输出为1， 如果为负数，输出为0
     *
     * @param n
     * @return
     */
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax(int a, int b) {
        int c = a - b;
        // sca 为 如果 c大于等于0，则为1，否则为0
        int sca = sign(c);
        // scb 与 sca 互斥
        int scb = flip(sca);
        return a * sca + b * scb;
    }

    // 改进版，上面那版可能会导致溢出
    public static int getMaxPro(int a, int b) {
        int c = a - b;
        int sa = sign(a); // a的符号，1为正，0为负
        int sb = sign(b); // 同样的
        int sca = sign(c); // 同样的差的符号
        int diff = sa ^ sb; // 如果 sa和sb相同的话为0，不相同为1
        int same = flip(diff); // sa和sb的符号相同为 1， 不相同为0
        // 那么返回a的条件就是，如果ab符号不同的话，那么当a为正的时候返回a，如果ab符号相同，那么就不会溢出，那么就返回sca的符号，sca为1返回a
        int returnA = diff * sa + same * sca;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }


}
