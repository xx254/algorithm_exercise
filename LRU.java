public class LRUCache {

    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    // to better search for the node
    HashMap<Integer, Node> h = new HashMap<Integer, Node>();
    
    
    public LRUCache(int capacity) {
        // init head & tail
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!h.containsKey(key)){
            return -1;
        }
        Node n = h.get(key);
        delete(key);
        putToTail(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        // 先判断是否存在，再判断是否到capacity
        if(h.containsKey(key)){
            delete(key);
            h.remove(key);
        }
        // if non-exist, new a node, put to list, put in hashmap
        else{
            if(h.size() == capacity){
                // easily wrong! cautious about neighboring "next"
                // delete first in the list than hashmap due to function delete
                int headnext = head.next.key;
                delete(headnext);
                h.remove(headnext);
            }
        }
       
        Node newNode = new Node(key, value);
        h.put(key, newNode);
        putToTail(newNode);
        
    }
    
    // 这样设计的坏处在于删除 list 中 node 要依赖hashmap
    private void delete(int key){
        Node n = h.get(key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    private void putToTail(Node n){
        // ensure no lost
        n.next = tail;
        n.prev = tail.prev;
        tail.prev.next = n;
        tail.prev = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */