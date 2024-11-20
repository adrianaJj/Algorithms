package org.walmart;

import java.util.ArrayList;
import java.util.List;

public class HashSetImpl {

    private List<List<Integer>> arr;
    int size;

    public HashSetImpl() {
        size = 100;
        arr = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arr.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        int hash = hashC(key);
        List<Integer> bucket = arr.get(hash);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int hash = hashC(key);
        List<Integer> bucket = arr.get(hash);
        if (bucket.contains(key)) {
            bucket.remove(key);
        }
    }

    public boolean contains(int key) {
        int hash = hashC(key);
        List<Integer> bucket = arr.get(hash);
        return bucket.contains(key);
    }

    private int hashC(int key) {
        return key % size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

