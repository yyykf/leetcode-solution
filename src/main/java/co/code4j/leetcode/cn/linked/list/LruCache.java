package co.code4j.leetcode.cn.linked.list;

import java.util.*;
import lombok.*;

/**
 * @Description
 * @Author yukf02
 * @Date 2023/10/28 14:59
 */
public class LruCache<T> {

    public static void main(String[] args) {
        LruCache<Integer> cache = new LruCache<>(2);
        // LruCache<Integer> cache = new LruCache<>(1);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            cache.cache(random.nextInt(5));
            System.out.println(cache);
        }

    }

    private static final int DEFAULT_CAPACITY = 1 << 4;

    private LruCacheNode<T> head;
    private LruCacheNode<T> tail;
    /** current size of node */
    private int size;
    /** capacity of cache */
    private final int capacity;

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder("[");

        LruCacheNode<T> current = head;
        while (current != null) {
            sb.append(current.data).append("->");

            current = current.next;
        }

        sb.delete(sb.length() - 2, sb.length()).append("]");

        return sb.toString();
    }

    public LruCache() {
        this(DEFAULT_CAPACITY);
    }

    public LruCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0.");
        }

        this.size = 0;
        this.capacity = capacity;
    }

    public void cache(T data) {
        System.out.printf("put %s into cache.%n", data);
        /*
            1. 首先看元素在不在缓存中
                1.1 如果在缓存中，那么将其移动到链表头。不用管缓存大小，因为不涉及到元素数量的变化。
                1.2 如果不在缓存中，那么看缓存满了没有
                    1.2.1 缓存满了，那么移除尾结点，并将元素插入到链表头
                    1.2.2 缓存未满，那么直接插入到链表头
         */

        if (head == null) {
            // 缓存为空，直接放入缓存
            this.insertToHead(new LruCacheNode<>(data));
            size++;
            return;
        }

        // 查找目标结点和前驱结点
        LruCacheNode<T> current = head;

        do {
            if (Objects.equals(current.data, data)) {
                break;
            }

            current = current.next;
        } while (current != null);

        if (current != null) {
            // 命中缓存，调整位置
            if (current.prev == null) {
                // 前驱结点为空代表元素已经在链表头了
                return;
            }

            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            // 调整尾结点
            if (tail == current){
                tail = current.prev;
            }
            this.insertToHead(current);
        } else {
            // 未命中缓存
            if (size < capacity) {
                // 缓存未满，直接插入到链表头
                this.insertToHead(new LruCacheNode<>(data));
                size++;
            } else {
                // 缓存已满，删除尾结点，插入链表头
                if (tail.prev == null) {
                    // 尾结点的前驱结点为空，那么说明只有一个元素，尾结点就是 head
                    tail = null;
                    head = null;
                } else {
                    tail.prev.next = null;
                    tail = tail.prev;
                }

                this.insertToHead(new LruCacheNode<>(data));
            }
        }
    }

    private void insertToHead(LruCacheNode<T> node) {
        Objects.requireNonNull(node, "node is null");

        if (head != null) {
            head.prev = node;
        }
        if (tail == null) {
            tail = node;
        }

        node.prev = null;
        node.next = head;
        head = node;
    }

    @Data
    static class LruCacheNode<T> {

        private T data;
        private LruCacheNode<T> next;
        private LruCacheNode<T> prev;

        public LruCacheNode(T data) {
            this.data = data;
        }
    }

}
