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
