package org.walmart;

import java.util.*;


/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support get and put operations.
 * <p>
 * get(key): Get the value (which will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value): Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUcache {
    public class Node {
        int value;
        int key;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int capacity;
    public HashMap<Integer, Node> cache;
    public Node head;
    public Node tail;

    public LRUcache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            remove(node);
            insertNodeInFront(node);
            return node.value;
        }
        return -1;
    }

    public void remove(Node node) {
        this.cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertNodeInFront(Node node) {
        this.cache.put(node.key, node);
        this.head.next.prev = node;
        node.next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
    }

    public void put(int key, int value) {
        //step1: check if the key already exist and update
        if (this.cache.containsKey(key)) {
            get(key);
            this.cache.get(key).value = value;
            return;
        }

        // step2: check if the size is at capacity
        if (this.cache.size() > this.capacity) {
            Node node = this.tail.prev;
            popTail();

        }
        //

    }

    private void popTail(){
        Node node = this.tail.prev;
        cache.remove(node.key);
        this.tail.prev.value = this.tail.value;
        this.tail.prev.next = null;
        this.tail = this.tail.prev;
    }
}
