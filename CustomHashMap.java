// Creating the CustomHashMap class to create the hashmap by own

import java.util.LinkedList;

class CustomHashMap<K, V> {
    
    private static final int INITIAL_CAPACITY = 16; 
    private static final float LOAD_FACTOR = 0.75f;
    
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    
    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }
    
    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // Hash function
    private int getBucketIndex(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % buckets.length);
    }
    
    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                entry.value = value;  // Update existing key
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;

        if ((float) size / buckets.length > LOAD_FACTOR) {
            resize();
        }
    }
    
    // Get value by key
    public V get(K key) {
        int index = getBucketIndex(key);

        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                    return entry.value;
                }
            }
        }
        return null;
    }
    
    // Remove key-value pair
    public boolean remove(K key) {
        int index = getBucketIndex(key);

        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                    bucket.remove(entry);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    // Resize and rehash
    private void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }
    
    // Print the map (for testing)
    public void printMap() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            if (buckets[i] != null) {
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + " = " + entry.value + "] ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Testing insertion
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);
        map.put("apple", 40); // Overwrite

        // Testing retrieval
        System.out.println("apple: " + map.get("apple"));   // 40
        System.out.println("banana: " + map.get("banana")); // 20
        System.out.println("grape: " + map.get("grape"));   // null

        // Testing removal
        System.out.println("Removing banana: " + map.remove("banana"));  // true
        System.out.println("Removing grape: " + map.remove("grape"));    // false

        // Printing the hash map
        map.printMap();
    }
}


// Output:
// apple: 40
// banana: 20
// grape: null
// Removing banana: true
// Removing grape: false
// Bucket 0:
// Bucket 1:
// Bucket 2:
// Bucket 3:
// Bucket 4:
// Bucket 5:
// Bucket 6:
// Bucket 7: [cherry = 30]
// Bucket 8:
// Bucket 9:
// Bucket 10: [apple = 40]
// Bucket 11:
// Bucket 12:
// Bucket 13:
// Bucket 14:
// Bucket 15:

