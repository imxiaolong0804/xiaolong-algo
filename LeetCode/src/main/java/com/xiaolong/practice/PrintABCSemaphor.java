package com.xiaolong.practice;

import java.util.concurrent.Semaphore;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/25 13:30
 * @Description:
 */
public class PrintABCSemaphor {
    private static final Semaphore semaphorea = new Semaphore(1);
    private static final Semaphore semaphoreb = new Semaphore(0);
    private static final Semaphore semaphorec = new Semaphore(0);

    private final static int loop = 100;

    public static void main(String[] args) {
        Thread threada = new Thread(() -> print("a", semaphorea, semaphoreb));
        Thread threadb = new Thread(() -> print("b", semaphoreb, semaphorec));
        Thread threadc = new Thread(() -> print("c", semaphorec, semaphorea));
        threada.start();
        threadb.start();
        threadc.start();
    }

    public static void print(String str, Semaphore cur, Semaphore next) {
        for (int i = 0; i < loop; i++) {
            try {
                cur.acquire();
                if (str.equals("a")) {
                    System.out.print("a-");
                } else if (str.equals("b")) {
                    System.out.print("b-");
                } else {
                    System.out.println("c");
                }
                next.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
