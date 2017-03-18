/*
 *关联题目：83. Remove Duplicates from Sorted List
 *相同：
    1. 在有duplicate的时候都引入了p，用来移动，因为duplicate可能有一长串。
    2. 都有两个version，且思路相同
 *不同：  
    head不确定的时候引入假点dummy
    VERSION 2 中虽然是每个while循环都进行了处理/移动，但是里面增加了一个while循环
 *疑问：
 */

// VERSION 1: 暂时不移动

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        List<Integer> path = new ArrayList<Integer>();
        dfs(res, path, nums);
        
        return res;
    }
    

    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums){

        if(path.size() == nums.length){         //error1: path.size() 不是length
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){   //error2: 没有pos了
            if(path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            dfs(res, path, nums);
            path.remove(path.size() - 1);
        }
        
    }
}

// VERSION 2: 每次while循环都移动一下

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
            
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode node = dummy;
        
        while(node.next != null && node.next.next != null){
            if(node.next.val == node.next.next.val){
                int val = node.next.val;
                while(node.next != null && node.next.val == val){
                    node.next = node.next.next;
                }
            }
                
            else{
                node = node.next;
            }
        }
        return dummy.next;
    }
}

