package SetsAndMaps;

import java.util.*;

public class LRUCache {

    public static void main(String args[]) {
        LRUCache cache = new LRUCache(5);

        set(0,5);
        set(13,51);
        set(12,17);
        System.out.println(get(6));
        System.out.println(get(13));

        set(15,57);
        set(13,7);
        System.out.println(get(11));
        System.out.println(get(6));
        System.out.println(get(13));
    }

    static class Node {
            int key;
            int val;
            Node prev;
            Node next;
        }

        static Node head = new Node();
        static Node tail = new Node();
        static HashMap<Integer, Node> map;
        static int cache_capacity;
        //Constructor for initializing the cache capacity with the given value.
        LRUCache(int cap)
        {
            map = new HashMap<>(cap);
            cache_capacity = cap;
            head.next = tail;
            tail.prev = head;
        }

        public static void addNode(Node n) {
            Node head_next = head.next;
            n.prev = head;
            head.next = n;
            n.next = head_next;
            head_next.prev = n;

        }

        public static void removeNode(Node n) {
            Node prev = n.prev;
            Node next = n.next;

            prev.next = next;
            next.prev = prev;
        }
        //Function to return value corresponding to the key.
        public static int get(int key)
        {
            int result = -1;
            Node n = map.get(key);
            if(n != null) {
                result = n.val;
                removeNode(n);
                addNode(n);
            }
            return result;
        }

        //Function for storing key-value pair.
        public static void set(int key, int value)
        {
            Node n = map.get(key);
            if(n != null) {
                removeNode(n);
                n.val = value;
                addNode(n);
            }else {
                if(map.size() == cache_capacity) {
                    map.remove(tail.prev.key);
                    removeNode(tail.prev);
                }

                Node new_node = new Node();
                new_node.key = key;
                new_node.val = value;
                map.put(key,new_node);
                addNode(new_node);

            }

        }
}
