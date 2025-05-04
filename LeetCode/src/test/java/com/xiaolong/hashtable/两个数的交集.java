package com.xiaolong.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: imxiaolong
 * @Date: 2024/12/4 19:42
 * @Description:
 */
public class 两个数的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        return set2.stream().mapToInt(i -> i).toArray();
    }
}
