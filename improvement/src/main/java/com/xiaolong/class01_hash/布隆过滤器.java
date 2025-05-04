package com.xiaolong.class01_hash;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/8 19:35
 * @Description:
 */
public class 布隆过滤器 {
    /**
     * 想url黑名单那个问题
     * 布隆过滤器是可以有失误率的
     * n = 样本数量 p = 失误率 m = bit数，也就是位图 k = hash函数个数
     * ==》m = - (n * ln(p)) / (ln2)^2
     * k = ln2 * （m/n）
     */
}
