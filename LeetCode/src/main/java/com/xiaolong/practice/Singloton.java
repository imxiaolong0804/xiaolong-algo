package com.xiaolong.practice;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/25 19:38
 * @Description:
 */
public class Singloton {
    private static Singloton instance;

    private Singloton() {
    }

    public static Singloton getInstance() {
        if (null == instance) {
            synchronized (Singloton.class) {
                if (null == instance) {
                    instance = new Singloton();
                }
            }
        }
        return instance;
    }
}
