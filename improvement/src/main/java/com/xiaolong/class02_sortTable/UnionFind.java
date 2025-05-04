package com.xiaolong.class02_sortTable;

import java.util.*;

/**
 * @Author: imxiaolong
 * @Date: 2025/3/14 10:50
 * @Description:
 */
public class UnionFind {

    // 定义包装类，就是比如你输入的是一个 int 将其包装为一个类型
    public static class Element<V> {
        public V element;

        public Element(V value) {
            this.element = value;
        }
    }


    public static class UnionFindSet<V> {
        // 首先定义一个包装类的 map 使得 v -- element
        Map<V, Element<V>> elementMap;
        // 再定义一个 father map，存储每一个节点的father
        Map<Element<V>, Element<V>> fatherMap;
        // 最后定义一个每个作为顶点的元素的set大小
        Map<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            // 将每一个点都定义一下
            for (V v : list) {
                Element<V> element = new Element<>(v);
                elementMap.put(v, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }


        // 去判断两个值是否在同一个集合中
        public boolean isSameSet(V a, V b) {
            // 首先是需要判断其是否已经包装了
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> atop = findHead(elementMap.get(a));
                Element<V> btop = findHead(elementMap.get(b));
                return atop == btop;
            }
            // 否则都没有定义过，直接返回false
            return false;
        }

        // 合并两个set
        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                // 找出两个点的头节点
                Element<V> ahead = findHead(elementMap.get(a));
                Element<V> bhead = findHead(elementMap.get(b));
                if (ahead != bhead) {
                    // 找出他们中大的一个
                    Element<V> bigger = sizeMap.get(ahead) >= sizeMap.get(bhead) ? ahead : bhead;
                    Element<V> smaller = bigger == ahead ? bhead : ahead;
                    // 然后将小的挂在大的上面
                    fatherMap.put(smaller, bigger);
                    sizeMap.put(bigger, sizeMap.get(ahead) + sizeMap.get(bhead));
                    // 最后删除小的sizemap
                    sizeMap.remove(smaller);
                }
            }
        }


        // 找到某个点的 头 节点
        public Element<V> findHead(Element<V> element) {
            Deque<Element<V>> stack = new ArrayDeque<>();
            // 向上循环找到其 head
            while (element != fatherMap.get(element)) {
                stack.push(element);
                element = fatherMap.get(element);
            }
            // 然后优化，就是将路径所有的点都指向头节点
            while (!stack.isEmpty()) {
                Element<V> top = stack.pop();
                fatherMap.put(top, element);
            }
            return element;
        }
    }
}
