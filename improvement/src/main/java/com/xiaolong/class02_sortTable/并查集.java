package com.xiaolong.class02_sortTable;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/10 15:36
 * @Description:
 */
public class 并查集 {

    public static class Element<T> {
        private T value;

        public Element(T value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<T> {
        // 每个元素原始对应封装后的
        public HashMap<T, Element<T>> elementMap;
        // 每个元素的父元素
        public HashMap<Element<T>, Element<T>> fatherMap;
        // 头节点的size
        public HashMap<Element<T>, Integer> sizeMap;

        public UnionFindSet(List<T> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            // 这里依次将数据放入
            for (T t : list) {
                Element<T> element = new Element<>(t);
                elementMap.put(t, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        public Element<T> findHead(Element<T> element) {
            Stack<Element<T>> stack = new Stack<>();
            while (element != fatherMap.get(element)) {
                stack.push(element);
                element = fatherMap.get(element);
            }
            // 最后再优化，将路径上的点都指向head
            while (!stack.isEmpty()) {
                Element<T> pop = stack.pop();
                fatherMap.put(pop, element);
            }
            return element;
        }

        public boolean isSameSet(T d1, T d2) {
            // 首先先判断是否在elment里面
            if (elementMap.containsKey(d1) && elementMap.containsKey(d2)) {
                return findHead(elementMap.get(d1)) == findHead(elementMap.get(d2));
            }
            return false;
        }


        public void union(T d1, T d2) {
            if (elementMap.containsKey(d1) && elementMap.containsKey(d2)) {
                // 首先都需要找到各自节点的head
                Element<T> head = findHead(elementMap.get(d1));
                Element<T> head2 = findHead(elementMap.get(d2));
                if (head != head2) {
                    // 找出哪个最大
                    Integer i1 = sizeMap.get(head);
                    Integer i2 = sizeMap.get(head2);
                    Element<T> larger = i1 > i2 ? head : head2;
                    Element<T> smaller = larger == head ? head2 : larger;
                    // 改变大的size
                    sizeMap.put(larger, i1 + i2);
                    // 最后移除小的那个
                    sizeMap.remove(smaller);
                }
            }
        }
    }
}
