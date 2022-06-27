class Solution {
    
    public class Pair implements Comparable<Pair>{
        int x;
        int y;
        int t;
        public Pair(int x,int y,int t){
            this.x=x;
            this.y=y;
            this.t=t;  
        }
        
        public int compareTo(Pair o)
        {
            return this.t-o.t ;
        }
        
        
    }
    
    public void addNB(int i,int j,int time,boolean[][] vis,int[][] grid,PriorityQueue<Pair> pq)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length )
        {
            return;
        }
        else if(vis[i][j]==true)
        {
            return;
        }
        
        int mytime = grid[i][j];
        
        time = mytime > time ? mytime : time ;
        
        pq.add(new Pair(i,j,time));
    }
    public int swimInWater(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        
        boolean[][] vis = new boolean[m][n] ;
        while(pq.size()>0)
        {
            // r m* w a*
            Pair rem = pq.remove();
            
            if(vis[rem.x][rem.y])
            {
                continue;
            }
            vis[rem.x][rem.y]=true;
            
            if(rem.x==m-1 && rem.y==n-1)
            {
               return rem.t;
            }
            
            addNB(rem.x+1,rem.y,rem.t,vis,grid,pq);
            addNB(rem.x-1,rem.y,rem.t,vis,grid,pq);
            addNB(rem.x,rem.y+1,rem.t,vis,grid,pq);
            addNB(rem.x,rem.y-1,rem.t,vis,grid,pq);
            
        }
        
        return -1;
    }
    
}