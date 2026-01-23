package org.prepare.friday;

import java.util.LinkedHashMap;
import java.util.Map;

public class MRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    private K lastAccessedKey;

    public MRUCache(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true
        this.capacity = capacity;
    }

    @Override
    public V get(Object key) {
        V value = super.get(key);
        if (value != null) {
            lastAccessedKey = (K) key;
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        V old = super.put(key, value);
        if (size() > capacity) {
            super.remove(lastAccessedKey); // Evict MRU directly
        }
        return old;
    }

    public static void main(String[] args) {
        MRUCache<Integer, String> cache = new MRUCache<>(2);
        cache.put(1, "A"); // {1=A}
        cache.put(2, "B"); // {1=A, 2=B}
        cache.get(1);      // 1 is MRU
        cache.put(3, "C"); // Evicts 1 (MRU)
        System.out.println(cache); // {2=B, 3=C}
    }


}

