package com.pwh.jdk.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Waver Pan
 * @date 2022/7/24 20:00
 */
public class Lru {
    public static void main(String[] args) {
        final int cacheSize = 100;
        LinkedHashMap lruCache = new LinkedHashMap((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }
}
