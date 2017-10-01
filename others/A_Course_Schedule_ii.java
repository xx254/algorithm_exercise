// 从queue中出来的是object，要转换成 int
// ArrayList[] 的声明和初始化

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<Integer>[] list = new ArrayList[numCourses];
        Queue q = new LinkedList();
        int[] res = new int[numCourses];
        int count = 0;
        
        for(int i=0; i<numCourses; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<prerequisites.length; i++){
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            in[post] = in[post] + 1;
            list[pre].add(post);
        }
        
        for(int i=0; i<in.length; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = (int)q.poll();
            for(int post : list[cur]){
                in[post]--;
                if(in[post] == 0){
                    q.add(post);
                }
            }
            res[count] = cur;
            count++;
        }
        
        if(count == numCourses){
            return res;
        } else {
            return new int[0];
        }
        
    }
}
