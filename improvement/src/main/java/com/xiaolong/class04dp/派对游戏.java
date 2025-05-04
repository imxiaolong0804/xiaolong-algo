package com.xiaolong.class04dp;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/14 20:09
 * @Description: 就是有这样的结构，employee，一个元素是它本身的快乐值，一个元素是它的直接下属，
 * 规则是这样的，要求整个party的最大快乐值，并且只要直接上属来的话，他的下属就不会来
 */
public class 派对游戏 {
    public static class Employee {
        public int happy;
        public List<Employee> children;

        public Employee(int happy, List<Employee> children) {
            this.happy = happy;
            this.children = children;
        }
    }


    // 定义返回值
    @AllArgsConstructor
    public static class Info {
        public int laiHappy;
        public int buHappy;
    }


    public static Info process(Employee x) {
        if (x.children.isEmpty()) {
            return new Info(x.happy, 0);
        }
        // 分情况讨论，讨论x来和不来情况下的最大快乐值
        int lai = x.happy;
        int bu = 0;
        for (Employee child : x.children) {
            Info childInfo = process(child);
            lai += childInfo.buHappy;
            bu += Math.max(childInfo.laiHappy, childInfo.buHappy);
        }
        return new Info(lai, bu);
    }

}
