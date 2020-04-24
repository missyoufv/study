package com.collection;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义实现基于LRU算法的线程安全的内存缓存
 */
public class LRUCache<K, V> {


    private HashMap<K, Node> cache = null;

    /**
     * head node
     */
    private Node head = null;

    /**
     * tail node
     */
    private Node tail = null;

    /**
     * lock
     */
    private ReentrantLock lock = new ReentrantLock();

    /**
     *  the default container capacity
     */
    private static int capacity = 1 << 4;

    /**
     * the most container element
     */
    private int limit;


    /**
     * constructor
     */
    LRUCache() {
        this(capacity);
    }


    LRUCache(int capacity) {
        this.limit = capacity ;
        // 防止扩容 ，容器存储元素最大个数 = 扩容阈值 /0.75
        cache = new HashMap<>(capacity << 1);
    }


    public void put(K key, V value) {
        if (key == null) {
            new NullPointerException("key is null");
        }
        try{
            lock.lock();
            Node node = cache.get(key);
            if (node == null) {
                // add element
                if (isFull()) {
                    // is full
                    removeNode(head);
                    cache.remove(head.getKey());
                }
                Node nNode = new Node(key, value,null,null);
                addNode(nNode);
                cache.put(key, nNode);
            } else {
                // node is exist
                node.setValue(value);
                addNode2Tail(node);
            }
        }finally {
            lock.unlock();
        }
    }

    /**
     * get the element
     *
     * @param key
     * @return
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }
        try {
            lock.lock();
            Node node = cache.get(key);
            if (node == null) {
                return null;
            }
            addNode2Tail(node);
            return node.getValue();
        } finally {
            lock.unlock();
        }
    }

    /**
     * remove the emelment
     * @param key
     * @return
     */
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        try {
            lock.lock();
            Node node = cache.get(key);
            if (node == null) {
                return null;
            }
            removeNode(node);
            cache.remove(node.getKey());
            return node.getValue();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 迭代缓存的元素
     */
    public void print() {
        lock.lock();
        try {
            Node current = head;
            while (current != null) {
                System.out.println("key : "+ current.getKey()+" value: "+current.getValue());
                current = current.next;
            }
        } finally {
            lock.unlock();
        }

    }

    /**
     * remove the node
     *
     * @param node
     */
    private void removeNode(Node node) {
        Node pre = node.getPre();
        Node next = node.getNext();
        node.setPre(null);
        node.setNext(null);
        if (pre == null) {
            head = next;
        } else {
            pre.setNext(next);
        }
        if (next == null) {
            tail = pre;
        } else {
            next.setPre(pre);
        }
    }


    /**
     * add the element to tail
     * @param node
     */
    private void addNode2Tail(Node node) {

        if (node == tail) {
            return;
        }
        //delete the node
        removeNode(node);
        addNode(node);
    }

    /**
     * is full the contailer
     *
     * @return
     */
    private boolean isFull() {
        return cache.size() >= limit;
    }

    /**
     * add node
     * @param key
     * @param value
     * @return
     */
    private void addNode(Node node) {

        if (tail != null) {
            tail.setNext(node);
            node.setPre(tail);
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }
    class Node{
        private K key;
        private V value;
        private Node pre;
        private Node next;

        public Node(K key, V value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public Node() {}


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {

        LRUCache<String, String> cache = new LRUCache<>();
        for (int i = 1; i <= 20; i++) {
            cache.put("i"+i,"good"+i);
        }
        cache.remove("i10");
        cache.put("i3", "第三名");
        cache.put("i20","第二名");
        System.out.println("===========读取key为i10 之后的顺序"+cache.get("i10"));
        cache.print();
    }

}
