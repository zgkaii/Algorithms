package list;

import java.util.HashMap;
import java.util.Map;

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
    private DLinkedNode head, tail;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // 伪头部和伪尾部标记界限
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // key不存在，双链表头部创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            // 超容，删除双链表尾节点，删除哈希表中对应项
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
            // 哈希表定位，修改value，移到头部
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

class DLinkedNode {
    public int key;
    public int value;

    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}