// 三件事：连接next, 连接random, 存入hashmap

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = null;
        dummy.next = head;
        HashMap<RandomListNode, RandomListNode> h = new HashMap<>();
        
        
        while(head != null){
            RandomListNode newHead = new RandomListNode(head.label);
            h.put(head, newHead);
            if(head.random != null){
                if(!h.containsKey(head.random)){
                    RandomListNode newNode = new RandomListNode(head.random.label);
                    h.put(head.random, newNode);
                } 
                newHead.random = h.get(head.random);
            }
            if(pre != null){
                h.get(pre).next = h.get(head);
            }
            pre = head;
            head = head.next;
        }
        
        return h.get(dummy.next);
    }
}

// 第二种方法：
每一个node，new出一个newNode，并且 newNode 的 random 和 next 都指向原来 node 的 random 和 next。并把 newNode 加在原来 node 之后。
接下来把 random 归位到应有的 random，并把所有新 node 取出连起来（即 next 归位到应有的 next）。
