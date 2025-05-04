package com.xiaolong.practice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/25 12:54
 * @Description:
 */
public class PrintABC {

    private static int count = 0;
    private final static ReentrantLock lock = new ReentrantLock();
    private final static Condition conditiona = lock.newCondition();
    private final static Condition conditionb = lock.newCondition();
    private final static Condition conditionc = lock.newCondition();

    public static void main(String[] args) {

        Thread a = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (count != 0) {
                        conditiona.await();
                    }
                    System.out.print("a-");
                    count = 1;
                    conditionb.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (count != 1) {
                        conditionb.await();
                    }
                    System.out.print("b-");
                    count = 2;
                    conditionc.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread c = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (count != 2) {
                        conditionc.await();
                    }
                    System.out.println("c");
                    count = 0;
                    conditiona.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        a.start();
        b.start();
        c.start();
    }
}
