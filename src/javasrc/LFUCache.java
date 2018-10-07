package javasrc;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

public class LFUCache {
    // node class to store keys with same frequency using linked hashSet(maintain insertion order)
    // doubly linked list to contain nodes in the order of frequency, keep head(lowest frequency)
    // 2 hashmaps, one to store key-value; one for key-node
    // adjust frequency: append directly, insert into next node, insert a new node in between
    // remove: remove a key targeted using iterator; remove a node when it's empty
    Node head = null;
    final int capacity;
    Map<Integer, Integer> valueMap = new HashMap<>();
    Map<Integer, Node> nodeMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) increase(key);
        return valueMap.getOrDefault(key, -1);
    }

    private void increase(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (Objects.isNull(node.next)) node.next = new Node(node, null, node.count + 1, key);
        else if (node.next.count == node.count + 1) node.next.keys.add(key);
        else node.next = node.next.prev = new Node(node, node.next, node.count + 1, key);
        nodeMap.put(key, node.next);
        if (node.keys.isEmpty()) remove(node);
    }

    private void remove(Node node) {
        if (head == node) head = node.next;
        else node.prev.next = node.next;
        if (Objects.nonNull(node.next)) node.next.prev = node.prev;
    }

    public void set(int key, int value) {
        if (0 == this.capacity) return;
        if (Objects.nonNull(valueMap.put(key, value))) increase(key);
        else {
            if (nodeMap.size() == this.capacity) remove();
            add(key);
        }
    }

    private void add(int key) {
        if (Objects.isNull(head)) head = new Node(null, null, 1, key);
        else if (head.count == 1) head.keys.add(key);
        else head = head.prev = new Node(null, head, 1, key);
        nodeMap.put(key, head);
    }

    private void remove() {
        int oldest = head.keys.iterator().next();
        head.keys.remove(oldest);
        if (head.keys.isEmpty()) remove(head);
        nodeMap.remove(oldest);
        valueMap.remove(oldest);
    }

    class Node {
        public Node prev, next;
        public final int count;
        public LinkedHashSet<Integer> keys = new LinkedHashSet<>();

        public Node(Node prev, Node next, int count, int key) {
            this.prev = prev;
            this.next = next;
            this.count = count;
            keys.add(key);
        }
    }
}
