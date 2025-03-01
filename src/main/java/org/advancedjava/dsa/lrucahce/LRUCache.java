package org.advancedjava.dsa.lrucahce;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);
    private final int capacity;
    private final Map<Integer, Node> mp;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        } else {
            Node node = mp.get(key);
            deleteNode(node);
            addNode(node);
            return node.val;
        }
    }

    public void put(int key, int val) {
        if (mp.containsKey(key)) {
            deleteNode(mp.get(key));
        }
        else if (mp.size() == capacity) {
            deleteNode(tail.prev);
        }
        addNode(new Node(key, val));
    }

    private void addNode(Node newNode) {
        Node next = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = next;
        next.prev = newNode;
        mp.put(newNode.key, newNode);
    }

    private void deleteNode(Node delNode) {
        mp.remove(delNode.key);
        Node prev = delNode.prev;
        Node next = delNode.next;
        prev.next = next;
        next.prev = prev;
    }

    public void traverse() {
        Node current = head.next;
        while (current != tail) {
            System.out.println(current.key + " " + current.val);
            current = current.next;
        }
    }
}
