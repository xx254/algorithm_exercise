public class ConnectingGraph { 

    private int[] father;
    
    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n+1];
        for(int i=1; i<=n; i++){
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int ra = find(a);
        int rb = find(b);
        if(ra != rb){
            father[ra] = rb;
        }
    }
        
    public boolean query(int a, int b) {
        // find 会保证找到的是最终的
        int ra = find(a);
        int rb = find(b);
        return ra == rb;
      
    }
    
    private int find(int x){
        if(father[x] == x){
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
}