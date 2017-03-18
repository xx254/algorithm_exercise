/*
 * 题目：83. Remove Duplicates from Sorted List
 * 题意：去重
 * 思路：
 * 时间复杂度： O(n)
 * 空间复杂度： O(1)
 * 相关题目：
 			
 * special case: 最后几个数相等，最后要连到null
 * 哪些条件提示我想到这个解法： 
 * 模板：(VERSION 2：每次都做处理)
            node.next = node.next.next;     //但是不移动node
 * 注意事项：
 	比较容易出错的地方在于if和else的使用。
 	最不容易出错的是在一个while里面只做一件事，即要么“不能把else if错写成if”，要么“每次完成操作而不是保存实力”。
}  
 */




// VERSION 1: 如果遇到重复的，当前node直接连到下下个（即使下下个也重复）

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}

// VERSION 2: 思路相同，只是用p来记录移动

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null)
            return head;
            
        ListNode last = head;
        ListNode p = head.next;
        
        while(p != null){
            if(p.val == last.val){
                p = p.next;
                last.next = p;
            }
            else{
                last.next = p;
                last = last.next;
            }
        }
        return head;
    }
}


// VERSION 3: 被抛弃的AC代码。

// 在也增加了一个p，但是每次操作不直接连，只是移动。这样的话就要额外判断是否已到了最后，分为两种情况。
// 总是下一位相同和不同分为两种。其中相同的又分为到达最后和不到最后两种。
// 之所以比较乱，是因为while循环里面套了while循环，所以大while里面的条件已经不满足了。

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        
        ListNode cur = head;
    
        while(cur.next != null){
            // 相等
            if(cur.val == cur.next.val){        
                ListNode p = cur.next;
                // 相等 并且 没到末尾
                while(p != null && p.val == cur.val){
                    p = p.next;
                }
                // 相等 并且 到达末尾
                if(p == null){
                    cur.next = p;
                }
                // 不等 因为while的移动但是没到末尾
                else{   
                    cur.next = p;
                    cur = cur.next;
                }
            }
            // 不等
            else{
                cur = cur.next;
            }    
        }
        return head;
        
    }
}