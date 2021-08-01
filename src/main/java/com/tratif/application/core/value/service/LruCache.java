package com.tratif.application.core.value.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<Integer, Value> {
    private Map<Integer, Value> map;

    public LruCache(int cacheSize) {
        this.map = new LinkedHashMap<>(10, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }

    public Value get(Integer key) {
        return map.get(key);
    }

    public void set(Integer key, Value value) {
        map.put(key, value);
    }


}
