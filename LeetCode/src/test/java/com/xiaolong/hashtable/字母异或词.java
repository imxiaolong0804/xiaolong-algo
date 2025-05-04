package com.xiaolong.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: imxiaolong
 * @Date: 2024/12/4 19:14
 * @Description:
 */
public class 字母异或词 {


    // todo 还可以用数组来模拟hash表

    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        if (s1.length != s2.length) {
            return false;
        }
        Map<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            hashmap.put(String.valueOf(s1[i]), 0);
        }
        for (int i = 0; i < s1.length; i++) {
            if (!hashmap.containsKey(String.valueOf(s2[i]))) {
                return false;
            }
            hashmap.put(String.valueOf(s2[i]), hashmap.get(String.valueOf(s2[i])) + 1);
            hashmap.put(String.valueOf(s1[i]), hashmap.get(String.valueOf(s1[i])) - 1);
        }
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
