package org.advancedjava.lld.designHashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Node<K, V> {
    K key;
    V value;
    Node next;
    Node prev;

    Node(K key, V value) {
        this.key = key;
        this.value = value;

    }
}

// hashMap = {(key1, val1), (key2, val2)}
// hashSet = { key1, key2 }

//as we have implemented hashMap the same way we can do for hashSet as it is same only difference
//is that map stores key-value pair and hashSet stores single value only.

public class CustomHashMap<K, V> {
    private final int INITIAL_SIZE = 10; //size of the map initially
    /*
        2^30 as the array that we are using to construct a HashMap also has some limit
        as we cannot scale that array indefinitely. So above this limit we can simply say that
        we cannot perform reHash function becoz reHash fun is the one which doubles the size of the array.
    */
    private final int MAX_CAPACITY = 1 << 30;
    private final float LOAD_FACTOR = 0.75f;
    private int countOfNodes = 0;

    //Array of Nodes(which is a doubly linkedList)
    private Node[] map;

    public CustomHashMap() {
        this.map = new Node[INITIAL_SIZE];
        for (int i = 0; i < INITIAL_SIZE; i++) {
            //So initially each array element is a node and we are setting head-tail for each node
            //and our initial set-up is head.next->tail, tail.prev->head and both head and tail has key,
            //value as null and when we insert values in our hashMap then we will insert in b/w
            //head and tail this is our initial set-up

            //creating head node
            map[i] = new Node<>(null, null);
            //pointing head.next to tail also first creating tail node
            map[i].next = new Node<>(null, null);
            //pointing tail.prev to head(and head is map[i])
            map[i].next.prev = map[i];
        }
    }

    public V get(K key) {
        Node node = findNode(key);
        return node == null ? null : (V) node.value;
    }
    
    public void put(K key, V value) {
        Node node = findNode(key);
        if (node != null) {
            node.value = value;
            return;
        }

        int bucket = (key.hashCode() & 0x7FFFFFFF) % map.length;
        Node head = map[bucket];
        Node nextNode = head.next;

        Node newNode = new Node<>(key, value);
        head.next = newNode;
        newNode.prev = head;
        newNode.next = nextNode;
        nextNode.prev = newNode;

        countOfNodes++;

        if (countOfNodes > LOAD_FACTOR * map.length) {
            reHash(map.length * 2);
        }
    }

    public void remove(K key) {
        Node nodeToRemove = findNode(key);
        if (nodeToRemove == null) {
            return;
        }

        Node nextNode = nodeToRemove.next;
        Node prevNode = nodeToRemove.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        countOfNodes--;
    }

    public int getSize() {
        return countOfNodes;
    }

    private void reHash(int newSize) {
        if (newSize > MAX_CAPACITY) {
            System.out.println("HashMap is exceeding maximum capacity");
            return;
        }

        Node[] newMap = new Node[newSize];
        for (int i = 0; i < newSize; i++) {
            //creating head node
            newMap[i] = new Node<>(null, null);
            //pointing head.next to tail also first creating tail node
            newMap[i].next = new Node<>(null, null);
            //pointing tail.prev to head(and head is newMap[i])
            newMap[i].next.prev = map[i];
        }

        for (Node curr : map) {
            while (curr != null) {
                //ignore head and tail
                if (curr.key == null) {
                    curr = curr.next;
                    continue;
                }

                int bucket = (curr.key.hashCode() & 0x7FFFFFFF) % newSize;
                Node newHead = newMap[bucket];
                Node nextNode = newHead.next;

                // note down curr's next
                Node currNextNode = curr.next;

                newHead.next = curr;
                curr.prev = newHead;
                curr.next = nextNode;
                nextNode.prev = curr;

                curr = currNextNode;
            }
        }

        map = newMap;
    }

    public Node findNode(K key) {
        //get the bucketNumber or Index
//        int bucket = key.hashCode() % map.length;
        /*
        Using Math.abs() can still cause issues in rare cases because Math.abs(Integer.MIN_VALUE)
        remains negative due to overflow. A safer approach is:
         */
        int bucket = (key.hashCode() & 0x7FFFFFFF) % map.length;
//        System.out.println(bucket + "  " + key.hashCode() + "   " + map.length);
        Node head = map[bucket];

        //once we get the bucket then iterate through head and if we get the key then return
        while (head != null) {
            if (head.key != null && head.key.equals(key)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

}
