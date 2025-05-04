package com.xiaolong;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/22 22:46
 * @Description:
 */
class Solution {
    static List<String> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String s = "25525511135";
        restoreIpAddresses(s);
    }

    public static List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
//        System.out.println(ans);
        return ans;
    }


    public static void backtracking(String s, int startIndex, int point) {
        if (point == 3) {
            if (isValid(s.substring(startIndex))) {
                ans.add(sb.toString() + s.substring(startIndex));
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            int len = sub.length();
            if (isValid(sub)) {
                sb.append(sub);
                sb.append('.');
                backtracking(s, i + 1, point + 1);
                sb.delete(sb.length() - len - 1, sb.length());
            } else {
                break;
            }
        }
    }

    public static boolean isValid(String s) {
        char[] ch = s.toCharArray();
        if (ch.length == 0) {
            return false;
        }
        if (ch[0] == '0' && ch.length > 1) {
            return false;
        }
        if (Integer.valueOf(s) > 255) {
            return false;
        }
        return true;
    }
}
