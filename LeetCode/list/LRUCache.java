package list;

import java.util.HashMap;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/19 21:39
 * @Description: 146. LRU 缓存机制 https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * LRU是Least Recently Used的缩写，即最近最少使用，是一种常用的页面置换算法，选择最近最久未使用的页面予以淘汰。
 * 该算法赋予每个页面一个访问字段，用来记录一个页面自上次被访问以来所经历的时间t，当须淘汰一个页面时，选择现有页面中其t值最大的，即最近最少使用的页面予以淘汰。
 * <p>
 * LRUCache cache = new LRUCache(2);
 * cache.put(1, 1);     // cache = [(1, 1)]
 * cache.put(2, 2);     // cache = [(2, 2), (1, 1)]
 * cache.get(1);        // 返回 1 cache = [(1, 1), (2, 2)]
 * cache.put(3, 3);     // cache = [(3, 3), (1, 1)]
 **/
public class LRUCache {
    private int capacity;
    private int size;
    DLinkedNode head, tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        map = new HashMap<>();

    }

    private void add(DLinkedNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {
        return;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
    }
}

class DLinkedNode {
    private int key;
    private int value;

    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}