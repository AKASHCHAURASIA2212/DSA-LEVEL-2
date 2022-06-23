class Solution {
    
    public static void treverse(int[][] grid,int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
        {
            return;
        }
        else if(grid[i][j]==-1 || grid[i][j]==0){
           return ;
        }
        grid[i][j]=-1;
        treverse(grid,i-1,j);
        treverse(grid,i+1,j);
        treverse(grid,i,j+1);
        treverse(grid,i,j-1);
        
        
    }
    public int numEnclaves(int[][] grid) {
        
        for(int i = 0;i<grid.length;i++)
        {
           for(int j=0;j<grid[0].length;j++)
           {
              if(i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1)
              {
                 if(grid[i][j]==1)
                 {
                    treverse(grid,i,j);
                 }
              }
           }
        }
        int count=0;
        
        for(int i = 0;i<grid.length;i++)
        {
           for(int j=0;j<grid[0].length;j++)
           {
              if(grid[i][j]==1)
              {
                 count++;
              }
           }
        }
        
        
        return count;
        
    }
}