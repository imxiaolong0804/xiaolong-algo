package com.xiaolong.practice;

import java.util.concurrent.Semaphore;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/27 10:28
 * @Description:
 */
public class PrintOU {
    public static final Semaphore semaphore = new Semaphore(1);
    public static final Semaphore semaphore1 = new Semaphore(0);
    public static int loop = 100;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> printou());
        Thread thread2 = new Thread(() -> printji());


        thread1.start();
        thread2.start();
    }


    public static void printou() {
        for (int i = 0; i < loop; i += 2) {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + ": " + i);
                semaphore1.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void printji() {
        for (int i = 1; i < loop; i += 2) {
            try {
                semaphore1.acquire();
                System.out.println(Thread.currentThread().getName() + ": " + i);
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
