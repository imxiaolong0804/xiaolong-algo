package com.xiaolong.practice;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: imxiaolong
 * @Date: 2025/4/2 13:13
 * @Description:
 */
public class LiCode {

    @Test
    public void test1() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        lengthOfLIS(nums);

    }

    @Test
    public void test2() {

        String s = reverseWords("  hello world  ");
        System.out.println(s);


    }


    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 初始化为1，因为其自身就是 1 了
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) { // 遍历比i小的数，然后递推出其最大值
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(i, dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]); // 因为dp是以i结尾的最大子序列长度，所以整体最大值可能在任意i处取得，而不是在最后一个位置取得
        }
        return max;
    }

    public String reverseWords(String s) {
        s = s.strip();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && s.charAt(i - 1) == ' ') {
                continue;
            }
            sb.append(c);
        }
        sb.reverse();
        System.out.println(sb.toString());
        int len = sb.length();
        int start = 0, end = 0;
        StringBuilder ans = new StringBuilder();
        while (end < len) {
            if (sb.charAt(end) == ' ') {
                ans.append(reversestr(sb.substring(start, end)));
                ans.append(' ');
                start = ++end;
            } else if (end + 1 == len) {
                ans.append(reversestr(sb.substring(start, end + 1)));
                break;
            } else {
                end++;
            }
        }

        return ans.toString();
    }

    public String reversestr(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    @Test
    public void test4() {

        String s = "AB";
        convert(s, 1);

    }


    public String convert(String s, int numRows) {
        int len = s.length();
        char[][] matrix = new char[numRows][len];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = ' ';
            }
        }
        int index = 0;
        int col = 0;
        while (index < len) {
            for (int i = 0; i < numRows; i++) {
                if (index < len) {
                    matrix[i][col] = s.charAt(index++);
                } else {
                    break;
                }
            }
            int loop = numRows - 2;
            while (loop != 0) {
                if (index < len) {
                    matrix[loop--][++col] = s.charAt(index++);
                } else {
                    break;
                }
            }
            col++;
//            for (int i = numRows - 2; i > numRows - 3; i--) {
//                if (index < len) {
//                    matrix[i][++col] = s.charAt(index++);
//                } else {
//                    break;
//                }
//            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] != ' ') {
                    sb.append(matrix[i][j]);
                }
            }
        }
        return sb.toString();
    }


    @Test
    public void test3() {
//        String s = "/home/user/Documents/../Pictures";
        String s = "/home//foo/";

        Arrays.stream(s.split("/")).forEach(System.out::println);
        String[] split = s.split("/");
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 1; i < split.length; i++) {
            if (split[i].equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                    stack.pop();
                }
            } else {
                stack.push("/");
                stack.push(split[i]);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        System.out.println(sb.toString());



    }

//    public String simplifyPath(String path) {
//        String[] split = path.split("/");
//
//    }
}
