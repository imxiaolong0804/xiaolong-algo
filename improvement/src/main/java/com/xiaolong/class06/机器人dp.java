package com.xiaolong.class06;


import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/21 22:35
 * @Description: 机器人走路，1-n，左右两边走，到终点，有多少种走法
 */
public class 机器人dp {

    public static int robbot(int n, int e, int rest, int s) {
        return f(n, e, rest, s);
    }

    private static int f(int n, int e, int rest, int s) {
        if (rest == 0) {
            return s == e ? 1 : 0;
        }
        if (s == 1) {
            return f(n, e, rest - 1, 2);
        }
        if (s == n) {
            return f(n, e, rest - 1, n - 1);
        }
        // 机器人来到中间位置，两边都可以走
        return f(n, e, rest - 1, s - 1) + f(n, e, rest - 1, s + 1);
    }

    public static int robbotDpWithHashMap(int n, int e, int rest, int s) {
        // todo 记忆化搜索，就是在递归的基础上加缓存
        HashMap<String, Integer> cache = new HashMap<>();
        return f2(n, e, rest, s, cache);

    }

    private static int f2(int n, int e, int rest, int cur, HashMap<String, Integer> cache) {
        // 先找缓存中有没有
        String cacheKey = rest + "_" + cur;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        // 没有再去递归
        if (rest == 0) {
            // 说明已经不能走了，这个时候再判断是否走到终点了
            cache.put(cacheKey, cur == e ? 1 : 0);
        } else if (cur == 1) {
            cache.put(cacheKey, f2(n, e, rest - 1, 2, cache));
        } else if (cur == n) {
            cache.put(cacheKey, f2(n, e, rest - 1, n - 1, cache));
        } else {
            cache.put(cacheKey, f2(n, e, rest - 1, cur - 1, cache) + f2(n, e, rest - 1, cur + 1, cache));
        }
        return cache.get(cacheKey);
    }

    public static int robotDpWithArrayList(int n, int e, int rest, int s) {
        int[][] cache = new int[rest + 1][n + 1];
        for (int i = 0; i <= rest; i++) {
            for (int j = 0; j <= n; j++) {
                cache[i][j] = -1;
            }
        }
        return f3(n, e, rest, s, cache);
    }

    private static int f3(int n, int e, int rest, int cur, int[][] cache) {
        // 先走缓存
        if (cache[rest][cur] != -1) {
            return cache[rest][cur];
        }
        // 然后不行再递归
        if (rest == 0) {
            cache[rest][cur] = cur == e ? 1 : 0;
        } else if (cur == 1) {
            cache[rest][cur] = f3(n, e, rest - 1, 2, cache);
        } else if (cur == n) {
            cache[rest][cur] = f3(n, e, rest - 1, n - 1, cache);
        } else {
            cache[rest][cur] = f3(n, e, rest - 1, cur - 1, cache) + f3(n, e, rest - 1, cur + 1, cache);
        }
        return cache[rest][cur];
    }


    @Test
    public void test1() {
        int n = 30, e = 13, rest = 36, cur = 1;
        long startTime, endTime;
        // 测试 robbotDp 函数运行时间
        startTime = System.nanoTime(); // 开始时间
        int robbotDpResult = robbotDpWithHashMap(n, e, rest, cur);
        endTime = System.nanoTime(); // 结束时间
        System.out.println("robbotDp result: " + robbotDpResult);
        System.out.println("robbotDp execution time: " + (endTime - startTime) / 1_000_000_000.0 + " s");
        System.out.println("============================");

        // 测试 二维数组缓存的运行时间
        startTime = System.nanoTime();
        int robbotDpwitharray = robotDpWithArrayList(n, e, rest, cur);
        endTime = System.nanoTime();
        System.out.println("robbotDpwitharray result: " + robbotDpwitharray);
        System.out.println("robbotDpwitharray execution time：" + (endTime - startTime) / 1_000_000_000.0 + " s");
        System.out.println("============================");

        // 测试 robbot 函数运行时间
        startTime = System.nanoTime(); // 开始时间
        int robbotResult = robbot(n, e, rest, cur);
        endTime = System.nanoTime(); // 结束时间
        System.out.println("robbot result: " + robbotResult);
        System.out.println("robbot execution time: " + (endTime - startTime) / 1_000_000_000.0 + " s");


    }
}
