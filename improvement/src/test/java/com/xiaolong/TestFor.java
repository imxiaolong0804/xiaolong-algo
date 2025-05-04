package com.xiaolong;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: imxiaolong
 * @Date: 2024/12/14 15:47
 * @Description:
 */
public class TestFor {


    @Test
    public void test() {
        int n = 12345000;
        System.out.printf("n=%d, hex=%08x", n, n); // 注意，两个%占位符必须传入两个数
    }

    @Test
    public void test_scoreImprove() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入上次考试成绩：");
        int lastScore = scanner.nextInt();
        System.out.print("请输入这次考试成绩：");
        int thisScore = scanner.nextInt();
        float improve = (float) ((thisScore - lastScore) * 1.0 / lastScore) * 100;
        System.out.println("正在计算考试成绩提高百分比..........");
        System.out.printf("成绩提高了%.2f%%", improve);
        new CountDownLatch(1).await();
    }

    @Test
    public void test2() {
        Integer i = 1;
        printClassInfo(i.getClass());
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }

    @Test
    public void test1() {
        String s = "hello";
        char c = s.charAt(0);
        System.out.println(c);
        HashSet<Character> characters = new HashSet<>();
        characters.add(c);
    }

    @Test
    public void test3() {
        Date date = new Date();
        System.out.println(date.getYear() + 1900);
        System.out.println(date);
        System.out.println(date.toLocaleString());
    }

    @Test
    public void test4() {

        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt2);

    }

    @Test
    public void test5() throws InterruptedException {


//        MyThread t = new MyThread();
//        t.start();
//        Thread.sleep(10);
//        t.interrupt();
//        t.join();

        System.out.println("main start...");
        Thread t = new Thread(() -> {
            System.out.println("thread run...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread end.");
        });
        t.start();
        System.out.println("main end...");

//        Thread t = new MyThread();
//        t.start();
//        Thread.sleep(1000);
//        t.interrupt(); // 中断t线程
//        t.join(); // 等待t线程结束
//        System.out.println("end");

    }


    @Test
    public void test6() throws InterruptedException {

        AddThread add = new AddThread();
        DecThread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);

    }

    @Test
    public void test7() {

//        int i = subarraySum(new int[]{1, 1, 1}, 2);
//        System.out.println(i);
        int[] ints = {1, 2, 3};
        int k = 3;
        int size = ints.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            int sum = ints[i];
            for (int j = i + 1; j < size; j++) {
                sum += ints[j];
                if (sum == k) {
                    count++;
                }
                break;
            }
        }
        System.out.println(count);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int leftIndex = 0, rightIndex = 0;
        int sum = 0;
        while (rightIndex < nums.length) {
            if (sum < k) {
                sum += nums[rightIndex++]++;
            } else if (sum > k) {
                sum -= nums[leftIndex++];
            } else {
                count++;
                leftIndex++;
            }
        }
        return count;
    }

    @Test
    public void test_238() {
        productExceptSelf(new int[]{1, 2, 3, 4});

    }


    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int last = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            switchNum(nums, i, last);
            for (int j = 0; j < nums.length - 1; j++) {
                ans[i] *= nums[j];
            }
            switchNum(nums, i, last);
        }
        return ans;
    }

    @Test
    public void test_insertAlo() {
        int[] arr = new int[10];
        // 就是 数组在 【0 - i】 上是有序的
        for (int i = 1; i < arr.length; i++) {
            // 下一个数，也就是 arr【i】 加入后，也要保证 arr 【0 - i + 1】上是有序的，可以用while
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                switchNum(arr, j, j + 1);
            }
        }
    }

    public static void switchNum(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    @Test
    public void test_mp() {
        int[] arr = new int[10];

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    switchNum(arr, j, j + 1);
                }
            }
        }

    }

}


class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count -= 1;
            }
        }
    }
}

class MyThread extends Thread {

    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }

}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}

