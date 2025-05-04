package com.xiaolong.practice;

import org.junit.Test;

import java.util.*;

/**
 * @Author: imxiaolong
 * @Date: 2025/4/6 11:04
 * @Description:
 */
public class HomeworkHelp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }
        List<Integer> list = new ArrayList<>();
        String line = in.nextLine();
        String[] split = line.split(",");
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        list.sort((a, b) -> a - b);
        System.out.println(list);
        int n = list.size();
        int val1 = list.get(n - 1) * list.get(n - 2) * list.get(n - 3);
        int val2 = list.get(0) * list.get(1) * list.get(n - 1);
        int max = Math.max(val1, val2);
        System.out.println(max);

    }


    @Test
    public void test1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = in.nextInt();
        }
//        Arrays.stream(color).forEach(i -> System.out.print(i + " "));
        int left = 0;
        int right = 0;
        int[][] dp = new int[n][n];
        int start = 0, end = 0;
        while (q-- != 0) {
            char c = in.next().charAt(0);
            int len = in.nextInt();
            Set<Integer> set = new HashSet<>();
            if (c == 'L') {
                if (len > n && len % n == 0) {
                    len = n;
                    while (len-- != 0) {
                        set.add(color[left % n]);
                        left++;
                    }
                    dp[start][end - 1] = set.size();
                    System.out.println(set.size());
                } else if (len > n && len % n != 0) {
                    len = len % n;
                }
                start = left % n;
                end = start + len;
                if (dp[start][end - 1] != 0) {
                    System.out.println(dp[start][end - 1]);
                    continue;
                }
                while (len-- != 0) {
                    set.add(color[left % n]);
                    left++;
                }
                dp[start][end - 1] = set.size();
                System.out.println(set.size());
            } else {
                if (len > n && len % n == 0) {
                    len = n;
                } else if (len > n && len % n != 0) {
                    len = len % n;
                }
                end = n - 1 - (right % n);
                start = end - len + 1;
                if (dp[start][end] != 0) {
                    System.out.println(dp[start][end]);
                    continue;
                }
                while (len-- != 0) {
                    set.add(color[n - (right % n) - 1]);
                    right++;
                }
                dp[start][end] = set.size();
                System.out.println(set.size());
            }
        }
    }
}
