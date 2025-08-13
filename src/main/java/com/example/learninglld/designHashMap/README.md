# HashMap Implementation

## Overview
This package contains a custom implementation of a HashMap data structure. While not a design pattern itself, understanding how to implement fundamental data structures is an important skill in software development.

## What is a HashMap?
A HashMap is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A HashMap uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found.

## Implementation Details

### Components
1. **Entry Class**: An inner class that represents a key-value pair with a reference to the next entry (for handling collisions)
2. **Hash Table**: An array of Entry objects
3. **Hash Function**: A method that computes the index for a key
4. **Collision Handling**: Using separate chaining (linked lists)

### Key Features
- Generic implementation that can work with any key and value types
- Dynamic capacity that starts at 16 (2^4)
- Load factor of 0.75 (though resizing is not implemented in this version)
- Collision handling using separate chaining
- Capacity is always a power of 2 for efficient hashing

## Code Implementation

### Entry Class
```java
class Entry<K,V> {
    K key;
    V value;
    Entry<K,V> next;
}
```

### Constructors
```java
MyHashMap() {
    table = new Entry[capacity];
}

MyHashMap(int capacity) {
    int newCapacity = roundUpToPowerOfTwo(capacity);
    this.capacity = newCapacity;
    table = new Entry[newCapacity];
}
```

### Hash Function
```java
private int hash(K key) {
    return Math.abs(key.hashCode()) % capacity;
}
```

### Put Method
```java
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
```

### Get Method
```java
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
```

## How It Works
1. When a key-value pair is added using `put(key, value)`:
   - The hash function computes an index for the key
   - If the bucket at that index is empty, a new Entry is created and stored there
   - If the bucket already contains entries, the method checks if the key already exists
   - If the key exists, its value is updated
   - If the key doesn't exist, a new Entry is added to the end of the linked list

2. When a value is retrieved using `get(key)`:
   - The hash function computes an index for the key
   - The method traverses the linked list at that index
   - If an Entry with a matching key is found, its value is returned
   - If no matching key is found, null is returned

## Limitations of This Implementation
- No resizing mechanism when the load factor is exceeded
- No removal method
- No iterator for traversing all key-value pairs
- No handling of null keys

## Time Complexity
- **Put Operation**: O(1) average case, O(n) worst case (when all keys hash to the same bucket)
- **Get Operation**: O(1) average case, O(n) worst case (when all keys hash to the same bucket)

## Space Complexity
- O(n) where n is the number of key-value pairs stored in the HashMap

## Real-World Applications
- Caching
- Database indexing
- Symbol tables in compilers
- Associative arrays in programming languages
