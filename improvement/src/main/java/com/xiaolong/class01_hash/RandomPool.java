package com.xiaolong.class01_hash;

import java.util.HashMap;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/7 21:10
 * @Description:
 */
public class RandomPool {

    public static class Pool<T> {

        private HashMap<T, Integer> keyIndexMap;
        private HashMap<Integer, T> IndexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<>();
            this.IndexKeyMap = new HashMap<>();
            this.size = 0;
        }

        public void insert(T data) {
            if (!this.keyIndexMap.containsKey(data)) {
                this.keyIndexMap.put(data, this.size);
                this.IndexKeyMap.put(this.size++, data);
            }
        }

        public T getRandom() {
            if (this.size == 0) {
                return null;
            } else {
                int randomIndex = (int) (Math.random() * this.size);
                return IndexKeyMap.get(randomIndex);
            }
        }

        public void delete(T key) {
            if (keyIndexMap.containsKey(key)) {
                T t = IndexKeyMap.get(--size);
                Integer index = keyIndexMap.get(key);
                keyIndexMap.put(t, index);
                IndexKeyMap.put(index, t);
                keyIndexMap.remove(key);
                IndexKeyMap.remove(size);
            }
        }
    }
}
