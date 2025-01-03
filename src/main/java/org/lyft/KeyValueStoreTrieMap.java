package org.lyft;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KeyValueStoreTrieMap {
    Map<String, TreeMap<Integer, String>> map;

    /**
     * Initialize your data structure here.
     */
    public KeyValueStoreTrieMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> treeMap = map.get(key);
        Integer t = treeMap.floorKey(timestamp);
        if (t == null) {
            return "";
        }
        return treeMap.get(t);
    }

}
