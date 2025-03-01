package org.advancedjava.dsa.lrucahce;

public class LRUDemo {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        System.out.println(cache.get(1));
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(3, 3);
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(4));
        cache.traverse();
    }
}
