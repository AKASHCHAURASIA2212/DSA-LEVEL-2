class Solution {
    
    public class Pair{
        int x;
        int y ;
        int time;
        
        public Pair(int x,int y,int time){

              this.x=x;
              this.y=y;
              this.time=time;
        }
    }
    
    public void addNBR(int[][] grid,int x,int y ,int time ,Queue<Pair> qu,boolean[][] vis)
    {
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length)
        {
            return;
        }
        
         else if( vis[x][y]==true )
        {
            return;
        }
        else if (grid[x][y]==0)
        {
            return;
        }
        
        qu.add(new Pair(x,y,time+1));
    }
    
    
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int fresh=0;
        
        boolean[][] vis = new boolean[m][n];
        
        Queue<Pair> qu = new LinkedList<>();
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    
                    qu.add(new Pair(i,j,0));
                }
                else if(grid[i][j]==1)
                {
                   fresh++;
                }
            }
        }
        
        int globtime=0;
        
        while(qu.size()>0)
        {
            // r m* w a*
            Pair rem = qu.remove();
            
            if(vis[rem.x][rem.y]==true)
            {
                continue;
            }
            
            vis[rem.x][rem.y]=true;

            if(rem.time>globtime)
            {
                globtime=rem.time;
            }  

            if(grid[rem.x][rem.y]==1)
            {
                fresh--;
            }
            
            addNBR(grid,rem.x+1,rem.y,rem.time,qu,vis);
            addNBR(grid,rem.x-1,rem.y,rem.time,qu,vis);
            addNBR(grid,rem.x,rem.y+1,rem.time,qu,vis);
            addNBR(grid,rem.x,rem.y-1,rem.time,qu,vis);     
        }
        
        if(fresh!=0)
        {
            return -1;
        }
        
        return globtime;
        
    }
}