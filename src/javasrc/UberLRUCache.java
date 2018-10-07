package javasrc;

import java.util.HashMap;
import java.util.Map;

public class UberLRUCache {
    // use head tail as boarder
//    class Node {
//        private int key;
//        private Node prev;
//        private Node next;
//        private int value;
//        Node (int key, int value, Node prev, Node next) {
//            this.key = key;
//            this.value = value;
//            this.prev = prev;
//            this.next = next;
//        }
//    }
//    private int size;
//    private Map<Integer, Node> map;
//    private Node head;
//    private Node tail;
//
//    public LRUCache(int capacity) {
//        this.size = capacity;
//        map = new HashMap<>();
//        this.head = new Node(0,0,null,null);
//        this.tail = new Node(0,0,null,null);
//        this.head.next = tail;
//        this.tail.prev = head;
//
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            Node node = map.get(key);
//            update(node);
//            add(node);
//            return node.value;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        // need update key-value (can be the same)
//        if (map.containsKey(key)) {
//            Node node = map.get(key);
//            node.value = value;
//            update(node);
//            add(node);
//            // insert after delete
//        } else {
//            Node node = new Node(key, value, null, null);
//            add(node);
//            map.put(key, node);
//            if (map.size() > size){
//                remove(head.next);
//            }
//        }
//    }
//    private void update(Node node) {
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//
//    }
//
//    private void remove(Node node) {
//        this.map.remove(node.key);
//        update(node);
//        node.next = null;
//        node.prev = null;
//    }
//
//    private void add(Node node) {
//        node.prev = tail.prev;
//        node.prev.next = node;
//        node.next = tail;
//        tail.prev = node;
//
//
//    }


//    // doubly linked list, maintain head and tail
//    // map to track
    class Node {
        private int key;
        private Node prev;
        private Node next;
        private int value;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int size;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    UberLRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // need update key-value (can be the same)
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
            // insert after delete
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
            if (map.size() > size){
                map.remove(head.key);
                remove(head);
            }
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        // single node
        if (head == node  && tail == node) {
            head = tail = null;
        }
        // front node
        else if (node == head) {
            node.next = null;
            next.prev = null;
            head = next;
        }
        // end node
        else if(node == tail) {
            node.prev = null;
            prev.next = null;
            tail = prev;
        } else {
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
        }
    }
    private void add(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    private void moveToTail(Node node) {
        remove(node);
        add(node);
    }

}
