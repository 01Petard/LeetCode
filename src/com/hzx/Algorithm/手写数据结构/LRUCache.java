package com.hzx.Algorithm.手写数据结构;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * LRU缓存机制（API）
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        // 第三个参数表示访问顺序，true表示按照访问顺序排序，最近访问的放在头部，最久未访问的放在尾部
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");

        System.out.println(cache.get(1)); // 返回 "one"，同时活跃顺序改为：2 <- 3 <- 1
        cache.put(4, "four"); // 这将使得"two"被淘汰

        System.out.println(cache.get(2)); // 返回 "null"
        cache.put(5, "five"); // 这将使得"three"被淘汰

        System.out.println(cache.get(1)); // 返回 one
        System.out.println(cache.get(3)); // 返回 null，因为"three"已经被淘汰了
        System.out.println(cache.get(4)); // 返回 "four"
        System.out.println(cache.get(5)); // 返回 "five"
    }
}
