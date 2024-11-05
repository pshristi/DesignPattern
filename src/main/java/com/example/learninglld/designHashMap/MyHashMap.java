package com.example.learninglld.designHashMap;

public class MyHashMap<K,V> {
    class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;
    }

    int capacity = 1<<4; //16
    Entry[] table;
    int MAX_CAPACITY = 1<<30; //1073741824
    double loadFactor = 0.75;

    MyHashMap() {
        table = new Entry[capacity];
    }

    MyHashMap(int capacity) {
        int newCapacity = roundUpToPowerOfTwo(capacity);
        this.capacity = newCapacity;
        table = new Entry[newCapacity];
    }

    private Integer roundUpToPowerOfTwo(int capacity) {
        int n = capacity - 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        if(n < 0) {
            return 1;
        }
        if(n > MAX_CAPACITY) {
            return MAX_CAPACITY;
        }
        return n + 1;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    private void put(K key, V value) {
        int index = hash(key);
        Entry entry = table[index];
        if(entry != null) {
            while(entry!= null) {
                if(entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                if(entry.next == null) {
                    Entry<K,V> newEntry = new Entry<>();
                    newEntry.key = key;
                    newEntry.value = value;
                    entry.next = newEntry;
                    return;
                }
                entry = entry.next;
            }
        }

        Entry newEntry = new Entry<>();
        newEntry.key = key;
        newEntry.value = value;
        table[index] = newEntry;
    }

    private V get(K key) {
        int index = hash(key);
        Entry entry = table[index];
        while(entry!= null) {
            if(entry.key.equals(key)) {
                return (V)entry.value;
            }
            entry = entry.next;
        }
        return null;
    }
}
