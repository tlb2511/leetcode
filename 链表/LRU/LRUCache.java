package 链表.LRU;

import java.util.*;

class LRUCache {
    static class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(){}
        Node(int _key,int _value){
            this.key = _key;
            this.value = _value;
            this.next = null;
            this.prev = null;
        }
    }
    static Map<Integer,Node> map;
    static Node head;
    static Node tail;
    static int len;
    static int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        len = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public static int get(int key) {
        if(map.containsKey(key)){
            Node res = map.get(key);
            //把当前节点放到头
            removeNodeToHead(res);
            return res.value;
        }
        return -1;
    }

    public static void put(int key, int value) {
        Node temp = new Node(key,value);
        if(map.containsKey(key)){

            Node replace = map.replace(key, temp);
            //把当前节点放到头
            deleteNode(replace);
            addNode(temp);
        }else{
            //添加新节点
            addNode(temp);
            map.put(key,temp);
            len++;
        }

        if(len > capacity){
            //删除尾节点并获取尾节点的key
            int tkey = deletetTail();
            //根据尾节点的key删除map
            map.remove(tkey);
            len--;
        }
    }

    public static void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public static void removeNodeToHead(Node node){
        deleteNode(node);
        addNode(node);
    }

    public static int deletetTail(){
        int res = tail.prev.key;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return res;
    }

    public static void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public static void main(String[] args) {

        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        int res1 = obj.get(1);
        System.out.println(res1);
        obj.put(3,3);
        int res2 = obj.get(2);
        System.out.println(res2);
    }
}

