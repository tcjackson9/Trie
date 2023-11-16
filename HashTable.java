/*
 * File: HashTable.java
 * Author: Henry Einhaus
 * Purpose: Simple hashtable to compare
 * against Trie
 */



public class HashTable implements DataStructure {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    public int i;
    private String[] table;
    private int size;

    //HashTable Constructor
    public HashTable() {
        table = new String[INITIAL_CAPACITY];
        size = 0;
    }

    // hash(key) computes the hash given a key
    private int hash(String key) {
        // Hash: Uses java's hashcode function to compute
        return key.hashCode() % table.length;
    }

    /*
     * resizeTable() will resize the
     * hashtable if the load factor is > .75
     */
    private void resizeTable() {
        int newCapacity = table.length * 2;
        String[] newTable = new String[newCapacity];

        for (String key : table) {
            if (key != null) {
                int index = Math.abs(hash(key) % newCapacity);
                while (newTable[index] != null) {
                    index = (index + 1) % newCapacity;
                }
                newTable[index] = key;
            }
        }

        table = newTable;
    }

    /*
     * add(key) adds a string to the hashtable
     * and will resize if neccessary.
     * Runtime: O(1)
     */
    public void insert(String key) {
        if (size >= LOAD_FACTOR * table.length) {
            resizeTable();
        }
        System.out.println("inserting HT..."+i);
        i++;
        int index = Math.abs(hash(key));
        while (table[index] != null) {
            index = (index + 1) % table.length;
        }
        table[index] = key;
        size++;
    }

    /*
     * contains(key) is given a string and 
     * attempts to find it in the hashtable.
     * Returns: boolean; whether the search was successful
     * Runtime: O(1)
     */
    public boolean search(String key) {
        int index = Math.abs(hash(key));
        System.out.println("searching HT...");
        while (table[index] != null) {
            if (table[index].equals(key)) {
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }
}

