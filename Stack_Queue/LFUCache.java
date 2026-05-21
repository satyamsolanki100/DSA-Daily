// File: LFUCache.java

import java.util.*;

public class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }
    }

    class DLL {
        Node head, tail;
        int size;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    private int capacity, minFreq;
    private Map<Integer, Node> map;
    private Map<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            update(node);
        } else {
            if (map.size() == capacity) {
                DLL list = freqMap.get(minFreq);
                Node toRemove = list.removeLast();
                map.remove(toRemove.key);
            }

            Node node = new Node(key, value);
            map.put(key, node);

            minFreq = 1;
            DLL list = freqMap.getOrDefault(1, new DLL());
            list.add(node);
            freqMap.put(1, list);
        }
    }

    private void update(Node node) {
        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;
        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }

    public static void main(String[] args) {

        LFUCache lfu = new LFUCache(2);

        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(1)); // 1

        lfu.put(3, 3);
        System.out.println(lfu.get(2)); // -1
        System.out.println(lfu.get(3)); // 3

        lfu.put(4, 4);
        System.out.println(lfu.get(1)); // -1
        System.out.println(lfu.get(3)); // 3
        System.out.println(lfu.get(4)); // 4
    }
}