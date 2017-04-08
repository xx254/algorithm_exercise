public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]){
                    bfs(grid, i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    // pass grid
    private void bfs(boolean[][] grid, int row, int col){
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        grid[row][col] = false;
        Queue<Coordinate> q = new LinkedList<Coordinate>();
        
        q.offer(new Coordinate(row, col));
        
        while(!q.isEmpty()){
            Coordinate cur = q.poll();
            for(int i=0; i<4; i++){
                if(!inBound(new Coordinate(cur.x+x[i], cur.y+y[i]), grid)){
                    continue;
                }
                if(grid[cur.x+x[i]][cur.y+y[i]]){
                    grid[cur.x+x[i]][cur.y+y[i]] = false;
                    q.offer(new Coordinate(cur.x+x[i], cur.y+y[i]));
                }
            }
        }
    }
    
    // pass grid 
    private boolean inBound(Coordinate coor, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }
}

// Similar Question - Friend Circle (no AC）
// 试图用同样方法做，只能过一部分test case，因为当收尾序号的人为friend的时候不适用，应该用Union find 来做
public class Solution {
    class Coordinate{
        int x,y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int findCircleNum(int[][] M) {
        int a = M.length;
        int b = M[0].length;
        int count = 0;
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                if(M[i][j] == 1){
                    bfs(i, j, M);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(int row, int col, int[][] M){
        
        int[] x = {0, 0, -1, 1};
        int[] y = {1, -1, 0, 0};
        
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(row, col));
        
        while(!q.isEmpty()){
            Coordinate cur = q.poll();
            M[cur.x][cur.y] = 0;
            
            for(int i=0; i<4; i++){
                int nx = cur.x + x[i];
                int ny = cur.y + y[i];
                if(nx < M.length && ny < M[0].length && nx >=0 && ny >=0 && M[nx][ny] == 1){
                    M[nx][ny] = 0;
                    q.offer(new Coordinate(nx, ny));
                }
            }
        }
    }
}